package utils.test.example;

public class ProjectPathTest {
	public static void main(String[] args) {
		String projPath = System.getProperty("user.dir");
		System.out.println("当前工程的绝对路径："+projPath);
		System.out.println("全部系统属性："+System.getProperties());
		System.out.println("系统行分隔符："+System.getProperty("line.separator"));
		System.out.println("系统文件路径分隔符："+java.io.File.separator);
	}
}
