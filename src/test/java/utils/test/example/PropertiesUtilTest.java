package utils.test.example;
import org.apache.commons.configuration.ConfigurationException;

import ftnt.qa.autotest.ui.framework.utils.CommonsPropertiesUtils;

public class PropertiesUtilTest {
	public static void main(String[] args) throws ConfigurationException {
    	String liString = CommonsPropertiesUtils.ReadSingleProperties("test.propertities","Browser.Type"); 
    	System.out.println("测试读取单个配置文件：key=value:"+liString);
    	System.out.println("测试读取单个配置文件但是读取失败时配置默认值，key=value（default）:"+CommonsPropertiesUtils.ReadSinglePropertiesWithValue("test.propertities","Browser",
				"ftnt.qa.autotest.ui.framework.webdriverfactory.ChromeBrowserDriver"));
    	System.out.println("测试读取多个结果，默认分隔符是逗号，keys=v1,v2,c3"+CommonsPropertiesUtils.ReadMultipleProperties("test.propertities", "keys"));
    	System.out.println("测试读取多个结果，设置分割符是#,keys=v1#v2#c3"+CommonsPropertiesUtils.ReadDefinitionMultipleProperties("test.propertities", "keys2",'#'));
	}

}
