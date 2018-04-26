package ftnt.qa.autotest.ui.fortisiem.selenium3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetTableOld {
	private String locator;
	private WebDriver driver;

	/**
	 * 表格初始化，入参为driver和table的定位，使用xpath相对路径的方式定位table
	 * 
	 * @param dr
	 * @param locator:Xpath
	 */
	public GetTableOld(WebDriver dr, String locator) {
		this.driver = dr;
		this.locator = locator;
	}

	/**
	 * 根据行列坐标，取单元格里的内容，标题和操作区从1开始计算
	 * 
	 * @param row
	 * @param col
	 * @return
	 */
	public String getCellText(int row, int col) {
		// 拼接单元格的路径
		String xpath = locator +"/tr[" + row + "]/td[" + col + "]";
		WebElement cell = driver.findElement(By.xpath(xpath));
		return cell.getText();
	}
}
