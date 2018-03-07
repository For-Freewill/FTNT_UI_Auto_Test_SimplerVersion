package ftnt.qa.autotest.ui.testbase;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.xml.XmlTest;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import ftnt.qa.autotest.ui.framework.constants.CommonConstants;
import ftnt.qa.autotest.ui.framework.constants.PropertiesKeys;
import ftnt.qa.autotest.ui.testbase.ITestBase;
import ftnt.qa.autotest.ui.framework.testng.listener.RetryToRunCase;
import ftnt.qa.autotest.ui.framework.utils.CookiesUtil;
import ftnt.qa.autotest.ui.framework.utils.ExcuteBatCommand;
import ftnt.qa.autotest.ui.framework.utils.PageObjectUtil;
import ftnt.qa.autotest.ui.framework.utils.PictureUtil;
import ftnt.qa.autotest.ui.framework.utils.PropertiesUtil;
import ftnt.qa.autotest.ui.framework.utils.InitPageObject;
import ftnt.qa.autotest.ui.framework.utils.InitPropertiesUtil;

public abstract  class TestBase implements ITestBase {
	protected static RemoteWebDriver webDriver;
	protected static String browserType;
	public static boolean success = true;
	protected static int retryMaxCount = RetryToRunCase.getMaxRetryCount();
	protected static int reTryCount = 1;
	private static String testCaseDeclaringClass = null;

	/**
	 * @author Lei.Wu
	 * @see 
	 */
	@BeforeSuite(alwaysRun = true)
	public void initTest(XmlTest xt,ITestContext tc) throws Exception {
		System.setProperty(CommonConstants.CONFIG_FOLDER_PATH_KEY, CommonConstants.CONFIG_FOLDER_PATH_VALUE);
		if (null == PropertiesUtil.getProKVMap()) {
			new InitPropertiesUtil();
		}
		PictureUtil.setBaseUrl(System.getProperty("user.dir") + PropertiesUtil.getProValue("testcase.testpic.path"));
		browserType = PropertiesUtil.getProValue(PropertiesKeys.BROWSER_TYPE).toString();
	}

	/**
	 * @author Lei.Wu
	 * @see 测试方法执行结束后清理测试环境
	 */
	@AfterMethod
	public void cleanEnv(ITestResult rs,XmlTest xt,Method m,ITestContext tc) throws Exception {
		try {
			PageObjectUtil.setPageObjMap(null);
			if (!rs.isSuccess()) {
				if (reTryCount <= retryMaxCount) {
					success = false;
				}
				Throwable throwable = rs.getThrowable();
				System.out.println("=====测试用例: " + rs.getMethod().getMethodName() + " 运行失败，原因： "
						+ throwable.getMessage() + "=====");
				StackTraceElement[] se = throwable.getStackTrace();
				System.out.println("堆栈信息:");
				for (StackTraceElement e : se) {
					System.out.println(e.toString());
				}
			} else {
				reTryCount = 1;
				System.out.println("=====测试用例: " + rs.getMethod().getMethodName() + " 运行成功=====");
			}
			webDriver.close();
			webDriver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ExcuteBatCommand.executeBatFile(CommonConstants.KILL_DRIVER_PROCESS_BAT);
		}
	}

	public void preCondition(ConfigDriverParameters cp) throws Exception {
		for(Method method:Class.forName(className).getDeclaredMethods()){
            
        }
		testCaseDeclaringClass = cp.getTestMethod().getDeclaringClass().getName();
		String website = cp.getTargetWebSite();
		displayTipInfo(website, cp.getTestMethod());
		configDriver(cp);
		openTargetWebSit(website);
	}

	private void configDriver(ConfigDriverParameters cp) throws Exception {
		webDriver = new DriverFactory().getDriver(browserType);
		new InitPageObject(this);
		webDriver.manage().timeouts().implicitlyWait(cp.getSerachElementTime(), TimeUnit.SECONDS);
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().pageLoadTimeout(cp.getPageLoadTime(), TimeUnit.SECONDS);
	}

	@SuppressWarnings("unused")
	private void displayTipInfo(String website, Method m) {
		if (!success) {
			System.out.println("\n=======测试用例准备重试=======");
			reTryCount++;
			success = true;
		}
		System.out.println("\n======测试用例: " + m.getName() + " 开始执行======" + "\n===测试用例运行的浏览器类型：" + browserType + " ==="
				+ "\n测试网站地址: " + website);

	}

	public static String getTestCaseDeclaringClass() {
		return testCaseDeclaringClass;
	}

	private void openTargetWebSit(String website) {
		if (CookiesUtil.getCk() != null) {
			webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
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

	public static RemoteWebDriver getWebDriver() {
		return webDriver;
	}
}