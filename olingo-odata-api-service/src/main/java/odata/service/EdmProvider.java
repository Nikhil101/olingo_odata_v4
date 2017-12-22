
package odata.service;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.commons.lang3.StringUtils;
import org.apache.olingo.commons.api.edm.FullQualifiedName;
import org.apache.olingo.commons.api.edm.provider.CsdlAbstractEdmProvider;
import org.apache.olingo.commons.api.edm.provider.CsdlEntityContainer;
import org.apache.olingo.commons.api.edm.provider.CsdlEntityContainerInfo;
import org.apache.olingo.commons.api.edm.provider.CsdlEntitySet;
import org.apache.olingo.commons.api.edm.provider.CsdlEntityType;
import org.apache.olingo.commons.api.edm.provider.CsdlProperty;
import org.apache.olingo.commons.api.edm.provider.CsdlPropertyRef;
import org.apache.olingo.commons.api.edm.provider.CsdlSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import odata.util.Utils;

/**
 * this class is supposed to declare the metadata of the OData service it is
 * invoked by the Olingo framework e.g. when the metadata document of the
 * service is invoked e.g.
 * http://localhost:8080/ExampleService1/ExampleService1.svc/$metadata
 */
public class EdmProvider extends CsdlAbstractEdmProvider {

	// Service namespace
	private static String namespace;

	// EDM Container
	private static String containerName;
	private static FullQualifiedName container;

	// Entity Types Names
	private static List<String> entityTypeName;
	private static Map<String, FullQualifiedName> entityTypeFQN;

	// Entity Set Names
	private static List<String> entitySetName;
	private static final Logger logger = LoggerFactory.getLogger(EdmProvider.class);
	static {
		try {
			namespace = "odata.model";
			containerName = "Container";
			container = new FullQualifiedName(namespace, containerName);
			entityTypeFQN = new HashMap<String, FullQualifiedName>();
			entitySetName = new ArrayList<String>();
			entityTypeName = Utils.getClasses(Utils.packageToScan);
			if (entityTypeName != null && entityTypeName.size() > 0) {
				for (String etNamesObj : entityTypeName) {
					FullQualifiedName fqn = new FullQualifiedName(namespace, etNamesObj.toString());
					if (fqn != null) {
						entityTypeFQN.put(etNamesObj.toString(), fqn);
					}
					entitySetName.add(etNamesObj);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<CsdlSchema> getSchemas() {
		logger.info("Creating schema - Schema is the root element to carry the elements");
		// create Schema
		CsdlSchema schema = new CsdlSchema();
		schema.setNamespace(namespace);

		// add EntityTypes
		List<CsdlEntityType> entityTypes = new ArrayList<CsdlEntityType>();
		if (!entityTypeFQN.isEmpty()) {
			for (Map.Entry<String, FullQualifiedName> entry : entityTypeFQN.entrySet()) {
				entityTypes.add(getEntityType(entry.getValue()));
			}
		}
		schema.setEntityTypes(entityTypes);

		// add EntityContainer
		schema.setEntityContainer(getEntityContainer());

		// finally
		List<CsdlSchema> schemas = new ArrayList<CsdlSchema>();
		schemas.add(schema);

		return schemas;
	}

	@Override
	public CsdlEntityType getEntityType(FullQualifiedName entityTypeName) {

		// this method is called for one of the EntityTypes that are configured in the
		// Schema
		logger.info("Building the structure for different entities in $metadata");
		Class<?> reflect = null;
		List<CsdlProperty> csdlArrayList = new ArrayList<CsdlProperty>();
		if (entityTypeName != null) {

			try {
				reflect = Class.forName(entityTypeName.getFullQualifiedNameAsString());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if (reflect != null) {
			Field[] fields = reflect.getDeclaredFields();
			CsdlPropertyRef propertyRef = new CsdlPropertyRef();
			logger.info("Fetching datatypes");
			for (Field fieldObj : fields) {
				// create EntityType properties based on fieldObj
				csdlArrayList.add(new CsdlProperty().setName(fieldObj.getName())
						.setType(getDataType(fieldObj.getType().getSimpleName())));
				// Below logic is to check for annotations and to set property reference if any
				// field in class got @ID property
				for (Annotation annotationObj : fieldObj.getDeclaredAnnotations()) {
					if (annotationObj.annotationType().getName().equals(javax.persistence.Id.class.getName())) {

						propertyRef.setName(fieldObj.getName());
					}
				}
			}
			CsdlEntityType entityType = new CsdlEntityType();
			entityType.setName(entityTypeName.getName());
			entityType.setProperties(csdlArrayList);
			if (StringUtils.isNotBlank(propertyRef.getName())) {
				entityType.setKey(Collections.singletonList(propertyRef));
			}
			return entityType;

		}
		logger.info("Unable to fetch entities and creation of metadata");
		return null;
	}

	public FullQualifiedName getDataType(String dataTypeName) {
		
		FullQualifiedName fqnDataType = null;
		Iterator<Entry<String, FullQualifiedName>> iterator = Utils.dataTypeObj.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, FullQualifiedName> entry = iterator.next();
			if (entry.getKey().equals(dataTypeName)) {
				return entry.getValue();
			}
		}

		return fqnDataType;
	}

	@Override
	public CsdlEntitySet getEntitySet(FullQualifiedName entityContainer, String entitySetName) {

		if (entityContainer.equals(container)) {
			for (Map.Entry<String, FullQualifiedName> entry : entityTypeFQN.entrySet()) {
				if (entitySetName.equals(entry.getKey())) {
					CsdlEntitySet entitySet = new CsdlEntitySet();
					entitySet.setName(entry.getKey());
					entitySet.setType(entry.getValue());
					return entitySet;
				}
			}
		}
		return null;
	}

	@Override
	public CsdlEntityContainer getEntityContainer() {

		// create EntitySets
		List<CsdlEntitySet> entitySets = new ArrayList<CsdlEntitySet>();
		for (String esNameObj : entitySetName) {
			logger.info("Creating entitySet");
			entitySets.add(getEntitySet(container, esNameObj));
		}
		// entitySets.add(getEntitySet(container, entitySetName));

		// create EntityContainer
		CsdlEntityContainer entityContainer = new CsdlEntityContainer();
		entityContainer.setName(containerName);
		entityContainer.setEntitySets(entitySets);

		return entityContainer;
	}

	@Override
	public CsdlEntityContainerInfo getEntityContainerInfo(FullQualifiedName entityContainerName) {

		// This method is invoked when displaying the service document at e.g.
		// http://localhost:8080/DemoService/DemoService.svc
		if (entityContainerName == null || entityContainerName.equals(container)) {
			CsdlEntityContainerInfo entityContainerInfo = new CsdlEntityContainerInfo();
			entityContainerInfo.setContainerName(container);
			return entityContainerInfo;
		}

		return null;
	}
}
