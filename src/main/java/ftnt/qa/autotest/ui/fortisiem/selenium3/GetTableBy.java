package ftnt.qa.autotest.ui.fortisiem.selenium3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 表格元素获取，By参数支持任意的定位到table元素的
 * @see EmailableReporter源码
 * @author Lei.Wu
 * @date 2018-4-26
 * @version FTNT-UI-AutoTest Version 1.0
 * @since Jdk1.8
 */

public class GetTableBy {
	private WebDriver driver;

	public GetTableBy(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * @param by table元素定位，支持任意定位方式
	 * @param row table行，从0开始
	 * @param col table列，从0开始
	 * @param tbpart table的组成（thead，tbody，tfoot）
	 */
	public String getCellText(By by, int row, int col, String tbpart) {
		List<WebElement> rows = null;
		
		List<WebElement> cells;
		WebElement target = null;
		
		// 得到table表中所有行对象，并得到所要查询的行对象。判断是否有tbody子元素。
		// 传参方式指定table区域
		if (driver.findElement(by).findElements(By.tagName(tbpart)).size() > 0) {
			rows = driver.findElement(by).findElement(By.tagName(tbpart)).findElements(By.tagName("tr"));
		} else {
			rows = driver.findElement(by).findElements(By.tagName("tr"));
		}
		WebElement theRow = rows.get(row);

		// 列里面有"<th>"、"<td>"两种标签，所以分开处理。
		if (theRow.findElements(By.tagName("td")).size() > 0) {
			cells = theRow.findElements(By.tagName("td"));
			target = cells.get(col);
		} else if (theRow.findElements(By.tagName("th")).size() > 0) {
			cells = theRow.findElements(By.tagName("th"));
			target = cells.get(col);
		}

		return target.getText();
	}
	
	/**
	 * @see 处理没有包含tbody,tfoot,thead标签的表格。
	 * @param by table元素定位，支持任意定位方式
	 * @param row table行，从0开始
	 * @param col table列，从0开始
	 */
	
	public String getCellText(By by, int row, int col) {
		WebElement theRow = driver.findElement(by).findElements(By.tagName("tr")).get(row);
		List<WebElement> cells;
		WebElement target = null;
		// 列里面有"<th>"、"<td>"两种标签，所以分开处理。
		if (theRow.findElements(By.tagName("td")).size() > 0) {
			cells = theRow.findElements(By.tagName("td"));
			target = cells.get(col);
		} else if (theRow.findElements(By.tagName("th")).size() > 0) {
			cells = theRow.findElements(By.tagName("th"));
			target = cells.get(col);
		}
		return target.getText();
	}
}
