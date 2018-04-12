package ftnt.qa.autotest.ui.framework.testbase;


import ftnt.qa.autotest.ui.framework.interfaces.IBrowserDriverBase;
import ftnt.qa.autotest.ui.framework.interfaces.IWebdriverFactory;

/**
 * @author Lei.Wu
 * @see 用于配置和生产基于不同浏览器的webdriver。
 */
public class DriverFactory  implements IWebdriverFactory {

	/**
	 * @author Lei.Wu
	 * @param classPackageName
	 *            浏览器类型
	 * @throws Exception
	 * @see 根据指定的浏览器获取并初始化webdriver对象实例
	 **/

	public <T> T getDriver(String classPackageName) throws Exception {
		Object obj = Class.forName(classPackageName).newInstance();
		return ((IBrowserDriverBase)obj).getWebDriver();
	}

	public <T> void setDriver(T driver) {
		// TODO Auto-generated method stub
	}
}