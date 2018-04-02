package ftnt.qa.autotest.ui.fortisiem.pageobject;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import ftnt.qa.autotest.ui.framework.constants.CommonConstants;
import ftnt.qa.autotest.ui.framework.constants.PropertiesKeys;
import ftnt.qa.autotest.ui.framework.testng.listener.TestNGListener;
import ftnt.qa.autotest.ui.framework.utils.InitPropertiesUtil;
import ftnt.qa.autotest.ui.framework.utils.PictureUtil;
import ftnt.qa.autotest.ui.framework.utils.PropertiesUtil;
import ftnt.qa.autotest.ui.testbase.DriverFactory;
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
