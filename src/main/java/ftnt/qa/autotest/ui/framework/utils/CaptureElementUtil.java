package ftnt.qa.autotest.ui.framework.utils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsDriver;
import org.testng.ITestResult;

import ftnt.qa.autotest.ui.framework.constants.CommonConstants;


/**
 * 截取指定元素
 * @see 单例模式，获取指定元素的截图
 * @author Lei.Wu
 * @date 2018-4-24
 * @version FTNT-UI-AutoTest Version 1.0
 * @since Jdk1.8
 */

public class CaptureElementUtil {

    private WebDriver driver;
    private static CaptureElementUtil instance;
	private String path=System.getProperty("user.dir")+ "\\test-output\\screen-shot\\";
    private String pngfile=path+this.getClass().getSimpleName()+"_Element_"+getCurrentTime() + ".png";

 
    private CaptureElementUtil() {
	}

    public static CaptureElementUtil getInstance(){
        if(instance==null){
            instance=new CaptureElementUtil();
        }
        return instance;
    }

    public CaptureElementUtil(WebDriver driver){
        this.driver=driver;
    }

    /*
     * @param element 在PO的类中，需要使用driver.find**的方式获取元素，无法传递@FindBy()定义的元素
     * */
	public void getScreenShot(WebElement element) throws ConfigurationException {
		String screenShotPath = CommonsPropertiesUtils.ReadSingleProperties(CommonConstants.PROPEERTIES_FILE_PATH, "failedcase.screenShotPath");
		File screenShotDir = new File(screenShotPath);
		if (!screenShotDir.exists()) {
			screenShotDir.mkdirs();
		}
		
        File screenFile = new File(pngfile);
        try {
            FileUtils.copyFile(CaptureElement.captureElement(element), screenFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取当前时间
     */
    public String getCurrentTime(){
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String currentTime=sdf.format(date);
        return currentTime; 
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    public String getPngfile() {
		return pngfile;
	}

	public void setPngfile(String pngfile) {
		this.pngfile = pngfile;
	}


}