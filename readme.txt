############ 常见WEB元素处理手册 ###########

1-输入框（input）
1-1：定位输入框：WebElement element = driver.findElement(By.id("passwd-id"));
1-2：输入框清空：element.clear();
1-3：输入框中输入内容：element.sendKeys(“test”);
1-4：获取输入框的文本内容：:element.getAttribute("value");


2-下拉选择框(Select)
2-1：定位下拉选择框：Select select = new Select(driver.findElement(By.id("areaID")));
2-2：选择对应的选择项：
	select.selectByVisibleText(“北京市”); //通过可见文本去选择
	select.selectByValue(“beijing”); //通过html中的value值去选择
	select.selectByIndex(1); //通过index（索引从0开始）选择
2-3：不选择对应的选择项：
	select.deselectAll();
	select.deselectByValue(“替换成实际的值”);
	select.deselectByVisibleText(“替换成实际的值”);
	或者获取选择项的值：
	select.getAllSelectedOptions(); //多选列表，list循环可获取到对应的值
	select.getFirstSelectedOption().getText(); //单选列表直接获取值

3-单选项(Radio Button)
3-1：定位单选框：WebElement r_sex =driver.findElement(By.id("sexID1 "));
3-2：选择某个单选项：r_sex.click();
3-3：清空某个单选项：r_sex.clear(); //必须是clear，单选框无法取消选择
3-4：判断某个单选项是否已经被选择：r_sex.isSelected(); //返回的是Boolean类型

4-多选框（CheckBox）
4-1：定位多选框：WebElement checkbox =driver.findElement(By.id("替换成实际的定位的值"));
4-2：checkbox.click(); //点击复选框
4-3：checkbox.clear(); //清除复选框
4-4：checkbox.isSelected(); //判断复选框是否被选中
4-5：checkbox.isEnabled(); //判断复选框是否可用

5-按钮（button）
5-1：定位按钮元素：WebElement saveButton = driver.findElement(By.id("替换成实际的定位的值"));
5-2：点击按钮：saveButton.click();
5-3：判断按钮是否可用：saveButton.isEnabled ();

6-左右选择框（也就是左边是可供选择项，选择后移动到右边的框中，反之亦然。）
	Select lang = new Select(driver.findElement(By.id("languages"))); //先处理选择框
	lang.selectByVisibleText(“English”);
	WebElement addLanguage =driver.findElement(By.id("addButton")); //再处理向右移动的按钮
	addLanguage.click();


################ WebElement的全部方法 #######################
click()
submit()
sendKeys(CharSequence...)
clear()
getTagName()
getAttribute(String)
isSelected()
isEnabled()
getText()
findElements(By)
findElement(By)
isDisplayed()
getLocation()
getSize()
getRect()
getCssValue(String)
######################################################

7-弹出对话框（alert）如何区分页面对话框和弹出页面：选择弹出框，可以F12查看元素的是弹出页面，否则为弹出框。
7-1：定位对话框：Alert alert = driver.switchTo().alert();
7-2：弹出框确定：alert.accept();
7-3：弹出框关闭：alert.dismiss();
7-3：弹出框文字信息获取：alert.getText();

8-表单（form）
8-1：定位表单元素：WebElement approve = driver.findElement(By.id("approve"));
8-2：表单提交：approve.submit(); 

9-上传文件（input file）
9-1：定位元素：WebElement adFileUpload = driver.findElement(By.id("替换成实际的定位的值")); //定位上传控件
9-2：定义上传文件的路径：String filePath = "C:\\test\\uploadfile \\test.jpg"; //定义了一个本地文件的路径
9-3：上传框赋值：adFileUpload.sendKeys(filePath); //为上传控件进行赋值操作，将需要上传的文件的路径赋给控件

10-Action:拖拉元素到新位置
10-1：定义src,dst元素：
	WebElement element =driver.findElement(By.name("source")); //定义第一个元素
	WebElement target = driver.findElement(By.name("target")); //定义第二个元素
10-2：dragAndDrop元素：(new Actions(driver)).dragAndDrop(element, target).perform(); //将第一个元素拖拽到第二个元素

11-Action:鼠标悬停
11-1:初始化action：Actions builder = new Actions(driver);
11-2：悬停：builder.moveToElement(driver.findElement(locator)).perform(); //locator是目标元素的定位器

