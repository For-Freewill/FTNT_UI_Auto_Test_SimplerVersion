package ftnt.qa.autotest.ui.framework.interfaces;

/**
 * @author Lei.Wu Webdriver 工厂接口
 */
public interface IWebdriverFactory {
	
	public <T> void setDriver(T driver)throws Exception;

	public <T> T getDriver(String classPackageName) throws Exception;
}