package pageobj.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bsh.This;
import ftnt.qa.autotest.ui.fortisiem.selenium3.GetTableBy;

public class FsmRegisterPage {
	private WebDriver driver;
	private static final Logger logger = LoggerFactory.getLogger(FsmRegisterPage.class);//Slf4j变量

	public FsmRegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}
	
	@FindBy(xpath="//*[@id=\"fileUploadForm\"]/table")
	@CacheLookup
	private WebElement table;
	
	@FindBy(id="filePathInput")
	@CacheLookup
	private WebElement filePath;
	
	@FindBy(id="userIdInput")
	@CacheLookup
	private WebElement userIdInput;
	
	@FindBy(id="passwordInput")
	@CacheLookup
	private WebElement passwordInput;
	
	@FindBy(id="vaBox")
	@CacheLookup
	private WebElement va;
	
	@FindBy(id="spBox")
	@CacheLookup
	private WebElement sp;
	
	@FindBy(id="submitBtn")
	@CacheLookup
	private WebElement submitBtn;
	
//	https://10.30.2.169/phoenix/licenseUpload.html
	
	public boolean  disableUpload() {
		if(submitBtn.isDisplayed()) {
			return submitBtn.isEnabled();
		}else {
			return false;
		}
	}
	
	public void upLoad(String filePath,String userId,String pwd,String type) throws InterruptedException {
		this.filePath.sendKeys(filePath);
		this.userIdInput.sendKeys(userId);
		this.passwordInput.sendKeys(pwd);
		if (type.equals("va")) {
			this.va.click();
		} else {
			this.sp.click();
		}
		
//		if(disableUpload()==true) {
//			submitBtn.click();
//		}else {
//			logger.info("Button is not disabled");
//		}
		Thread.sleep(3000);
		//this.submitBtn.click();
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
	}
	
	public String getHardWareId() {
		GetTableBy getTableBy = new GetTableBy(driver);
		return getTableBy.getCellText(By.xpath("//*[@id=\"fileUploadForm\"]/table"), 0, 1, "tbody");
	}

}
