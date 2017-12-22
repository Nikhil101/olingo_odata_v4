package odata.service;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.olingo.commons.api.data.ContextURL;
import org.apache.olingo.commons.api.data.EntityCollection;
import org.apache.olingo.commons.api.data.ContextURL.Suffix;
import org.apache.olingo.commons.api.edm.EdmEntitySet;
import org.apache.olingo.commons.api.edm.EdmEntityType;
import org.apache.olingo.commons.api.format.ContentType;
import org.apache.olingo.commons.api.http.HttpHeader;
import org.apache.olingo.commons.api.http.HttpStatusCode;
import org.apache.olingo.server.api.OData;
import org.apache.olingo.server.api.ODataApplicationException;
import org.apache.olingo.server.api.ODataRequest;
import org.apache.olingo.server.api.ODataResponse;
import org.apache.olingo.server.api.ServiceMetadata;
import org.apache.olingo.server.api.processor.EntityCollectionProcessor;
import org.apache.olingo.server.api.serializer.EntityCollectionSerializerOptions;
import org.apache.olingo.server.api.serializer.EntitySerializerOptions;
import org.apache.olingo.server.api.serializer.ODataSerializer;
import org.apache.olingo.server.api.serializer.SerializerException;
import org.apache.olingo.server.api.serializer.SerializerResult;
import org.apache.olingo.server.api.uri.UriInfo;
import org.apache.olingo.server.api.uri.UriResource;
import org.apache.olingo.server.api.uri.UriResourceEntitySet;
import org.apache.olingo.server.api.uri.queryoption.CountOption;
import org.apache.olingo.server.api.uri.queryoption.ExpandOption;
import org.apache.olingo.server.api.uri.queryoption.SelectOption;
import org.apache.olingo.server.api.uri.queryoption.SkipOption;
import org.apache.olingo.server.api.uri.queryoption.TopOption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import odata.data.OdataDAOImpl;
import odata.util.Utils;

/**
 * This class is invoked by the Olingo framework when the the OData service is
 * invoked order to display a list/collection of data (entities). This is the
 * case if an EntitySet is requested by the user. Such an example URL would be:
 * http://localhost:8080/ExampleService1/ExampleService1.svc/Products
 */
/*
 * @Configurable
 * 
 * @Service
 */
public class OdataEntityCollectionProcessor implements EntityCollectionProcessor {

	OdataDAOImpl odataDaoImplObj = new OdataDAOImpl();
	private OData odata;
	private ServiceMetadata serviceMetadata;
	
	private static final Logger logger = LoggerFactory.getLogger(OdataEntityCollectionProcessor.class);

	// our processor is initialized with the OData context object
	public void init(OData odata, ServiceMetadata serviceMetadata) {
		this.odata = odata;
		this.serviceMetadata = serviceMetadata;
	}

