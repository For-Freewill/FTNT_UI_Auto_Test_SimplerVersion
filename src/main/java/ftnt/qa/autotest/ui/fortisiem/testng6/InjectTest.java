package ftnt.qa.autotest.ui.fortisiem.testng6;

import org.testng.annotations.Test;

import com.google.inject.Inject;

public class InjectTest {
	
	@Inject
	TestGuice testGuice;
	
	@Test
	public void test1() {
		testGuice.testLogin();
	}
}
