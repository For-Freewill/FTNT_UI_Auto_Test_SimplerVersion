package ftnt.qa.autotest.ui.fortisiem.testcases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class LogTest {
	
	private static final Logger logger = LoggerFactory.getLogger(LogTest.class);

	public static void main(String[] args) {
		logger.info("输出info");
		logger.debug("输出到debug");
		logger.warn("输出到warn");
		logger.error("输出到error");
	}
	
}
