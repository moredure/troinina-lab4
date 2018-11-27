package as111.ssm.test.filters;

import as111.ssm.filters.SurnameFilter;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
		{NameFilterTest.class,
				SurnameFilterTest.class,
				MiddleNameFilterTest.class,
		}
)
public class FiltersSuite {

}
