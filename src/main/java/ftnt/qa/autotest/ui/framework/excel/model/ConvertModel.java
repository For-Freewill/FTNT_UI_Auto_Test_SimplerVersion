package ftnt.qa.autotest.ui.framework.excel.model;

import com.github.crab2died.annotation.ExcelField;

import ftnt.qa.autotest.ui.framework.excel.BooleanWriteConvert;
import ftnt.qa.autotest.ui.framework.excel.BooleanWriteConvert2;
import ftnt.qa.autotest.ui.framework.excel.IsRunReadCovert;

public class ConvertModel {
	@ExcelField(title = "开启",readConverter = IsRunReadCovert.class, writeConverter = BooleanWriteConvert2.class)
	private Boolean run;
	
	@ExcelField(title = "用户")
	private String user;
	
	@ExcelField(title = "密码")
	private String pwd;
	
	@ExcelField(title = "机构")
	private String org;
	
	@ExcelField(title = "地址")
	private String address;
	
	@ExcelField(title = "测试成功？",order=1,writeConverter = BooleanWriteConvert.class)
	private Boolean success;

	public Boolean getRun() {
		return run;
	}

	public void setRun(Boolean run) {
		this.run = run;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	@Override
	public String toString() {
		return "ConvertModel [run=" + run + ", user=" + user + ", pwd=" + pwd + ", org=" + org + ", address=" + address
				+ ", success=" + success + "]";
	}

	public ConvertModel(Boolean run, String user, String pwd, String org, String address, Boolean success) {
		super();
		this.run = run;
		this.user = user;
		this.pwd = pwd;
		this.org = org;
		this.address = address;
		this.success = success;
	}

	public ConvertModel() {
		super();
	}
	
}
