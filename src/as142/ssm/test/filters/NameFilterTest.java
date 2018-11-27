package as111.ssm.test.filters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import as111.ssm.User;
import as111.ssm.filters.NameFilter;

public class NameFilterTest {
	private User user;
	private NameFilter filter;
	
	@Before
	public void init() {
		user = new User();
		filter = new NameFilter();
	}
	
	@Test
	public void testFilterName() {
		assertEquals("name", new NameFilter().getFilterName());
	}
	
	@Test
	public void testNullFilter() {		
		filter.setFilterValue(null);
		user.setName(null);
		assertTrue(filter.isIncluded(user));
		user.setName("Ivan");
		assertTrue(filter.isIncluded(user));
	}
	
	@Test 
	public void testNotNullFilter() {		
		filter.setFilterValue("Iv");
		
		user.setName(null);
		assertFalse(filter.isIncluded(user));
		
		user.setName("Ivan");
		assertTrue(filter.isIncluded(user));
		
		user.setName("ivan");
		assertTrue(filter.isIncluded(user));
		
		user.setName("notIvan");
		assertFalse(filter.isIncluded(user));
	}
}
