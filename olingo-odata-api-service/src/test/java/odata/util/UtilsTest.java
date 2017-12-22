/**
 * 
 */
package odata.util;

import static org.junit.Assert.assertNotNull;

import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;
import org.reflections.Reflections;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * @author nikhil varma
 *
 */
public class UtilsTest {

	Utils util;
	/**
	 * Test method for {@link odata.util.Utils#getClasses(java.lang.String)}.
	 */
	@Test
	public void testGetClasses() {
		Reflections reflections = new Reflections("odata.model");
		Set<Class<? extends Serializable>> subTypes = reflections.getSubTypesOf(Serializable.class);
		
		assertNotNull(subTypes);
	}

	/**
	 * Test method for {@link odata.util.Utils#makeEntityCollection(java.util.List, java.lang.reflect.Field[])}.
	 */
	public void testMakeEntityCollection() {
	
	}

	/**
	 * Test method for {@link odata.util.Utils#createEntity(java.lang.Object, java.lang.reflect.Field[])}.
	 */
	public void testCreateEntity() {
		
	}

	/**
	 * Test method for {@link odata.util.Utils#createId(java.lang.String, java.lang.Object)}.
	 */
	public void testCreateId() {
		
	}

}
