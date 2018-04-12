package ftnt.qa.autotest.ui.framework.testng.listener;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.EmailException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

import ftnt.qa.autotest.ui.framework.constants.CommonConstants;
import ftnt.qa.autotest.ui.framework.utils.CommonsPropertiesUtils;
import ftnt.qa.autotest.ui.framework.utils.DateUtil;
import ftnt.qa.autotest.ui.framework.utils.EmailUtil;
import ftnt.qa.autotest.ui.framework.utils.ZipUtil;

/**
 * 自定义报表监听器
 * @see 自定义报告监听并打包发送测试结果
 * @author Lei.Wu
 * @date 2018-4-2
 * @version FTNT-UI-AutoTest Version 1.0
 * @since Jdk1.8
 */
public class SimpleReportListener implements IReporter {
	private static final Logger logger = LoggerFactory.getLogger(SimpleReportListener.class);
    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
                               String outputDirectory) {
		String path = System.getProperty("user.dir") + File.separator + CommonConstants.TESTNG_OUT_PATH;
		logger.info("#####测试结果存储路径："+path);
		String zip_path = path + File.separator + "Automation_Result_" + DateUtil.getCurrentTime() + ".zip";
		logger.info("#####测试结果打包路径："+zip_path);
		ZipUtil.zip(path, zip_path);
		try {
			if (CommonsPropertiesUtils.ReadSingleProperties(CommonConstants.PROPEERTIES_FILE_PATH, "result.zip.sendemail").equals("true")) {
				try {
					EmailUtil.sendEmailsWithAttachments("自动化测试结果邮件", "请查收附件的测试结果和日志", zip_path);
				} catch (ConfigurationException e) {
					e.printStackTrace();
				}
				logger.info("邮件发送成功");
			} else {
				logger.info("不发送结果zip文件");
			}
		} catch (ConfigurationException e1) {
			e1.printStackTrace();
		} catch (EmailException e1) {
			e1.printStackTrace();
		}
			
		File directory = new File(zip_path);
		try {
			FileUtils.forceDeleteOnExit(directory);//删除打包的文件
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}

