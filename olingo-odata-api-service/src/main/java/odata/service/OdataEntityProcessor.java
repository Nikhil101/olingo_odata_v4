package odata.service;

import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.olingo.commons.api.data.ContextURL;
import org.apache.olingo.commons.api.data.ContextURL.Suffix;
import org.apache.olingo.commons.api.data.Entity;
import org.apache.olingo.commons.api.edm.EdmEntitySet;
import org.apache.olingo.commons.api.edm.EdmEntityType;
import org.apache.olingo.commons.api.format.ContentType;
import org.apache.olingo.commons.api.http.HttpHeader;
import org.apache.olingo.commons.api.http.HttpStatusCode;
import org.apache.olingo.server.api.OData;
import org.apache.olingo.server.api.ODataApplicationException;
import org.apache.olingo.server.api.ODataLibraryException;
import org.apache.olingo.server.api.ODataRequest;
import org.apache.olingo.server.api.ODataResponse;
import org.apache.olingo.server.api.ServiceMetadata;
import org.apache.olingo.server.api.processor.EntityProcessor;
import org.apache.olingo.server.api.serializer.EntityCollectionSerializerOptions;
import org.apache.olingo.server.api.serializer.EntitySerializerOptions;
import org.apache.olingo.server.api.serializer.ODataSerializer;
import org.apache.olingo.server.api.serializer.SerializerException;
import org.apache.olingo.server.api.serializer.SerializerResult;
import org.apache.olingo.server.api.uri.UriInfo;
import org.apache.olingo.server.api.uri.UriParameter;
import org.apache.olingo.server.api.uri.UriResource;
import org.apache.olingo.server.api.uri.UriResourceEntitySet;
import org.apache.olingo.server.api.uri.queryoption.ExpandOption;
import org.apache.olingo.server.api.uri.queryoption.SelectOption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import odata.data.OdataDAOImpl;
import odata.util.Utils;

public class OdataEntityProcessor implements EntityProcessor {

	private OData odata;
	private ServiceMetadata serviceMetadata;
	OdataDAOImpl odataDaoImplObj = new OdataDAOImpl();
	private static final Logger logger = LoggerFactory.getLogger(OdataEntityProcessor.class);
	
	@Override
	public void init(OData odata, ServiceMetadata serviceMetadata) {
		this.odata = odata;
		this.serviceMetadata = serviceMetadata;

	}

	@Override
	public void readEntity(final ODataRequest request, final ODataResponse response, final UriInfo uriInfo, final ContentType responseFormat)
			 {
		logger.info("Read method executing for getting data");
		// TODO Auto-generated method stub
		// 1. retrieve the Entity Type
		List<UriResource> resourcePaths = uriInfo.getUriResourceParts();
		// Note: only in our example we can assume that the first segment is the
		// EntitySet
		UriResourceEntitySet uriResourceEntitySet = (UriResourceEntitySet) resourcePaths.get(0);
		EdmEntitySet edmEntitySet = uriResourceEntitySet.getEntitySet();

		// 2. retrieve the data from backend
		Class<?> reflect = null;
		try {
			String classname = Utils.packageToScan + "." + edmEntitySet.getName();
			reflect = Class.forName(classname);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<UriParameter> keyParams = uriResourceEntitySet.getKeyPredicates();
		logger.info("Fetching data from database");
		Entity entity = odataDaoImplObj.getKeyData(edmEntitySet, reflect, keyParams);
		// handle $select
		SelectOption selectOption = uriInfo.getSelectOption();
		// 3. serialize
		EdmEntityType edmEntityType = edmEntitySet.getEntityType();
		// we need the property names of the $select, in order to build the context URL

		String selectList = null;
		ContextURL contextURL = null;
		EntitySerializerOptions opts = null;
		if (selectOption != null) {
			logger.info("Setting up context URL and data");
			try {
				selectList = odata.createUriHelper().buildContextURLSelectList(edmEntityType, null, selectOption);
				contextURL = ContextURL.with().entitySet(edmEntitySet).serviceRoot(new URI(request.getRawBaseUri()+"/")).selectList(selectList)
					.suffix(ContextURL.Suffix.ENTITY).build();
			}catch (URISyntaxException | SerializerException e) {
				e.printStackTrace();
			}

			opts = EntitySerializerOptions.with().contextURL(contextURL).select(selectOption).build();
		} else {
			logger.info("Setting up context URL and data");
			try {
				contextURL = ContextURL.with().entitySet(edmEntitySet).serviceRoot(new URI(request.getRawBaseUri()+"/")).build();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			opts = EntitySerializerOptions.with().contextURL(contextURL).select(selectOption).build();
		}

		ODataSerializer serializer = null;
		try {
			serializer = this.odata.createSerializer(responseFormat);
		} catch (SerializerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SerializerResult serializerResult = null;
		try {
			serializerResult = serializer.entity(serviceMetadata, edmEntityType, entity, opts);
		} catch (SerializerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		logger.info("Setting up response");
		// 4. configure the response object
		response.setContent(serializerResult.getContent());
		//response.setContent(serializer.serviceDocument(serviceMetadata, request.getRawBaseUri()).getContent());
		response.setStatusCode(HttpStatusCode.OK.getStatusCode());
		response.setHeader(HttpHeader.CONTENT_TYPE, responseFormat.toContentTypeString());

			 }
	@Override
	public void createEntity(ODataRequest request, ODataResponse response, UriInfo uriInfo, ContentType requestFormat,
			ContentType responseFormat) throws ODataApplicationException, ODataLibraryException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateEntity(ODataRequest request, ODataResponse response, UriInfo uriInfo, ContentType requestFormat,
			ContentType responseFormat) throws ODataApplicationException, ODataLibraryException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteEntity(ODataRequest request, ODataResponse response, UriInfo uriInfo)
			throws ODataApplicationException, ODataLibraryException {
		// TODO Auto-generated method stub

	}

}
