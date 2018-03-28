package ftnt.qa.autotest.ui.framework.utils;

import java.util.List;

import org.apache.commons.configuration.AbstractConfiguration;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
public class CommonsPropertiesUtils {  
      
    public static void main(String[] args) throws ConfigurationException {  
    	String liString = ReadSingleProperties("framework.properties","Browser.Type"); 
    	System.out.println(liString);
    }  
    
    //读取单个键值对类型的配置文件，例如： host=1.1.1.1,必须设置默认值，这样读取不到的时候，会传默认值
    public static String ReadSinglePropertiesWithValue(String filePath,String key,String defvalue) throws ConfigurationException {
    	Configuration config;
		config = new PropertiesConfiguration(filePath);
		String value =config.getString(key,defvalue);
		return value;
    }
    
    //读取单个键值对类型的配置文件，例如： host=1.1.1.1,无默认值
    public static String ReadSingleProperties(String filePath,String key) throws ConfigurationException {
    	Configuration config;
		config = new PropertiesConfiguration(filePath);
		String value =config.getString(key);
		return value;
    }
    
    //如果在properties属性使用逗号分隔，keys=cn,com,org,uk,edu,jp,hk，这样的类似一个值含有多个元素值   
    public static String[] ReadMultipleProperties(String filePath,String key) throws ConfigurationException {
    	Configuration config;
		config = new PropertiesConfiguration(filePath);
		String[] values =config.getStringArray(key);
		return values;
    }
    
  //如果在properties属性使用逗号分隔，keys=cn,com,org,uk,edu,jp,hk，这样的类似一个值含有多个元素值   
    public static List<Object> ReadDefinitionMultipleProperties(String filePath,String key,char delimiter) throws ConfigurationException {
        AbstractConfiguration.setDefaultListDelimiter(delimiter);  
        Configuration config = new PropertiesConfiguration("config.properties");  
        List<Object> values=config.getList("con");  
		return values;
    }

}  
