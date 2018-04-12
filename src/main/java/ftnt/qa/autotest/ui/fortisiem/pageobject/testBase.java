package ftnt.qa.autotest.ui.fortisiem.pageobject;

import org.testng.Assert;
import org.testng.annotations.Test;

import ftnt.qa.autotest.ui.testbase.TestBase;
//@Listeners({ftnt.qa.autotest.ui.framework.testng.listener.ScreenShotListener.class,
//	ftnt.qa.autotest.ui.framework.testng.listener.RetryListener.class,
//	ftnt.qa.autotest.ui.framework.testng.listener.ReportListener.class})
public class testBase extends TestBase {
//	@Test
//	public void function1() throws Exception {
//		WebDriver driver = TestBase.getWebDriver();
//		Login loginObj = PageFactory.initElements(driver, Login.class);
//        loginObj.login("admin", "admin*1", "super","LOCAL");
//	}
	
	@Test
	public void function2() {
        Assert.assertTrue(false);
	}
}