12-框架（Frame）
12-1:frame序号定位：driver.switchTo().frame(Int index); //传入参数为frame的序号，从0开始
12-2:frame ID定位：driver.switchTo().frame(String nameOrId); //传入参数为frame的ID或者Name属性
12-3:frame父级定位：driver.switchTo().parentFrame(); //切换回父级 –高版本selenium可用
12-4:frame默认定位：driver.switchTo().defaultContent(); //切换回默认
// 得到当前窗口的句柄
String currentWindow = driver.getWindowHandle();
// 得到所有窗口的句柄
Set<String> handles = driver.getWindowHandles();
Iterator<String> it = handles.iterator();
while (it.hasNext()) {
	String handle = it.next();
	if (currentWindow.equals(handle))
	continue; //跳出当前循环
	WebDriver window = driver.switchTo().window(handle);
	log.info("title,url = " + window.getTitle() + ","
	+ window.getCurrentUrl());
}
// 切换到指定的窗口存在--遍历最多10次（String windowTitle）
for (int a = 0; a < =9; a++) { //循环1
	Set<String> windowHandles = driver.getWindowHandles();
	for (String handler : windowHandles) { //循环2
		driver.switchTo().window(handler); //尝试切换
		String title = driver.getTitle();
		if (“预期结果”.equals(title)) {
			a = 10;
			break; //跳出循环2
		}
	}
}
理想情况下foreach循环可以获得正确的句柄，但是添加外层循环是为了提高稳定性，个别浏览器下有的时候一次遍历找不到。
/**
* Switches to the non-current window(切换到非当前窗口)
*/
public void switchOtherWindow() throws NoSuchWindowException, NoSuchWindowException {
	Set<String> handles = driver.getWindowHandles();
	String current = driver.getWindowHandle();
	handles.remove(current);
	String newHandle = handles.iterator().next();
	driver.switchTo().window(newHandle);
}


13-多浏览器窗口的处理（Windows） 
13-1：单窗口：只弹出一个窗口的情况,不需要传入任何参数,直接切换到下一个窗口
13-2：得到当前窗口的句柄：String currentWindow = driver.getWindowHandle();
13-3：得到所有窗口的句柄：Set<String> handles = driver.getWindowHandles();
13-4：多窗口切换：参考CommonAction类方法

14-处理对话框alert\confirm\prompt
14-1：处理alert
	driver.findElement(By.id("alert")).click(); //点击会触发alert的元素，比如按钮
	Alert alert = driver.switchTo().alert();
	String text = alert.getText(); //获取alert上的文本
	System.out.println(text);
	alert.dismiss(); //关闭alert
14-2：处理confirm
	driver.findElement(By.id("confirm")).click(); //点击会触发confirm的元素，比如按钮
	Alert confirm = driver.switchTo().alert();
	String text1 = confirm.getText(); //获取confirm上的文本
	System.out.println(text1);
	confirm.accept(); //关闭confirm
14-3：处理prompt
	driver.findElement(By.id("prompt")).click(); //点击会触发prompt的元素，比如按钮
	Alert prompt = driver.switchTo().alert();
	String text2 = prompt.getText(); //获取prompt上的文本
	System.out.println(text2);
	prompt.sendKeys("ok!!!!"); //输入值，如果支持输入的话
	prompt.accept(); //关闭prompt

15-表格的处理（table） 
15-1：定位表格：WebElement element =driver.findElement(By.name("table"));
15-2：表格内容获取：参考CommonAction方法

16-富文本编辑器（执行js脚本）

16-1：富文本编辑框的处理 driver.switchTo().frame("ueditor_0"); //定位到富文本输入框所在的frame 
16-2：JavascriptExecutor js = (JavascriptExecutor) driver; 
16-3：js.executeScript("document.body.innerHTML='ABCDEFG'"); //通过js赋值进去
例子：日期框赋值
	driver.get(baseUrl);
    //driver.findElement(By.id("datetimeID")).sendKeys("2017-10-16"); //特殊表单控件无法通过sendkeys赋值
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("document.getElementById('datetimeID').setAttribute('value','2017-10-16');"); //可以通过执行JS语句操作页面元素
 
例子2：滚动条
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("document.documentElement.scrollTop=1500");
	
######################## Actions全部方法介绍 ############################
17-Actions解析
	keyDown(Keys.ATL) //按下键ALT
	keyDown(WebElement, Keys.ATL)//定位到元素后按下键
	keyUp(Keys.F4) //释放键
	keyUp(WebElement, CharSequence)//定位到元素后释放
	sendKeys(CharSequence...)//普通按键操作：action.sendKeys(Keys.ENTER).perform();（按下enter键）
	sendKeys(WebElement, CharSequence...)
	clickAndHold(WebElement)//鼠标左键点击后不放
	clickAndHold()
	release(WebElement)//释放鼠标左键
	release()
	click(WebElement)//鼠标左键点击
	click()
	doubleClick(WebElement)//鼠标左键双击
	doubleClick()
	moveToElement(WebElement)//鼠标指向元素并悬停
	moveToElement(WebElement, int, int)
	moveByOffset(int, int)
	contextClick(WebElement)//鼠标右击
	contextClick()
	dragAndDrop(WebElement, WebElement)//鼠标拖拉元素
	dragAndDropBy(WebElement, int, int)
	pause(long)
	pause(Duration)
	tick(Interaction...)
	tick(Action)
	build()
	perform()//执行动作
