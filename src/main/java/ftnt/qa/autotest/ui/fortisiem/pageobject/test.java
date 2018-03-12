package ftnt.qa.autotest.ui.fortisiem.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import ftnt.qa.autotest.ui.framework.testng.listener.ScreenShotListener;

public class test {
	@Test
	public void function1() {
		WebDriver driver = new ChromeDriver();
		ScreenShotListener.setDriver(driver);//特别需要注意的是，在测试类里面必须引入driver，否则会出现空指针错误。
		System.setProperty("webdriver.chrome.driver","c:\\chromedriver.exe");
		String baseUrl = "https://10.30.2.171/phoenix/login-html.jsf";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
		Login loginObj = PageFactory.initElements(driver, Login.class);
        loginObj.login("admin", "admin*1", "super","LOCAL");
        Assert.assertTrue(false);
	}
	
	@Test
	public void function2() {
        Assert.assertTrue(true);
	}
	
	@Test
	public void function3() {
        Assert.assertTrue(false);
	}
	
	@Test
	public void function4() {
        Assert.assertTrue(true);
	}
	

}
