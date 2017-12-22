package odata.data;

import java.util.List;

import org.apache.olingo.commons.api.data.Entity;
import org.apache.olingo.commons.api.edm.EdmEntitySet;
import org.apache.olingo.server.api.uri.UriParameter;

//@Component
public interface OdataDAO {
	public List<?> getAllData(EdmEntitySet edmEntitySet, Class<?> reflect);

	public Entity getKeyData(EdmEntitySet edmEntitySet, Class<?> reflect, List<UriParameter> keyParams);
	
	public long getCount(EdmEntitySet edmEntitySet, Class<?> reflect);
	
	public List<?> getSkip(int skipNumber,Class<?> reflect);
	
	public List<?> getTop(int topNumber, Class<?> reflect);
	
	public List<?> getSelect(EdmEntitySet edmEntitySet, Class<?> reflect,String selectItems);
}
