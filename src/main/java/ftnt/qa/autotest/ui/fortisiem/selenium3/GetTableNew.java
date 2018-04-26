package ftnt.qa.autotest.ui.fortisiem.selenium3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetTableNew {
	private String locator;
	private WebDriver driver;

	/**
	 * 表格初始化，入参为driver和table的定位，使用xpath相对路径的方式定位table
	 * 
	 * @param dr
	 * @param locator:Xpath or CSS
	 */
	public GetTableNew(WebDriver dr, String locator) {
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
	public String xpathCellText(int row, int col) {
		String xpath = null;
		WebElement locatorElement = driver.findElement(By.xpath(locator));
		
		//判断table xpath下面是否有tbody元素，如果有，构造Xpath时添加tbody。【次函数有BUG，没有考虑tfoot,thead.添加多个if也是BUG，参考GetTableBy实现】
		if (locatorElement.findElements(By.tagName("tbody")).size()>0) {
			xpath = locator +"/tbody"+"/tr[" + row + "]/td[" + col + "]";
		} else {
			xpath = locator +"/tr[" + row + "]/td[" + col + "]";
		} 
		
		WebElement cell = driver.findElement(By.xpath(xpath));
		return cell.getText();
	}
	
	public String cssCellText(int row, int col) {
		String cssPath = null;
		WebElement locatorElement = driver.findElement(By.cssSelector(locator));
		
		/*
		 * 待完善CSS选择器的选择
		 * table > tbody > tr:nth-child(1) > td:nth-child(3)
		 * */
		if (locatorElement.findElements(By.tagName("tbody")).size()>0) {
			cssPath = locator +">tbody"+">tr:nth-child(" + row + ")" +">td:nth-child("+ col + ")";
		} else {
			cssPath = locator +">tr:nth-child(" + row + ")" +">td:nth-child("+ col + ")";
		} 
		
		WebElement cell = driver.findElement(By.cssSelector(cssPath));
		return cell.getText();
	}
}
