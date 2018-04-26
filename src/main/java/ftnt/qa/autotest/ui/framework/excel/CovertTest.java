package ftnt.qa.autotest.ui.framework.excel;

import java.io.File;
import java.util.List;

import org.testng.annotations.Test;

import com.github.crab2died.ExcelUtils;

import ftnt.qa.autotest.ui.framework.excel.model.ConvertModel;

public class CovertTest {
	private static String path = System.getProperty("user.dir") + File.separator + "TestData" + File.separator + "excel"
			+ File.separator;
	private static String exppath = System.getProperty("user.dir") + File.separator + "TestData" + File.separator + "export"
			+ File.separator;
	@Test
	public void test1() throws Exception {
		List<ConvertModel> list =ExcelUtil.readExcel2java(path+"Covert.xlsx", ConvertModel.class);
		
		for (ConvertModel convertModel : list) {
			if (convertModel.getUser().equals("admin")) {
				convertModel.setSuccess(true);//如果用户名是admin，设置测试结果为success
			} else {
				convertModel.setSuccess(false);//否则测试成功的结果为false
			}
		}
		
		ExcelUtils.getInstance().exportObjects2Excel(list,ConvertModel.class , exppath+"Covert_result.xlsx");
	}

}
