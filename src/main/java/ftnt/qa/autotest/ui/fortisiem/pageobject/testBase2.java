package ftnt.qa.autotest.ui.fortisiem.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import ftnt.qa.autotest.ui.framework.testbase.TestBase;
//@Listeners({ftnt.qa.autotest.ui.framework.testng.listener.ScreenShotListener.class,
//	ftnt.qa.autotest.ui.framework.testng.listener.RetryListener.class,
//	ftnt.qa.autotest.ui.framework.testng.listener.ReportListener.class})
public class testBase2 extends TestBase {
	@Test
	public void function1() throws Exception {
		WebDriver driver = TestBase.getWebDriver();
		Login loginObj = PageFactory.initElements(driver, Login.class);
        loginObj.login("admin", "admin*1", "super","LOCAL");
	}
	

}
