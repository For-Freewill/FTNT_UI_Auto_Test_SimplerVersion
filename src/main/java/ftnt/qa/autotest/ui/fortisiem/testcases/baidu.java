package ftnt.qa.autotest.ui.fortisiem.testcases;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ftnt.qa.autotest.ui.framework.utils.CaptureElementUtil;

public class baidu {
	public static void main(String[] args) throws ConfigurationException {
		WebDriver webDriver = new ChromeDriver();
		webDriver.get("http://www.baidu.com");
		CaptureElementUtil screenshot = new CaptureElementUtil(webDriver);
        screenshot.getScreenShot(webDriver.findElement(By.id("su")));
		
	}

}
