package ftnt.qa.autotest.ui.framework.excel.model;

import com.github.crab2died.annotation.ExcelField;

public class TestModel {
	@ExcelField(title = "name", order = 3)
	private String name;
	
	@ExcelField(title = "age", order = 2)
	private String age;
	
	@ExcelField(title = "sex", order = 1)
	private String sex;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "TestModel [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
	public TestModel(String name, String age, String sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	public TestModel() {
		super();
	}
	
	
	
}
