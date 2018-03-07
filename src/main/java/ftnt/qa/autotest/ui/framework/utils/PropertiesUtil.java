package ftnt.qa.autotest.ui.framework.utils;


import java.util.HashMap;

/**
 * @author Lei.Wu
 * @see 获取配置文件的值
 */
public class PropertiesUtil {

	private static HashMap<String, String> proKeyValus = null;

	public static void setKeyValueMap(HashMap<String, String> map){
		PropertiesUtil.proKeyValus = map;
	}
	public static String getProValue(String Key){
		return proKeyValus.get(Key);
	}
	
	public static HashMap<String, String> getProKVMap(){
		return proKeyValus;
	}
	public static void main(String[] args) {
		
	}
}

