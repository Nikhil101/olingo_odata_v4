package odata.util;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.olingo.commons.api.data.Entity;
import org.apache.olingo.commons.api.data.EntityCollection;
import org.apache.olingo.commons.api.data.Property;
import org.apache.olingo.commons.api.data.ValueType;
import org.apache.olingo.commons.api.edm.EdmPrimitiveTypeKind;
import org.apache.olingo.commons.api.edm.FullQualifiedName;
import org.apache.olingo.commons.api.ex.ODataRuntimeException;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import odata.service.OdataEntityProcessor;

public class Utils {
	public static final String packageToScan = "odata.model";
	private static final Logger logger = LoggerFactory.getLogger(Utils.class);
	@SuppressWarnings("serial")
	public static final Map<String, FullQualifiedName> dataTypeObj = new HashMap<String, FullQualifiedName>() {

		{
			put("Integer", EdmPrimitiveTypeKind.Int64.getFullQualifiedName());
			put("String", EdmPrimitiveTypeKind.String.getFullQualifiedName());
			put("long", EdmPrimitiveTypeKind.Int64.getFullQualifiedName());
			put("BigDecimal", EdmPrimitiveTypeKind.Int64.getFullQualifiedName());
			put("Timestamp", EdmPrimitiveTypeKind.DateTimeOffset.getFullQualifiedName());

		}
	};

	/**
	 * Scans all classes accessible from the context class loader which belong to
	 * the given package and subpackages.
	 *
	 * @param packageName
	 *            The base package
	 * @return The classes
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public static List<String> getClasses(String packageName) throws ClassNotFoundException, IOException {
		logger.info("Fetching entity classes");
		Reflections reflections = new Reflections(packageName);
		Set<Class<? extends Serializable>> subTypes = reflections.getSubTypesOf(Serializable.class);
		System.out.println("subTypes - " + subTypes);
		return subTypes.stream().map(c -> c.getSimpleName()).collect(Collectors.toList());
	}

	/**
	 * @param dataList
	 * @param classFields
	 * @return
	 */
	public static EntityCollection makeEntityCollection(List<?> dataList, Field[] classFields) {
		EntityCollection entitySet = new EntityCollection();
		try {
			for (int i = 0; i < dataList.size(); i++) {
				entitySet.getEntities().add(createEntity(dataList.get(i), classFields));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entitySet;
	}

	public static Entity createEntity(Object tableRow, Field[] classFields) {
		Entity entityObj = new Entity();
		try {
			if (classFields != null && classFields.length > 0) {
				for (Field fieldObj : classFields) {
					try {
						fieldObj.setAccessible(true);
						if (fieldObj.get(tableRow) != null) {
							entityObj.addProperty(new Property(null, fieldObj.getName(), ValueType.PRIMITIVE,
									fieldObj.get(tableRow)));
						}

					} catch (IllegalArgumentException | IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				entityObj.setId(createId(tableRow.getClass().getSimpleName(), 1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entityObj;
	}

	public static URI createId(String entitySetName, Object id) {
		try {
			return new URI(entitySetName + "(" + String.valueOf(id) + ")");
		} catch (URISyntaxException e) {
			throw new ODataRuntimeException("Unable to create id for entity: " + entitySetName, e);
		}
	}
}
