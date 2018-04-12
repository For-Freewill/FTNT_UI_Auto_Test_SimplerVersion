package ftnt.qa.autotest.ui.framework.db.model;

public class WinAgentModel {
	private String id;
	private String collector_id;
	private String creation_time;
	private String cust_org_id;
	private String last_modified_time;
	private String owner_id;
	private String uuid;
	private String advanced_count;
	private String basic_count;
	private String win_agent_pwd;
	private String license_end_time;
	private String license_start_time;
	private String name;
	private String register_time;
	private Boolean registered;
	private Boolean status;
	private String target_ip;
	private String target_name;
	private String win_agent_id;
	private String collector_ids;
	
	public WinAgentModel(String name, Boolean registered, Boolean status) {
		super();
		this.name = name;
		this.registered = registered;
		this.status = status;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCollector_id() {
		return collector_id;
	}
	public void setCollector_id(String collector_id) {
		this.collector_id = collector_id;
	}
	public String getCreation_time() {
		return creation_time;
	}
	public void setCreation_time(String creation_time) {
		this.creation_time = creation_time;
	}
	public String getCust_org_id() {
		return cust_org_id;
	}
	public void setCust_org_id(String cust_org_id) {
		this.cust_org_id = cust_org_id;
	}
	public String getLast_modified_time() {
		return last_modified_time;
	}
	public void setLast_modified_time(String last_modified_time) {
		this.last_modified_time = last_modified_time;
	}
	public String getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(String owner_id) {
		this.owner_id = owner_id;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getAdvanced_count() {
		return advanced_count;
	}
	public void setAdvanced_count(String advanced_count) {
		this.advanced_count = advanced_count;
	}
	public String getBasic_count() {
		return basic_count;
	}
	public void setBasic_count(String basic_count) {
		this.basic_count = basic_count;
	}
	public String getWin_agent_pwd() {
		return win_agent_pwd;
	}
	public void setWin_agent_pwd(String win_agent_pwd) {
		this.win_agent_pwd = win_agent_pwd;
	}
	public String getLicense_end_time() {
		return license_end_time;
	}
	public void setLicense_end_time(String license_end_time) {
		this.license_end_time = license_end_time;
	}
	public String getLicense_start_time() {
		return license_start_time;
	}
	public void setLicense_start_time(String license_start_time) {
		this.license_start_time = license_start_time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegister_time() {
		return register_time;
	}
	public void setRegister_time(String register_time) {
		this.register_time = register_time;
	}
	public Boolean getRegistered() {
		return registered;
	}
	public void setRegistered(Boolean registered) {
		this.registered = registered;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getTarget_ip() {
		return target_ip;
	}
	public void setTarget_ip(String target_ip) {
		this.target_ip = target_ip;
	}
	public String getTarget_name() {
		return target_name;
	}
	public void setTarget_name(String target_name) {
		this.target_name = target_name;
	}
	public String getWin_agent_id() {
		return win_agent_id;
	}
	public void setWin_agent_id(String win_agent_id) {
		this.win_agent_id = win_agent_id;
	}
	public String getCollector_ids() {
		return collector_ids;
	}
	public void setCollector_ids(String collector_ids) {
		this.collector_ids = collector_ids;
	}
}
