package pageobj.test;

import java.io.File;
import java.io.IOException;

import org.apache.bcel.generic.NEW;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegisterServerPage {
	private WebDriver driver;//driver变量
	private static final Logger logger = LoggerFactory.getLogger(RegisterServerPage.class);//Slf4j变量


	public RegisterServerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}

	@FindBy(name = "ipAddress")
	@CacheLookup
	private WebElement ipAddress;
	
	@FindBy(name = "serialNumber")
	@CacheLookup
	private WebElement serialNumber;
	
	@FindBy(name = "uuid")
	@CacheLookup
	private WebElement uuid;
	
	@FindBy(name = "device")
	@CacheLookup
	private WebElement device;
	
	@FindBy(name = "expiration_date")
	@CacheLookup
	private WebElement expiration_date;
	
	@FindBy(name = "ep_device")
	@CacheLookup
	private WebElement ep_device;
	
	@FindBy(name = "ep_expiration_date")
	@CacheLookup
	private WebElement ep_expiration_date;
	
	@FindBy(name = "eps_qty")
	@CacheLookup
	private WebElement eps_qty;
	
	@FindBy(name = "eps_expiration_date")
	@CacheLookup
	private WebElement eps_expiration_date;
	
	@FindBy(name = "ioc_expiration_date")
	@CacheLookup
	private WebElement ioc_expiration_date;
	
	@FindBy(name = "support_expiration_date")
	@CacheLookup
	private WebElement support_expiration_date;
	
	@FindBy(name = "wa_basic_devices")
	@CacheLookup
	private WebElement wa_basic_devices;
	
	@FindBy(name = "wa_basic_expiration_date")
	@CacheLookup
	private WebElement wa_basic_expiration_date;
	
	@FindBy(name = "wa_advanced_devices")
	@CacheLookup
	private WebElement wa_advanced_devices;
	
	@FindBy(name = "wa_advanced_expiration_date")
	@CacheLookup
	private WebElement wa_advanced_expiration_date;
	
	@FindBy(name = "collectorsettings")
	@CacheLookup
	private WebElement collectorsettings;
	
	public String downloadPath="C:\\Users\\admin\\Downloads\\";
	
	public void clearPath() throws IOException {
		FileUtils.forceDeleteOnExit(new File(downloadPath));
	}
	
	public String generateLicense(String ip,String uuid,String device,String date) {
		this.ipAddress.sendKeys(ip);
		this.serialNumber.sendKeys();
		this.uuid.sendKeys(uuid);
		this.device.sendKeys(device);
		this.expiration_date.sendKeys(date);
		this.ep_device.sendKeys(device);
		this.eps_qty.sendKeys(device);
		this.wa_basic_devices.sendKeys(date);
		this.wa_advanced_devices.sendKeys(date);
		this.collectorsettings.submit();
		return downloadPath+ip+".lic";
	}
	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		FileUtils.forceDeleteOnExit(new File("C:\\Users\\admin\\Downloads\\"));
		driver.get("https://172.30.53.116:5580/");
		driver.manage().window().maximize();
		driver.findElement(By.name("ipAddress")).sendKeys("10.30.2.169");
		driver.findElement(By.name("uuid")).sendKeys("123123123");
		driver.findElement(By.name("collectorsettings")).submit();
		
	}
	
	

}
