package ftnt.qa.autotest.ui.framework.testng.listener;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;
import ftnt.qa.autotest.ui.framework.constants.CommonConstants;
import ftnt.qa.autotest.ui.testbase.TestBase;


/**
 * 失败Case 自动重试实现
 * @see 监听器实现自动重试功能
 * @author Lei.Wu
 * @date 2018-3-12
 * @version FTNT-UI-AutoTest Version 1.0
 * @since Jdk1.8
 */


public class RetryToRunCase implements IRetryAnalyzer {

	private int retryCount = 1;
	public static Logger logger=Logger.getLogger(RetryToRunCase.class);
	private static int maxRetryCount;

	public int getRetryCount() {
		return retryCount;
	}

	public static int getMaxRetryCount() {
		return maxRetryCount;
	}

	@SuppressWarnings("static-access")
	public RetryToRunCase() {
		this.maxRetryCount = CommonConstants.RETRY_COUNT;
	}

	public boolean retry(ITestResult result) {
		if (retryCount <= maxRetryCount) {
			String message="方法<"+result.getName()+">执行失败，重试第"+retryCount+"次";
            logger.info(message);
            Reporter.setCurrentTestResult(result);
            Reporter.log(message);
			TestBase.success = false;
			retryCount++;
			return true;
		}
		return false;
	}
}
