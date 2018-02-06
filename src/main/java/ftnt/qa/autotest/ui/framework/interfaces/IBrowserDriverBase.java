package ftnt.qa.autotest.ui.framework.interfaces;

/**
 * 实例化目标浏览器接口
 * 
 * @author xin.wang
 *
 */
public interface IBrowserDriverBase {

	public void configBrowser() throws Exception;

	public <T> T getWebDriver() throws Exception;
}