例子：
    driver.get(baseUrl);
    WebElement account = driver.findElement(By.id("accountID"));
    WebElement password = driver.findElement(By.id("passwordID"));
    account.sendKeys("123");//输入字符串。webelement的sendkeys方法注意与Action的sendkeys的区别。一个是输入字符串，一个是按下键盘普通键
    Actions action3 = new Actions(driver);//初始化actions类。
    action3.sendKeys(account,Keys.TAB).perform();//按tab键
    Thread.sleep(3000);
    action3.keyDown(Keys.CONTROL).sendKeys("a").perform();//按ctrl+a键全选
################################################################################

18-Cookie操作
18-1：增加cookie：	
	//增加一个name = "name",value="value"的cookie
	Cookie cookie = new Cookie("name", "value");
	driver.manage().addCookie(cookie);
18-2：得到当前页面下所有的cookies，并且输出它们的所在域、name、value、有效日期和路径
	Set<Cookie> cookies = driver.manage().getCookies();
	System.out.println(String.format("Domain -> name -> value -> expiry -> path"));
	for(Cookie c : cookies)
	System.out.println(String.format("%s -> %s -> %s -> %s -> %s",
	c.getDomain(), c.getName(), c.getValue(),c.getExpiry(),c.getPath()));
18-3：删除cookie有三种方法
	//第一种通过cookie的name
	dr.manage().deleteCookieNamed("CookieName");
	//第二种通过Cookie对象
	dr.manage().deleteCookie(cookie);
	//第三种全部删除
	dr.manage().deleteAllCookies();

19-DOM操作（配合excuteJS函数）
19-1：查找节点
	document.getElementById('id属性值');	返回拥有指定id的第一个对象的引用
	document/element.getElementsByClassName('class属性值');	返回拥有指定class的对象集合
	document/element.getElementsByTagName('标签名');	返回拥有指定标签名的对象集合
	document.getElementsByName('name属性值');	返回拥有指定名称的对象结合
	document/element.querySelector('CSS选择器');	仅返回第一个匹配的元素
	document/element.querySelectorAll('CSS选择器');	返回所有匹配的元素
	document.documentElement	获取页面中的HTML标签
	document.body	获取页面中的BODY标签
	document.all['']	获取页面中的所有元素节点的对象集合型
 
19-2：新建节点
	document.createElement('元素名');	创建新的元素节点
	document.createAttribute('属性名');	创建新的属性节点
	document.createTextNode('文本内容');	创建新的文本节点
	document.createComment('注释节点');	创建新的注释节点
	document.createDocumentFragment( );	创建文档片段节点
	
19-3：添加新节点
	parent.appendChild( element/txt/comment/fragment );	向父节点的最后一个子节点后追加新节点
	parent.insertBefore( newChild, existingChild );	向父节点的某个特定子节点之前插入新节点
	element.setAttributeNode( attributeName );	给元素增加属性节点
	element.setAttribute( attributeName, attributeValue );	给元素增加指定属性，并设定属性值
 
19-4：删除节点
	parentNode.removeChild( existingChild );	删除已有的子节点，返回值为删除节点
	element.removeAttribute('属性名');	删除具有指定属性名称的属性，无返回值
	element.removeAttributeNode( attrNode );	删除指定属性，返回值为删除的属性 

19-5：修改节点
	parentNode.replaceChild( newChild, existingChild );	用新节点替换父节点中已有的子节点
	element.setAttributeNode( attributeName );	若原元素已有该节点，此操作能达到修改该属性值的目的
	element.setAttribute( attributeName, attributeValue );	若原元素已有该节点，此操作能达到修改该属性值的目的

例子：
1-设置元素的只读属性为false
	new CommonAction(driver).excuteJs(driver, "document.getElementById(\"filePathInput\").readOnly=false");
2-移除元素的隐藏属性，使元素可见
	new CommonAction(driver).excuteJs(driver, "document.getElementById(\"submitBtn\").removeAttribute(\"disabled\");");
		