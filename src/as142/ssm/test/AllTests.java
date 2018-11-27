package as111.ssm.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import as111.ssm.test.filters.FiltersSuite;
import as111.ssm.test.gui.GuiTestSuie;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	GuiTestSuie.class,
	FiltersSuite.class
})
public class AllTests {
	
}
