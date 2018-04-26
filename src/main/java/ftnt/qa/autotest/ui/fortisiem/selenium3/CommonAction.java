package ftnt.qa.autotest.ui.fortisiem.selenium3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonAction {
	private WebDriver driver;
	private static final Logger logger = LoggerFactory.getLogger(CommonAction.class);

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public CommonAction(WebDriver driver) {
		this.driver = driver;
	}

	public void excuteJs(WebDriver driver, String javaScript) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(javaScript); // 通过js赋值进去
	}

	// 判断元素是否存在
	public boolean isElementExist(By selector) {
		try {
			driver.findElement(selector);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean isElementExsit(WebDriver driver, By locator) {
		boolean flag = false;
		try {
			WebElement element = driver.findElement(locator);
			flag = null != element;
		} catch (NoSuchElementException e) {
			logger.info("Element:" + locator.toString() + " is not exsit!");
		}
		return flag;
	}

	// 两种判断元素是否存在的方法。

	// 获得元素的文本内容
	public String getWebText(By by) {
		try {
			return driver.findElement(by).getText();
		} catch (NoSuchElementException e) {
			return "Text not existed!";
		}
	}

	// 点击包含特定文本的元素
	public void clickElementContainingText(By by, String text) {
		List<WebElement> elementList = driver.findElements(by);
		for (WebElement e : elementList) {
			if (e.getText().contains(text)) {
				e.click();
				break;
			}
		}
	}

	// 获取元素所指向的Url
	public String getLinkUrl(By by, String text) {
		List<WebElement> subscribeButton = driver.findElements(by);
		String url = null;
		for (WebElement e : subscribeButton) {
			if (e.getText().contains(text)) {
				url = e.getAttribute("href");
				break;
			}
		}
		return url;
	}

	// 文本框赋值
	public void sendKeys(By by, String value) {
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(value);
	}
	
	/**
	* 从一个table的单元格中得到文本值.
	*
	* @param by Table定位器
	* @param row 行坐标 0开始
	* @param col 列坐标 0开始
	* @return
	*/

	public String getCellText(By by, int row, int col) {
		// 得到table元素对象
		WebElement table = driver.findElement(by);
		// 得到table表中所有行对象，并得到所要查询的行对象。
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		WebElement theRow = rows.get(row);
		// 调用getCell方法得到对应的列对象，然后得到要查询的文本。
		String text = getCell(theRow, col).getText();
		return text;
	}

	public WebElement getCell(WebElement Row, int col) {
		List<WebElement> cells;
		WebElement target = null;
		// 列里面有"<th>"、"<td>"两种标签，所以分开处理。
		if (Row.findElements(By.tagName("th")).size() > 0) {
			cells = Row.findElements(By.tagName("th"));
			target = cells.get(col);
		}
		if (Row.findElements(By.tagName("td")).size() > 0) {
			cells = Row.findElements(By.tagName("td"));
			target = cells.get(col);
		}
		return target;
	}

}
