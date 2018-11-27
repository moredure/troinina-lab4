package as111.ssm.test.filters;

import as111.ssm.User;
import as111.ssm.filters.SurnameFilter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;


public class SurnameFilterTest {
    private User user;
    private SurnameFilter filter;

    @Before
    public void init() {
        user = new User();
        filter = new SurnameFilter();
    }

    @Test
    public void testFilterName() {
        assertEquals("surname", filter.getFilterName());
    }

    @Test
    public void testNullFilter() {
        filter.setFilterValue(null);
        user.setSurname(null);
        assertTrue(filter.isIncluded(user));
        user.setSurname("Ivanovich");
        assertTrue(filter.isIncluded(user));
    }

    @Test
    public void testNotNullFilter() {
        filter.setFilterValue("Iv");

        user.setSurname(null);
        assertFalse(filter.isIncluded(user));

        user.setSurname("Ivanovich");
        assertTrue(filter.isIncluded(user));

        user.setSurname("Ivanovich");
        assertTrue(filter.isIncluded(user));

        user.setSurname("notIvanovich");
        assertFalse(filter.isIncluded(user));
    }
}
