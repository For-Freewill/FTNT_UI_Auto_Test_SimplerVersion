package ftnt.qa.autotest.ui.framework.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

import javax.annotation.Resource;

import ftnt.qa.autotest.ui.framework.constants.CommonConstants;

public class InitPropertiesUtil {

	/**
	 * @author Lei.Wu
	 * @throws 将config下的所有配置文件的内容加载到MAP中，方便快速获取配置文件的值
	 */

	public InitPropertiesUtil() {
		String path=System.getProperty("user.dir");
        System.out.println("init path=="+path);
		PropertiesUtil.setKeyValueMap(initKeyValueMap(path));
	}

	public HashMap<String, String> initKeyValueMap(String floderPath) {
		HashMap<String, String> proKeyValus = new HashMap<String, String>();
		ArrayList<File> proFiles = getConfigFiles(new File(floderPath));
		try {
			for (File f : proFiles) {
				setKeyValueToMap(f, proKeyValus);
			}
			if (proKeyValus.isEmpty()) {
				throw new Exception("have no properties files or properties files have no key-value");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return proKeyValus;
	}

	/**
	 * @author Lei.Wu
	 * @see 将所有properties文件的key,value存入到map中，实现properties值的跨文件读取和快速读取。
	 */

	private void setKeyValueToMap(File f, HashMap<String, String> proKeyValues) throws Exception {
		Enumeration<?> en = geProObj(f.getAbsolutePath()).propertyNames();
		while (en.hasMoreElements()) {
			String key = (String) en.nextElement();
			String Property = geProObj(f.getAbsolutePath()).getProperty(key);
			proKeyValues.put(key, Property);
		}
	}

	/**
	 * @author Lei.Wu
	 * @param floderPath 文件夹在工程中的路径
	 * @param files 存放文件的列表对象
	 * @see 递归获取此文件夹下的所有配置文件
	 */

	public static ArrayList<File> getConfigFiles(File floderPath, ArrayList<File> files) {
		for (File f : floderPath.listFiles()) {
			if (f.isFile() && f.getName().endsWith(".properties")) {
				files.add(f);
				continue;
			}
			getConfigFiles(f, files);
		}
		return files;
	}

	public static ArrayList<File> getConfigFiles(File floderPath) {
		ArrayList<File> files = new ArrayList<File>();
		return getConfigFiles(floderPath, files);
	}

	/**
	 * @author Lei.Wu
	 * @see 初始化properties文件的对象
	 */

	private Properties geProObj(String FilePath) throws Exception {
		Properties p = new Properties();
		InputStream ins = null;
		try {
			ins = new BufferedInputStream(new FileInputStream(FilePath));
			p.load(ins);
			ins.close();
		} catch (Exception e) {
			throw new Exception("can not find the properties file : " + FilePath);
		}
		return p;
	}

}