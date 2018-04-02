package ftnt.qa.autotest.ui.framework.utils;

import java.io.IOException;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ftnt.qa.autotest.ui.framework.constants.CommonConstants;
import ftnt.qa.autotest.ui.testbase.TestBase;

public class ExcuteBatCommand {
	private static final Logger logger = LoggerFactory.getLogger(ExcuteBatCommand.class);
	public static void executeBatFile(String batPath) {
		
		String strcmd = "cmd /c start "+batPath;
		Runtime rt = Runtime.getRuntime(); //Runtime.getRuntime()返回当前应用程序的Runtime对象
        Process ps = null;  //Process可以控制该子进程的执行或获取该子进程的信息。
        try {
            ps = rt.exec(strcmd);   //该对象的exec()方法指示Java虚拟机创建一个子进程执行指定的可执行程序，并返回与该子进程对应的Process对象实例。
            ps.waitFor();  //等待子进程完成再往下执行。
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int i = ps.exitValue();  //接收执行完毕的返回值
        if (i == 0) {
        	logger.info("#####清理浏览器进程成功#####");
        } else {
            logger.info("#####清理浏览器进程成功#####");
        }

        ps.destroy();  //销毁子进程
        ps = null;   
	}
	public static void main(String[] args) throws URISyntaxException {
		String pth1=System.getProperty("user.dir");
		System.out.println(pth1);
		System.out.println(pth1);
		executeBatFile(pth1+CommonConstants.KILL_DRIVER_PROCESS_BAT);
	}

}
