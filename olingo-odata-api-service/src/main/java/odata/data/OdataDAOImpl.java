package odata.data;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.olingo.commons.api.data.Entity;
import org.apache.olingo.commons.api.edm.EdmEntitySet;
import org.apache.olingo.server.api.uri.UriParameter;
import org.eclipse.persistence.internal.jpa.EJBQueryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import odata.service.PersistenceManager;
import odata.util.Utils;

//@Repository
//@Transactional
public class OdataDAOImpl implements OdataDAO {
	private static final Logger logger = LoggerFactory.getLogger(Utils.class);

	@Override
	public List<?> getAllData(EdmEntitySet edmEntitySet, Class<?> reflect) {
		EntityManager entityManager = PersistenceManager.INSTANCE.getEntityManager();

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<?> criteria = builder.createQuery(reflect);
		Root<?> tableName = criteria.from(reflect);

		criteria.multiselect(tableName);
		TypedQuery<?> query = entityManager.createQuery(criteria);

		List<?> dataList = query.getResultList();
		
		// Getting table annotation
		/*
		 * Table tableObj=reflect.getAnnotation(Table.class);
		 * System.out.println(tableObj.name());
		 */

		return dataList;
	}

	@Override
	public Entity getKeyData(EdmEntitySet edmEntitySet, Class<?> reflect, List<UriParameter> keyParams) {
		// TODO Auto-generated method stub
		Entity entity = new Entity();
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();

		// Below we implement java reflection

		CriteriaQuery<?> criteria = builder.createQuery(reflect);
		Root<?> tableName = criteria.from(reflect);
		Field[] classFields = null;
		classFields = reflect.getDeclaredFields();
		List<Predicate> predicates = new ArrayList<Predicate>();

		for (final UriParameter key : keyParams) {
			// key
			String keyName = key.getName();
			String keyText = key.getText();
			predicates.add(builder.equal(tableName.get(keyName), keyText));

		}
		criteria.multiselect(tableName).where(predicates.toArray(new Predicate[] {}));
		TypedQuery<?> query = em.createQuery(criteria);

		List<?> dataList = query.getResultList();
		
		if (dataList.size() > 0 && dataList != null) {
			entity = Utils.createEntity(dataList.get(0), classFields);
			return entity;
		}
		logger.debug(query.unwrap(EJBQueryImpl.class).getDatabaseQuery().getSQLString());
		return null;
	}

	@Override
	public long getCount(EdmEntitySet edmEntitySet, Class<?> reflect) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();

		TypedQuery<?> query = em.createQuery("Select count(s) from " + reflect.getSimpleName() + " s", reflect);

		// long count = (long) query.getSingleResult();
		long count = 0L;
		// LOG.debug(query.unwrap(EJBQueryImpl.class).getDatabaseQuery().getSQLString());
		
		return count;

	}

	@Override
	public List<?> getSkip(int skipNumber, Class<?> reflect) {
		// TODO Auto-generated method stub
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<?> criteria = builder.createQuery(reflect);
		Root<?> tableName = criteria.from(reflect);
		criteria.multiselect(tableName);
		TypedQuery<?> query = em.createQuery(criteria);

		List<?> dataList = query.setFirstResult(skipNumber).getResultList();
		
		logger.debug(query.unwrap(EJBQueryImpl.class).getDatabaseQuery().getSQLString());
		return dataList;
	}

	@Override
	public List<?> getTop(int topNumber, Class<?> reflect) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<?> criteria = builder.createQuery(reflect);
		Root<?> tableName = criteria.from(reflect);
		criteria.multiselect(tableName);
		TypedQuery<?> query = em.createQuery(criteria);

		List<?> dataList = query.setMaxResults(topNumber).getResultList();
		return dataList;
	}

	@Override
	public List<?> getSelect(EdmEntitySet edmEntitySet, Class<?> reflect, String selectItems) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		TypedQuery<?> query = (TypedQuery<?>) em
				.createNativeQuery("Select " + selectItems + " from " + reflect.getSimpleName());
		List<?> dataList = query.getResultList();
		logger.debug(query.unwrap(EJBQueryImpl.class).getDatabaseQuery().getSQLString());

		return dataList;
	}

}
