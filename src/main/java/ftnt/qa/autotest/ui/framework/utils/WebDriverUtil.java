package ftnt.qa.autotest.ui.framework.utils;


import org.openqa.selenium.WebDriver;

import ftnt.qa.autotest.ui.testbase.TestBase_bak;

public class WebDriverUtil {
	
	public static WebDriver getWebDriverInstance(){
		return TestBase_bak.getWebDriver();
	}
}