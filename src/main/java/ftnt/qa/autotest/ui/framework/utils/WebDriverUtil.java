package ftnt.qa.autotest.ui.framework.utils;


import org.openqa.selenium.WebDriver;

import ftnt.qa.autotest.ui.testbase.TestBase;

public class WebDriverUtil {
	
	public static WebDriver getWebDriverInstance(){
		return TestBase.getWebDriver();
	}
}