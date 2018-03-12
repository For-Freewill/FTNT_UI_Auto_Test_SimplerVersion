package ftnt.qa.autotest.ui.framework.constants;

public class CommonConstants {
	static String projPath = System.getProperty("user.dir");
	public static final String  IE_DRIVER_FIELD="webdriver.ie.driver";
	public static final String  IE_DRIVER_PATH="/BrowserDriver/IEDriverServer.exe";
	
	public static final String  CHROME_DRIVER_FIELD="webdriver.chrome.driver";
	public static final String  CHROME_DRIVER_PATH=projPath+"/BrowserDriver/chromedriver.exe";
	
	public static final String  FIREFOX_DRIVER_FIELD="webdriver.gecko.driver";
	public static final String  FIREFOX_DRIVER_PATH=projPath+"/BrowserDriver/geckodriver.exe";
	
	public static final Integer RETRY_COUNT=1;
	
	public static final String  CONFIG_FOLDER_PATH_KEY="config";
	public static final String  CONFIG_FOLDER_PATH_VALUE=projPath+"framework.properties";
	
	public static final String  KILL_DRIVER_PROCESS_BAT="\\BrowserDriver\\cleanBrowers.bat";
}
