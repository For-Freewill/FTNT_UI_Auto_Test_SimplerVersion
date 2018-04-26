package ftnt.qa.autotest.ui.framework.excel;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import com.github.crab2died.ExcelUtils;

import ftnt.qa.autotest.ui.framework.excel.model.AdminOrgModel;
import ftnt.qa.autotest.ui.framework.excel.model.TestModel;

public class ExportTest {
	private static String path = System.getProperty("user.dir") + File.separator + "TestData" + File.separator + "excel"
			+ File.separator;
	private static String exppath = System.getProperty("user.dir") + File.separator + "TestData" + File.separator + "export"
			+ File.separator;

	
	
    /*---------------------------------------无模板无注解导出----------------------------------------------------*/
    /*  一. 操作流程 ：                                                                                           */
    /*      1) 写入表头内容(可选)                                                                                  */
    /*      2) 写入数据内容                                                                                       */
    /*  二. 参数说明                                                                                              */
    /*      *) data             =>      导出内容List集合                                                          */
    /*      *) header           =>      表头集合,有则写,无则不写                                                   */
    /*      *) sheetName        =>      Sheet索引名(默认0)                                                        */
    /*      *) isXSSF           =>      是否Excel2007及以上版本                                                   */
    /*      *) targetPath       =>      导出文件路径                                                              */
    /*      *) os               =>      导出文件流                                                                */

	
	//直接把List<?>data写入到指定excel的第一个sheet，从第一行开始写入，无表头
	@Test(enabled=false)
	public void export1() throws Exception {
		List<List<String>> list = new ArrayList<>();
		list.add(0, Arrays.asList("r1_col1","r1_col2","r1_col3"));
		list.add(1, Arrays.asList("r2_col1","r2_col2","r2_col3"));
		ExcelUtils.getInstance().exportObjects2Excel(list, path+"Admin_Setup_Export.xlsx");
	}
	
	//直接把List<?>data写入到指定excel的第一个sheet，从第一行开始写入，指定表头header的List<String>
	@Test(enabled=false)
	public void export2() throws Exception {
		List<String> header = Arrays.asList("列1","列2","列3");
		
		List<List<String>> list = new ArrayList<>();
		list.add(0, Arrays.asList("r1_col1","r1_col2","r1_col3"));
		list.add(1, Arrays.asList("r2_col1","r2_col2","r2_col3"));
		ExcelUtils.getInstance().exportObjects2Excel(list, header, path+"Admin_Setup_Export.xlsx");
	}
	
	//直接把List<?>data写入到指定excel的第一个自定义的sheet（名字：custsheet），从第一行开始写入，指定表头header的List<String>
	@Test(enabled=false)
	public void export3() throws Exception {
		List<String> header = Arrays.asList("列1","列2","列3");
		
		List<List<String>> list = new ArrayList<>();
		list.add(0, Arrays.asList("r1_col1","r1_col2","r1_col3"));
		list.add(1, Arrays.asList("r2_col1","r2_col2","r2_col3"));
		ExcelUtils.getInstance().exportObjects2Excel(list, header, "custsheet",true,path+"Admin_Setup_Export.xlsx");
	}
	
    /*--------------------------------------无模板基于注解导出---------------------------------------------------*/
    /*  一. 操作流程 ：                                                                                            */
    /*      1) 根据Java对象映射表头                                                                                */
    /*      2) 写入数据内容                                                                                       */
    /*  二. 参数说明                                                                                              */
    /*      *) data             =>      导出内容List集合                                                          */
    /*      *) isWriteHeader    =>      是否写入表头                                                              */
    /*      *) sheetName        =>      Sheet索引名(默认0)                                                        */
    /*      *) clazz            =>      映射对象Class                                                             */
    /*      *) isXSSF           =>      是否Excel2007及以上版本                                                   */
    /*      *) targetPath       =>      导出文件路径                                                              */
    /*      *) os               =>      导出文件流                                                                */
	
	@Test(enabled=false)
	public void export4() throws Exception {
		System.out.println(exppath+"Test.xlsx");
		List<TestModel> list = ExcelUtil.readExcel2java(exppath+"Test.xlsx", TestModel.class,0,1,0);
		for (TestModel testModel : list) {
			testModel.setName("name1");
			testModel.setAge("20");
			testModel.setSex("男");
		}
		ExcelUtils.getInstance().exportObjects2Excel(list, TestModel.class, exppath+"Test_Export.xlsx");
	}
	
	
    /**
     * 无模板、基于注解的数据导出
     *
     * @param data          待导出数据
     * @param clazz         {@link com.github.crab2died.annotation.ExcelField}映射对象Class
     * @param isWriteHeader 是否写入表头
     * @param sheetName     指定导出Excel的sheet名称
     * @param isXSSF        导出的Excel是否为Excel2007及以上版本(默认是)
     * @param targetPath    生成的Excel输出全路径
     */
	@Test()
	public void export5() throws Exception {
		System.out.println(exppath+"Test.xlsx");
		List<TestModel> list = ExcelUtil.readExcel2java(exppath+"Test.xlsx", TestModel.class,0,1,0);
		for (TestModel testModel : list) {
			testModel.setName("name1");
			testModel.setAge("20");
			testModel.setSex("男");
		}
		ExcelUtils.getInstance().exportObjects2Excel(list, TestModel.class, true,"sh1",true,exppath+"Test_Export.xlsx");
	}
	
	
	
	
	
	
	
	
	

	
	
	

}
