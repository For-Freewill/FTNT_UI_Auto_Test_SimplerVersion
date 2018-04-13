package ftnt.qa.autotest.ui.framework.excel.model;

import com.github.crab2died.annotation.ExcelField;

public class AdminOrgModel {
	
	@ExcelField(title = "organization", order = 1)
	private String organization;
	
	@ExcelField(title = "include_ip", order = 2)
	private String include_ip;
	
	@ExcelField(title = "full_name", order = 3)
	private String full_name;
	
	@ExcelField(title = "exclude_ip", order = 4)
	private String exclude_ip;
	
	@ExcelField(title = "admin_user", order = 5)
	private String admin_user;
	
	@ExcelField(title = "admin_pwd", order = 6)
	private String admin_pwd;
	
	@ExcelField(title = "max_devices", order = 7)
	private Integer max_devices;
	
	@ExcelField(title = "admin_email", order = 8)
	private String admin_email;
	
	@ExcelField(title = "phone", order = 9)
	private String phone;
	
	@ExcelField(title = "address", order = 10)
	private String address;
	
	@ExcelField(title = "co_name", order = 11)
	private String co_name;
	
	@ExcelField(title = "co_eps", order = 12)
	private Integer co_eps;
	
	@ExcelField(title = "description", order = 13)
	private String description;

	
	public AdminOrgModel() {
		super();
	}
	
	

	public AdminOrgModel(String organization, String include_ip, String full_name, String exclude_ip, String admin_user,
			String admin_pwd, Integer max_devices, String admin_email, String phone, String address, String co_name,
			Integer co_eps, String description) {
		super();
		this.organization = organization;
		this.include_ip = include_ip;
		this.full_name = full_name;
		this.exclude_ip = exclude_ip;
		this.admin_user = admin_user;
		this.admin_pwd = admin_pwd;
		this.max_devices = max_devices;
		this.admin_email = admin_email;
		this.phone = phone;
		this.address = address;
		this.co_name = co_name;
		this.co_eps = co_eps;
		this.description = description;
	}



	@Override
	public String toString() {
		return "AdminOrgModel [organization=" + organization + ", include_ip=" + include_ip + ", full_name=" + full_name
				+ ", exclude_ip=" + exclude_ip + ", admin_user=" + admin_user + ", admin_pwd=" + admin_pwd
				+ ", max_devices=" + max_devices + ", admin_email=" + admin_email + ", phone=" + phone + ", address="
				+ address + ", co_name=" + co_name + ", co_eps=" + co_eps + ", description=" + description + "]";
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getInclude_ip() {
		return include_ip;
	}

	public void setInclude_ip(String include_ip) {
		this.include_ip = include_ip;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getExclude_ip() {
		return exclude_ip;
	}

	public void setExclude_ip(String exclude_ip) {
		this.exclude_ip = exclude_ip;
	}

	public String getAdmin_user() {
		return admin_user;
	}

	public void setAdmin_user(String admin_user) {
		this.admin_user = admin_user;
	}

	public String getAdmin_pwd() {
		return admin_pwd;
	}

	public void setAdmin_pwd(String admin_pwd) {
		this.admin_pwd = admin_pwd;
	}

	public Integer getMax_devices() {
		return max_devices;
	}

	public void setMax_devices(Integer max_devices) {
		this.max_devices = max_devices;
	}

	public String getAdmin_email() {
		return admin_email;
	}

	public void setAdmin_email(String admin_email) {
		this.admin_email = admin_email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCo_name() {
		return co_name;
	}

	public void setCo_name(String co_name) {
		this.co_name = co_name;
	}

	public Integer getCo_eps() {
		return co_eps;
	}

	public void setCo_eps(Integer co_eps) {
		this.co_eps = co_eps;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



}
