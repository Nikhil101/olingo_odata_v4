package odata.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.olingo.commons.api.edmx.EdmxReference;
import org.apache.olingo.server.api.OData;
import org.apache.olingo.server.api.ODataHttpHandler;
import org.apache.olingo.server.api.ServiceMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OdataServiceFactory {

	private static final Logger logger = LoggerFactory.getLogger(OdataServiceFactory.class);

	public void callOdataService(String serviceType, final HttpServletRequest req, final HttpServletResponse resp) {
		if (serviceType.equals("WithoutJPA")) {
			logger.info("Creating odata service without JPA");
			try {
				// create odata handler and configure it with EdmProvider and Processor
				OData odata = OData.newInstance();

				ServiceMetadata edm = odata.createServiceMetadata(new EdmProvider(), new ArrayList<EdmxReference>());
				ODataHttpHandler handler = odata.createHandler(edm);
				handler.register(new CustomDefaultProcessor());
				handler.register(new OdataEntityCollectionProcessor());
				handler.register(new OdataEntityProcessor());
				handler.register(new OdataPrimitiveProcessor());

				// let the handler do the work
				handler.process(req, resp);

			} catch (RuntimeException e) {
				logger.error("Server Error occurred in ExampleServlet", e);
			}
		}
	}
}
