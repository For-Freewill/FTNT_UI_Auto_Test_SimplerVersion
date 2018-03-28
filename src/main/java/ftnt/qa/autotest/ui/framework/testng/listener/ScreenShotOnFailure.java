package ftnt.qa.autotest.ui.framework.testng.listener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;


/**
 * 失败Case保存截图并保存到指定目录
 * @see 监听器实现失败截图
 * @author Lei.Wu
 * @date 2018-3-12
 * @version FTNT-UI-AutoTest Version 1.0
 * @since Jdk1.8
 */

public class ScreenShotOnFailure {

    private WebDriver driver;
    
    
    private String path;// 测试失败截屏保存的路径()
    private String pngfile; //失败截屏保存的图片名 :ScreenShotOnFail_LoginTest_2018-03-09 15-16-02.png

    public ScreenShotOnFailure(WebDriver driver,ITestResult tr){
        this.driver=TestNGListener.driver;//如果不合并三个监听器，这里初始化就用this.driver=driver
        path=System.getProperty("user.dir")+ "\\test-output\\screen-shot\\";
        pngfile=path+this.getClass().getSimpleName()+"_"+tr.getName()+"_"+getCurrentTime() + ".png";
    }

	public void getScreenShot() {
		File screenShotDir = new File("test-output/screen-shot");
		if (!screenShotDir.exists()) {
			screenShotDir.mkdirs();
		}
        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);//selenium封装的截图
        File screenFile = new File(pngfile);
        try {
            FileUtils.copyFile(screen, screenFile);
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