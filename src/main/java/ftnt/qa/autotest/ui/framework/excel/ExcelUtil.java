package ftnt.qa.autotest.ui.framework.excel;

import java.io.File;
import java.util.List;

import com.github.crab2died.ExcelUtils;

import ftnt.qa.autotest.ui.framework.excel.model.AdminOrgModel;

public class ExcelUtil {

	/*---------------------------------------1.读取Excel操作无映射-------------------------------------------------*/
	/* 一. 操作流程 ： */
	/* *) 按行读取Excel文件,存储形式为 Cell->String => Row->List<Cell> => Excel->List<Row> */
	/* 二. 参数说明 */
	/* *) excelPath => 目标Excel路径 */
	/* *) InputStream => 目标Excel文件流 */
	/* *) offsetLine => 开始读取行坐标(默认0) */
	/* *) limitLine => 最大读取行数(默认表尾) */
	/* *) sheetIndex => Sheet索引(默认0) */

	/**
	 * 读取Excel表格数据,返回{@code List[List[String]]}类型的数据集合
	 *
	 * @param excelPath
	 *            待读取Excel的路径
	 * @param offsetLine
	 *            Excel表头行(默认是0)
	 * @param limitLine
	 *            最大读取行数(默认表尾)
	 * @param sheetIndex
	 *            Sheet索引(默认0)
	 * @return 返回{@code List<List<String>>}类型的数据集合
	 */

	public static List<List<String>> readExcel2List(String excelPath, int offsetLine, int limitLine, int sheetIndex)
			throws Exception {
		return ExcelUtils.getInstance().readExcel2List(excelPath, offsetLine, limitLine, sheetIndex);
	}

	/**
	 * 读取Excel表格数据,指定excel路径和表头行即可全部读取并存在集合中
	 *
	 * @param excelPath
	 *            待读取Excel的路径
	 * @param offsetLine
	 *            Excel表头行(默认是0)
	 * @return 返回{@code List<List<String>>}类型的数据集合
	 */
	public List<List<String>> readExcel2List(String excelPath, int offsetLine) throws Exception {
		return ExcelUtils.getInstance().readExcel2List(excelPath, offsetLine);
	}

	/**
	 * 读取Excel表格数据,指定excel路径即可全部读取并存在集合中（默认表头第一行，默认第一个sheet，默认全部数据）
	 *
	 * @param excelPath
	 *            待读取Excel的路径
	 * @return 返回{@code List<List<String>>}类型的数据集合
	 */
	public List<List<String>> readExcel2List(String excelPath) throws Exception {
		return ExcelUtils.getInstance().readExcel2List(excelPath);
	}

	/*---------------------------------------2.读取Excel操作基于注解映射--------------------------------------------*/
	/* 一. 操作流程 ： */
	/* 1) 读取表头信息,与给出的Class类注解匹配 */
	/* 2) 读取表头下面的数据内容, 按行读取, 并映射至java对象 */
	/* 二. 参数说明 */
	/* *) excelPath => 目标Excel路径 */
	/* *) clazz => java映射对象 */
	/* *) offsetLine => 开始读取行坐标(默认0) */
	/* *) limitLine => 最大读取行数(默认表尾) */
	/*
	 * *) sheetIndex => Sheet索引(默认0)
	 * 
	 */
	/**
	 * 读取Excel操作基于注解映射成绑定的java对象:可以指定读取行数。
	 * 
	 * @param excelPath
	 *            待导出Excel的路径
	 * @param clazz
	 *            待绑定的类,参考model包下面的类(绑定属性注解{@link com.github.crab2died.annotation.ExcelField})
	 * @param offsetLine
	 *            Excel表头行(默认是0)：表头指的是这一行的信息用于与class映射，表头不读取，表头下的行为实际数据。
	 * @param limitLine
	 *            最大读取行数(默认表尾)，默认值为：
	 * @param sheetIndex
	 *            Sheet索引(默认0)
	 * @param <T>
	 *            绑定的数据类
	 * @return 返回转换为设置绑定的java对象集合
	 * 
	 */
	public static <T> List<T> readExcel2java(String excelPath, Class<T> clazz, int offsetLine, int limitLine,
			int sheetIndex) throws Exception {
		return ExcelUtils.getInstance().readExcel2Objects(excelPath, clazz, offsetLine, limitLine, sheetIndex);
	}

	/**
	 * 读取Excel操作基于注解映射成绑定的java对象：可以读取全部行
	 * 
	 * @param excelPath
	 *            待导出Excel的路径
	 * @param clazz
	 *            待绑定的类(绑定属性注解{@link com.github.crab2died.annotation.ExcelField})
	 * @param offsetLine
	 *            Excel表头行(默认是0)
	 * @param sheetIndex
	 *            Sheet索引(默认0)
	 * @param <T>
	 *            绑定的数据类
	 * @return 返回转换为设置绑定的java对象集合
	 */
	public static <T> List<T> readExcel2java(String excelPath, Class<T> clazz, int offsetLine, int sheetIndex)
			throws Exception {
		return ExcelUtils.getInstance().readExcel2Objects(excelPath, clazz, offsetLine, sheetIndex);
	}

	/**
	 * 读取Excel操作基于注解映射成绑定的java对象：默认读取指定sheet的全部行，第一行为表头，全部读取。
	 * 
	 * @param excelPath
	 *            待导出Excel的路径
	 * @param clazz
	 *            待绑定的类(绑定属性注解{@link com.github.crab2died.annotation.ExcelField})
	 * @param sheetIndex
	 *            Sheet索引(默认0)
	 * @param <T>
	 *            绑定的数据类
	 * @return 返回转换为设置绑定的java对象集合
	 */
	public static <T> List<T> readExcel2java(String excelPath, Class<T> clazz, int sheetIndex) throws Exception {
		return ExcelUtils.getInstance().readExcel2Objects(excelPath, clazz, sheetIndex);
	}

	/**
	 * 读取Excel操作基于注解映射成绑定的java对象：默认读取第一个sheet的全部行，第一行为表头，全部读取。
	 * 
	 * @param excelPath
	 *            待导出Excel的路径
	 * @param clazz
	 *            待绑定的类(绑定属性注解{@link com.github.crab2died.annotation.ExcelField})
	 * @param <T>
	 *            绑定的数据类
	 * @return 返回转换为设置绑定的java对象集合
	 */
	public static <T> List<T> readExcel2java(String excelPath, Class<T> clazz) throws Exception {
		return ExcelUtils.getInstance().readExcel2Objects(excelPath, clazz);
	}

	public static void main(String[] args) throws Exception {

		String path = System.getProperty("user.dir") + File.separator + "TestData" + File.separator + "excel"
				+ File.separator;
		// 读取admin_setup.xlsx的第一个sheet，第1行（参数：0）为表头，读取两行的数据
		List<AdminOrgModel> list = readExcel2java(path + "Admin_Setup.xlsx", AdminOrgModel.class, 0, 2, 0);
		for (AdminOrgModel testCase : list) {
			System.out.println(testCase.toString());

		}

		// 读取admin_setup.xlsx的第一个sheet，第1行（参数：0）为表头，读取两行的数据
		List<List<String>> result = readExcel2List(path + "Admin_Setup.xlsx", 0, 2, 0);
		for (List<String> list2 : result) {
			// System.out.println(Arrays.asList(list2));
			for (String string : list2) {
				System.out.println(string);
			}
		}
	}
}
