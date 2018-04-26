package ftnt.qa.autotest.ui.fortisiem.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import ftnt.qa.autotest.ui.fortisiem.pageobject.Login;
import ftnt.qa.autotest.ui.framework.testbase.TestBase2;
//@Listeners({ftnt.qa.autotest.ui.framework.testng.listener.ScreenShotListener.class,
//	ftnt.qa.autotest.ui.framework.testng.listener.RetryListener.class,
//	ftnt.qa.autotest.ui.framework.testng.listener.ReportListener.class})
public class User extends TestBase2 {
	private static final Logger logger = LoggerFactory.getLogger(User.class);
	@Test
	public void function1() throws Exception {
		WebDriver driver = TestBase2.getWebDriver();
		Login loginObj = PageFactory.initElements(driver, Login.class);
        loginObj.login("admin", "admin*1", "super","LOCAL");

	}
	
//	@Test
//	public void function2() {
//        Assert.assertTrue(false);
//	}

}
