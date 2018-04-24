package ftnt.qa.autotest.ui.fortisiem.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import ftnt.qa.autotest.ui.fortisiem.pageobject.Login;
import ftnt.qa.autotest.ui.framework.testbase.TestBase;
import ftnt.qa.autotest.ui.framework.utils.CaptureElementUtil;
//@Listeners({ftnt.qa.autotest.ui.framework.testng.listener.ScreenShotListener.class,
//	ftnt.qa.autotest.ui.framework.testng.listener.RetryListener.class,
//	ftnt.qa.autotest.ui.framework.testng.listener.ReportListener.class})
public class User extends TestBase {
	
	@Test
	public void function1() throws Exception {
		WebDriver driver = TestBase.getWebDriver();
		Login loginObj = PageFactory.initElements(driver, Login.class);
        loginObj.login("admin", "admin*1", "super","LOCAL");
      
	}
	
//	@Test
//	public void function2() {
//        Assert.assertTrue(false);
//	}

}
