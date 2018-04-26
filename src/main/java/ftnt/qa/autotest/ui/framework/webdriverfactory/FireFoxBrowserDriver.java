package ftnt.qa.autotest.ui.framework.webdriverfactory;

import java.io.File;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;

import ftnt.qa.autotest.ui.framework.constants.CommonConstants;
import ftnt.qa.autotest.ui.framework.interfaces.IBrowserDriverBase;

public class FireFoxBrowserDriver implements IBrowserDriverBase {

	public void configBrowser() throws Exception {
		System.setProperty(CommonConstants.FIREFOX_DRIVER_FIELD, CommonConstants.FIREFOX_DRIVER_PATH);
		GeckoDriverService geckoDriverService= new GeckoDriverService.Builder()
				.usingDriverExecutable(new File(CommonConstants.FIREFOX_DRIVER_PATH)).usingAnyFreePort().build();
		geckoDriverService.start();
	}

	@SuppressWarnings("unchecked")
	public <T> T getWebDriver() throws Exception {
		configBrowser();
		return (T) new FirefoxDriver();
	}
}