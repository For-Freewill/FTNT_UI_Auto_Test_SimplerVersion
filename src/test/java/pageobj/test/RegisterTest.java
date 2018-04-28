package pageobj.test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

import org.apache.bcel.generic.NEW;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import ftnt.qa.autotest.ui.fortisiem.selenium3.CommonAction;

public class RegisterTest extends TestBase3 {
	private static final Logger logger = LoggerFactory.getLogger(RegisterTest.class);
	@Test
	public void getUUID() throws InterruptedException, IOException {
		FileUtils.forceDeleteOnExit(new File("C:\\Users\\admin\\Downloads\\"));
		String aoIP="10.30.2.169";
		WebDriver driver = TestBase3.getWebDriver();//注意，driver的声明必须在@Test里面
		FsmRegisterPage fsmRegisterPage = new FsmRegisterPage(driver);
		Thread.sleep(2000);
		String uuid = fsmRegisterPage.getHardWareId();
		while(uuid.equals(null)) {
			uuid = fsmRegisterPage.getHardWareId();
		}
		System.out.println("UUID="+uuid);

		new CommonAction(driver).excuteJs(driver, "document.getElementById(\"filePathInput\").readOnly=false");
		new CommonAction(driver).excuteJs(driver, "document.getElementById(\"submitBtn\").removeAttribute(\"disabled\");");
		
		WebDriver driver2 = new ChromeDriver();
		driver2.get("https://172.30.53.116:5580/");
		driver2.manage().window().maximize();
		driver2.findElement(By.name("ipAddress")).sendKeys(aoIP);
		driver2.findElement(By.name("uuid")).sendKeys(uuid);
		driver2.findElement(By.name("collectorsettings")).submit();
		Thread.sleep(3000);
		driver2.close();
		
		RegisterServerPage registerServerPage = new RegisterServerPage(driver2);
		String filePath = registerServerPage.downloadPath+aoIP+".lic";
		System.out.println(filePath);
		FileUtils.copyToDirectory(new File(filePath), new File("D:\\"));
		fsmRegisterPage.upLoad("D:\\10.30.2.169.lic", "admin", "admin*1", "sp");
		
	}
}
