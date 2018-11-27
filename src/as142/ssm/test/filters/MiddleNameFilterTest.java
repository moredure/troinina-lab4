package as111.ssm.test.filters;

import as111.ssm.User;
import as111.ssm.filters.MiddleNameFilter;
import as111.ssm.filters.SurnameFilter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MiddleNameFilterTest {
    private User user;
    private MiddleNameFilter filter;

    @Before
    public void init() {
        user = new User();
        filter = new MiddleNameFilter();
    }

    @Test
    public void testFilterName() {
        assertEquals("middleName", filter.getFilterName());
    }

    @Test
    public void testNullFilter() {
        filter.setFilterValue(null);
        user.setMiddleName(null);
        assertTrue(filter.isIncluded(user));
        user.setMiddleName("Ivanovich");
        assertTrue(filter.isIncluded(user));
    }

    @Test
    public void testNotNullFilter() {
        filter.setFilterValue("Iv");

        user.setMiddleName(null);
        assertFalse(filter.isIncluded(user));

        user.setMiddleName("Ivanovich");
        assertTrue(filter.isIncluded(user));

        user.setMiddleName("Ivanovich");
        assertTrue(filter.isIncluded(user));

        user.setMiddleName("notIvanovich");
        assertFalse(filter.isIncluded(user));
    }
}