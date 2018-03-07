package ftnt.qa.autotest.ui.framework.testng.listener;


import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import ftnt.qa.autotest.ui.testbase.TestBase;

public class ScreenShotOnFailure {

	private final static String SCREEN_SHOT_PATH = "test-output/screen-shot";
	private static String SCREEN_SHOT_NAME = null;

	public static void takeScreentShot() throws IOException {
		File screenShotDir = new File(SCREEN_SHOT_PATH);
		if (!screenShotDir.exists()) {
			screenShotDir.mkdirs();
		}

		SCREEN_SHOT_NAME = "Screenshot_"+String.valueOf(new Date().getTime()) + ".jpg";
		FileUtils.copyFile(TestBase.getWebDriver().getScreenshotAs(OutputType.FILE),
				new File(SCREEN_SHOT_PATH + "/" + SCREEN_SHOT_NAME));
	}

	public static String getScreenShotPath() {
		return SCREEN_SHOT_PATH;
	}

	public static String getScreenShotName() {
		return SCREEN_SHOT_NAME;
	}
}
