package ftnt.qa.autotest.ui.framework.testbase;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.xml.XmlTest;

import ftnt.qa.autotest.ui.framework.constants.CommonConstants;
import ftnt.qa.autotest.ui.framework.testng.listener.TestNGListener;
import ftnt.qa.autotest.ui.framework.utils.CommonsPropertiesUtils;
import ftnt.qa.autotest.ui.framework.utils.CookiesUtil;
import ftnt.qa.autotest.ui.framework.utils.ExcuteBatCommand;

public abstract class TestBase implements ITestBase {
	private static final Logger logger = LoggerFactory.getLogger(TestBase.class);
	protected static WebDriver webDriver;
	protected static String browserType;

	@BeforeSuite(alwaysRun = true)
	public void initTest(XmlTest xt, ITestContext tc) throws Exception {
		browserType = CommonsPropertiesUtils.ReadSinglePropertiesWithValue("framework.properties", "Browser.Type",
				"ftnt.qa.autotest.ui.framework.webdriverfactory.ChromeBrowserDriver");
		logger.info("#####开始执行测试用例#####");
	}

	@AfterSuite
	public void terminTestSuite(XmlTest xt, ITestContext tc) throws Exception {
		logger.info("#####全部测试用例执行完毕#####");
	}

	@BeforeClass()
	public void beforeClass(XmlTest xt, ITestContext tc) throws Exception {
		logger.info("############################################################");
		logger.info("#####BeforeClass:开始执行测试类:" + this.getClass().getName()+ " 执行开始");
		logger.info("#####");
		logger.info("#####测试开始时间：" + tc.getStartDate());
	}

	@AfterClass()
	public void afterClass(XmlTest xt, ITestContext tc) throws Exception {
		logger.info("#####");
		logger.info("#####@AfterClass:执行结束测试类：" + this.getClass().getName() + " 执行完毕");
		logger.info("############################################################"+"\n");

	}

	@BeforeMethod
	public void initDriver(ITestContext tc, Method m, XmlTest xt) throws Exception {
		webDriver = new DriverFactory().getDriver(browserType);
		TestNGListener.setDriver(webDriver);// 配置监听开启
		preCondition();
	}

	@AfterMethod
	public void cleanEnv(ITestResult rs, XmlTest xt, Method m, ITestContext tc) throws Exception {
		try {
			if (!rs.isSuccess()) {
				Throwable throwable = rs.getThrowable();
				logger.info("=====测试用例: " + rs.getMethod().getMethodName() + " 运行失败，原因： " + throwable.getMessage()
						+ "=====");
				StackTraceElement[] se = throwable.getStackTrace();
				logger.info("堆栈信息:");
				for (StackTraceElement e : se) {
					logger.info(e.toString());
				}
			} else {
				logger.info("#####测试方法: " + rs.getMethod().getMethodName() + " 运行成功");
			}
			webDriver.close();
			webDriver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ExcuteBatCommand.executeBatFile(CommonConstants.KILL_DRIVER_PROCESS_BAT);
			logger.info("#####AfterMethod:清理浏览器进程完毕");
		}
		Thread.sleep(2000);
	}

	public void preCondition() throws Exception {
		String website = CommonsPropertiesUtils.ReadSingleProperties("fortisiem.properties", "aoip");
		displayTipInfo(website);
		configDriver();
		openTargetWebSit(website);
	}

	private void configDriver() throws Exception {
		webDriver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);
	}

	@SuppressWarnings("unused")
	private void displayTipInfo(String website) {
		logger.info("#####BeforeMethod:测试用例运行的浏览器类型：" + browserType);
		logger.info("#####BeforeMethod:测试网址 " + website);

	}

	private void openTargetWebSit(String website) {
		if (CookiesUtil.getCk() != null) {
			webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			try {
				webDriver.get(website);
			} catch (Exception e) {
			}
			webDriver.manage().addCookie(CookiesUtil.getCk());
		}
		try {
			webDriver.get(website);
		} catch (Exception e) {
		}
		webDriver.manage().timeouts().pageLoadTimeout(-1, TimeUnit.SECONDS);
	}

	/**
	 * @author Lei.Wu
	 * @see 获取webdriver对象实例
	 */

	public static WebDriver getWebDriver() {
		return webDriver;
	}
}