	// the only method that is declared in the EntityCollectionProcessor interface
	// this method is called, when the user fires a request to an EntitySet

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.olingo.server.api.processor.EntityCollectionProcessor#
	 * readEntityCollection(org.apache.olingo.server.api.ODataRequest,
	 * org.apache.olingo.server.api.ODataResponse,
	 * org.apache.olingo.server.api.uri.UriInfo,
	 * org.apache.olingo.commons.api.format.ContentType)
	 */
	public void readEntityCollection(ODataRequest request, ODataResponse response, UriInfo uriInfo,
			ContentType responseFormat) throws ODataApplicationException, SerializerException {
		logger.info("Read method executing for getting data");
		// 1st we have retrieve the requested EntitySet from the uriInfo object
		// (representation of the parsed service URI)
		List<UriResource> resourcePaths = uriInfo.getUriResourceParts();
		UriResourceEntitySet uriResourceEntitySet = (UriResourceEntitySet) resourcePaths.get(0);
		EdmEntitySet edmEntitySet = uriResourceEntitySet.getEntitySet();

		// 2nd: fetch the data from backend for this requested EntitySetName // it has
		// to be delivered as EntitySet object
		List<?> dataList = new ArrayList<>();
		Class<?> reflect = null;
		Field[] classFields = null;
		List<String> classFieldsName = new ArrayList<String>();
		EntityCollection entityCollection = new EntityCollection();
		// Below we implement java reflection
		try {
			String classname = Utils.packageToScan + "." + edmEntitySet.getName();
			reflect = Class.forName(classname);
			classFields = reflect.getDeclaredFields();
			for (Field fieldObj : classFields) {
				classFieldsName.add(fieldObj.getName());
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TO-DO - Replace this method with method written in OdataDAOImpl using
		// Autowiring of spring
		CountOption countOption = uriInfo.getCountOption();
		SkipOption skipOption = uriInfo.getSkipOption();
		TopOption topOption = uriInfo.getTopOption();
		SelectOption selectOption = uriInfo.getSelectOption();
		// Where $top and $skip are used together, $skip MUST be applied before $top,
		// regardless of the order in which they appear in the request.

		/*
		 * TO-DO - Currently the selectOption brings all data from database and then
		 * only selected options are showed. However, this implementation has to be made
		 * dynamic where we have to hit actual select query with column specified.
		 */

		/*
		 * if (selectOption != null) { String selectString = selectOption.getText();
		 * List<String> selectItems = Arrays.asList(selectString.split(",")); Boolean
		 * matchSelectItems = classFieldsName.containsAll(selectItems); if
		 * (matchSelectItems) { dataList = odataDaoImplObj.getSelect(edmEntitySet,
		 * reflect, selectString); if (dataList != null && dataList.size() > 0) {
		 * entityCollection = Utils.makeEntityCollection(dataList, classFields); } else
		 * { throw new ODataApplicationException("Invalid or no data",
		 * HttpStatusCode.BAD_REQUEST.getStatusCode(), Locale.ROOT); } } else { throw
		 * new ODataApplicationException("$select option has invalid parameters",
		 * HttpStatusCode.BAD_REQUEST.getStatusCode(), Locale.ROOT); }
		 * 
		 * }
		 */
		logger.info("Fetching data from database");
		if (countOption != null) {
			boolean isCount = countOption.getValue();
			if (isCount) {
				long count = odataDaoImplObj.getCount(edmEntitySet, reflect);
				entityCollection.setCount((int) count);
			}
		} else if (skipOption != null) {
			int skipNumber = skipOption.getValue();
			if (skipNumber >= 0) {
				dataList = odataDaoImplObj.getSkip(skipNumber, reflect);
				if (dataList != null && dataList.size() > 0) {
					entityCollection = Utils.makeEntityCollection(dataList, classFields);
				} else {
					throw new ODataApplicationException(
							"Invalid value for $skip. The value given for $skip may exceed total number of rows in a table",
							HttpStatusCode.BAD_REQUEST.getStatusCode(), Locale.ROOT);
				}
			}
		} else if (topOption != null) {
			int topNumber = topOption.getValue();
			if (topNumber >= 0) {
				dataList = odataDaoImplObj.getTop(topNumber, reflect);
				if (dataList != null && dataList.size() > 0) {
					entityCollection = Utils.makeEntityCollection(dataList, classFields);
				} else {
					throw new ODataApplicationException("Invalid value for $top.",
							HttpStatusCode.BAD_REQUEST.getStatusCode(), Locale.ROOT);
				}
			}
		} else {
			dataList = odataDaoImplObj.getAllData(edmEntitySet, reflect);
			if (dataList != null && dataList.size() > 0) {
				entityCollection = Utils.makeEntityCollection(dataList, classFields);
			} else {
				throw new ODataApplicationException("Invalid or no data", HttpStatusCode.BAD_REQUEST.getStatusCode(),
						Locale.ROOT);
			}
		}

		// 3rd: create a serializer based on the requested format (json)
		ODataSerializer serializer = odata.createSerializer(responseFormat);

		// 4th: Now serialize the content: transform from the EntitySet object to
		// InputStream
		EdmEntityType edmEntityType = edmEntitySet.getEntityType();
		// we need the property names of the $select, in order to build the context URL

		String selectList = null;
		ContextURL contextURL = null;
		EntityCollectionSerializerOptions opts = null;
		if (selectOption != null) {
			logger.info("Setting up context URL and data");
			selectList = odata.createUriHelper().buildContextURLSelectList(edmEntityType, null, selectOption);
			try {
				contextURL = ContextURL.with().entitySet(edmEntitySet)
						.serviceRoot(new URI(request.getRawBaseUri() + "/")).selectList(selectList).build();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			final String id = request.getRawBaseUri() + "/" + edmEntitySet.getName();
			opts = EntityCollectionSerializerOptions.with().id(id).count(countOption).contextURL(contextURL)
					.select(selectOption).build();
		} else {
			logger.info("Setting up context URL and data");
			try {
				contextURL = ContextURL.with().entitySet(edmEntitySet)
						.serviceRoot(new URI(request.getRawBaseUri() + "/")).build();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			final String id = request.getRawBaseUri() + "/" + edmEntitySet.getName();
			opts = EntityCollectionSerializerOptions.with().id(id).count(countOption).contextURL(contextURL).build();
		}

		SerializerResult serializedContent = serializer.entityCollection(serviceMetadata, edmEntityType,
				entityCollection, opts);
		logger.info("Setting up response");
		// Finally: configure the response object: set the body, headers and status code
		response.setContent(serializedContent.getContent());
		response.setStatusCode(HttpStatusCode.OK.getStatusCode());
		response.setHeader(HttpHeader.CONTENT_TYPE, responseFormat.toContentTypeString());

	}

}
