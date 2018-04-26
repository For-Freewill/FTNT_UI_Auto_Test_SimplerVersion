package ftnt.qa.autotest.ui.fortisiem.testcases;

import java.io.File;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.github.crab2died.ExcelUtils;

import ftnt.qa.autotest.ui.fortisiem.pageobject.Login;
import ftnt.qa.autotest.ui.framework.excel.ExcelUtil;
import ftnt.qa.autotest.ui.framework.excel.model.ConvertModel;
import ftnt.qa.autotest.ui.framework.testbase.TestBase;
//@Listeners({ftnt.qa.autotest.ui.framework.testng.listener.ScreenShotListener.class,
//	ftnt.qa.autotest.ui.framework.testng.listener.RetryListener.class,
//	ftnt.qa.autotest.ui.framework.testng.listener.ReportListener.class})
public class Organization extends TestBase {
	private static String path = System.getProperty("user.dir") + File.separator + "TestData" + File.separator + "excel"
			+ File.separator;
	private static String exppath = System.getProperty("user.dir") + File.separator + "TestData" + File.separator + "export"
			+ File.separator;
	
	@Test
	public void function1() throws Exception {
		WebDriver driver = TestBase.getWebDriver();
		Login loginObj = PageFactory.initElements(driver, Login.class);
		loginObj.login("admin", "admin*1", "super","LOCAL");
		//loginObj.logout();
	}

	
//	@Test
//	public void test1() throws Exception {
//
//        
//		List<ConvertModel> list =ExcelUtil.readExcel2java(path+"LoginUser.xlsx", ConvertModel.class);
//		WebDriver driver = TestBase.getWebDriver();
//		Login loginObj = PageFactory.initElements(driver, Login.class);
//		for (ConvertModel convertModel : list) {
//
//			if (convertModel.getRun().booleanValue()) {
//				loginObj.login(convertModel.getUser(), convertModel.getPwd(), convertModel.getOrg(),convertModel.getAddress());
//				convertModel.setSuccess(true);//如果用户名是admin，设置测试结果为success
//			} else {
//				convertModel.setSuccess(false);//否则测试成功的结果为false
//			}
//		}
//		
//		ExcelUtils.getInstance().exportObjects2Excel(list,ConvertModel.class , exppath+"Login_result.xlsx");
//	}

	

}
