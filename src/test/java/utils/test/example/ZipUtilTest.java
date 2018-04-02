package utils.test.example;

import ftnt.qa.autotest.ui.framework.utils.ZipUtil;

public class ZipUtilTest {
	public static void main(String[] args) {
		String outpath = System.getProperty("user.dir")+"\\test-output\\";
		String outzip = outpath+"result3.zip";
		System.out.println(outpath);
		ZipUtil.zip(outpath, outzip);
	}
}
