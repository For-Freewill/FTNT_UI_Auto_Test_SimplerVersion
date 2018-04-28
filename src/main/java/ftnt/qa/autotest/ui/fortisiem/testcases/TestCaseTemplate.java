package ftnt.qa.autotest.ui.fortisiem.testcases;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


import ftnt.qa.autotest.ui.fortisiem.pageobject.Login;
import ftnt.qa.autotest.ui.framework.testbase.TestBase2;

public class TestCaseTemplate extends TestBase2 {
	private static final Logger logger = LoggerFactory.getLogger(TestCaseTemplate.class);
	
	@Test
	public void function1() throws Exception {
		WebDriver driver = TestBase2.getWebDriver();//注意，driver的声明必须在@Test里面
		Login loginObj = new Login(driver);
        loginObj.login("admin", "admin*1", "super","LOCAL");
        loginObj.logout();
        logger.info("用户已退出！");
	}
}
