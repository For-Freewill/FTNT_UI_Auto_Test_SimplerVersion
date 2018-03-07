package ftnt.qa.autotest.ui.fortisiem.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

/**
 * Created by ssuku on 1/9/17.
 */
public class Login {
    private WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "loginHtml:username")
    private WebElement userName;
    @FindBy(id = "loginHtml:password")
    private WebElement password;
    @FindBy(id = "loginHtml:domain")
    private WebElement domain;
    @FindBy(id = "loginHtml:userDomain")
    private WebElement userDomain;
    @FindBy(id = "loginHtml:loginBtn")
    private WebElement loginBtn;
    @FindBy(css = "ul.nav.navbar-nav.navbar-right.header-menu li:nth-child(3)")
    private WebElement userIcon;
    @FindBy(partialLinkText = "Logout")
    private WebElement logout;
    @FindBy(css = "div.errors ul li")
    private WebElement errorMsg;
    @FindBy(id = "si_searchAttrInput")
    private WebElement searchAttrInput;

    public Login login(String userName, String password, String custId, String domain) {
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        this.domain.clear();
        this.domain.sendKeys(custId);
        Select select = null;
        for (int i = 0; i < 3; i++) {
            try {
                select = new Select(userDomain);
                select.selectByVisibleText(domain);
                break;
            } catch (org.openqa.selenium.StaleElementReferenceException e) {
            }
        }
        loginBtn.click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return PageFactory.initElements(driver, Login.class);
    }

    public boolean isLoggedIn() {
        boolean result = true;
        // check if input search box can be located
        try {
            //new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOf(searchAttrInput));
        } catch (org.openqa.selenium.TimeoutException e) {
            result = false;
        }
        return result;
    }

    public String getErrorMsg() {
        return errorMsg.getText();
    }

    public Login logout() {
        userIcon.click();
        logout.click();
        return this;
    }
}
