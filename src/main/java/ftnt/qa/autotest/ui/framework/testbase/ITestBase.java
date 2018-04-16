package ftnt.qa.autotest.ui.framework.testbase;

import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.xml.XmlTest;

/**
 * @author Lei.Wu
 * 测试基类接口
 */
public interface ITestBase {

	@BeforeSuite
	public void initTest(XmlTest xt, ITestContext tc) throws Exception;

	@AfterSuite
	public void terminTestSuite(XmlTest xt, ITestContext tc) throws Exception;

	@BeforeClass
	public void beforeClass(XmlTest xt, ITestContext tc) throws Exception;

	@AfterClass
	public void afterClass(XmlTest xt, ITestContext tc) throws Exception;

//	@BeforeTest
//	public void beforeTest(XmlTest xt, ITestContext tc) throws Exception;
//
//	@AfterTest
//	public void afterTest(XmlTest xt, ITestContext tc) throws Exception;

	@BeforeMethod
	public void initDriver(ITestContext tc, Method m, XmlTest xt) throws Exception;

	@AfterMethod
	public void cleanEnv(ITestResult rs, XmlTest xt, Method m, ITestContext tc) throws Exception;
}