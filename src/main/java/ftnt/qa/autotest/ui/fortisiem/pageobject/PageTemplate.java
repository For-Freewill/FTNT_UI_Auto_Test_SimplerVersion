package ftnt.qa.autotest.ui.fortisiem.pageobject;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ftnt.qa.autotest.ui.fortisiem.selenium3.CommonAction;
import ftnt.qa.autotest.ui.fortisiem.selenium3.GetTableBy;
import ftnt.qa.autotest.ui.fortisiem.selenium3.GetTableNew;
import ftnt.qa.autotest.ui.fortisiem.selenium3.GetTableOld;
import ftnt.qa.autotest.ui.framework.testbase.TestBase;
import ftnt.qa.autotest.ui.framework.utils.CaptureElementUtil;

import java.util.concurrent.TimeUnit;

/**
 * PageObject类模板,用于创建基本的Page类
 * @author Wulei
 * @date 2018-4-26
 * @since 1.0.0
 */
public class PageTemplate {
	private WebDriver driver;//driver变量
	private static final Logger logger = LoggerFactory.getLogger(PageTemplate.class);//Slf4j变量

	/*
	 * 设置带有webdriver的构造函数
	 * */
	public PageTemplate(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);//初始化元素时等待时间
	}
	
	
	/*@FindBy用于定位元素（8大定位方式）,用法如下：
	 *@FindBy(id = "id")
	 *private WebElement userName;
	 * 其他属性：name，className，css，tagName，linkText，partialLinkText，xpath
	 * */
	@FindBy(id = "id")
	@CacheLookup //假如缓存，从缓存获取元素
	private WebElement id;
	
	@FindBy(name = "name")
	@CacheLookup
	private WebElement name;
	
	@FindBy(className = "testclass")
	@CacheLookup
	private WebElement className;
	
	@FindBy(tagName = "table")
	@CacheLookup
	private WebElement tagName;
	
	@FindBy(linkText = "百度一下")
	@CacheLookup
	private WebElement linkText;
	
	@FindBy(partialLinkText = "百度")
	@CacheLookup
	private WebElement partialLinkText;
	
	@FindBy(css = "div.errors ul li")
	private WebElement css;
	
	@FindBy(xpath = "//test/li[3]/a")
	private WebElement xpath;
	
	/*@FindBy定位写法2。@FindBy(how = How.XPATH, using = "") */
	@FindBy(how = How.ID, using = "id")
	private WebElement profile;

	public void login(String userName, String password, String custId, String domain)
			throws ConfigurationException, InterruptedException {
		this.tagName.sendKeys(userName);
		this.name.sendKeys(password);
		this.id.clear();
		this.id.sendKeys(custId);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);//初始化元素时等待时间
		
		//return PageFactory.initElements(driver, PageTemplate.class);
	}

	public PageTemplate logout() {
		linkText.click();
		partialLinkText.click();
		return this;
	}
}
