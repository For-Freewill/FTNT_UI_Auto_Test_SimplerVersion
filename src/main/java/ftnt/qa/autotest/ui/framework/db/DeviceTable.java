package ftnt.qa.autotest.ui.framework.db;

public class DeviceTable {
	private String id;
	private String creation_time;
	private String cust_org_id;
	private String last_modified_time;
	private String access_ip;
	private String asset_category;
	private String asset_weight;
	private String contact;
	private String creation_method;
	private String discover_agent;
	private String discover_enabled;
	private String discover_method;
	private String discover_time;
	private String phy_loc;
	private String name;
	private String natural_id;
	private String sys_up_time;
	private String update_method;
	private String version;
	private String vm_name;
	private String device_type_id;
	private String perf_mon_enabled;
	private String event_pulling_method;
	private String approved;
	private String collector_id;
	private String service_tag;
	private String os_edition;
	private Boolean unmanaged;
	
	public DeviceTable() {
		super();
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getAccess_ip() {
		return access_ip;
	}
	public void setAccess_ip(String access_ip) {
		this.access_ip = access_ip;
	}
	public String getAsset_category() {
		return asset_category;
	}
	public void setAsset_category(String asset_category) {
		this.asset_category = asset_category;
	}
	public String getAsset_weight() {
		return asset_weight;
	}
	public void setAsset_weight(String asset_weight) {
		this.asset_weight = asset_weight;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getCreation_method() {
		return creation_method;
	}
	public void setCreation_method(String creation_method) {
		this.creation_method = creation_method;
	}
	public String getDiscover_agent() {
		return discover_agent;
	}
	public void setDiscover_agent(String discover_agent) {
		this.discover_agent = discover_agent;
	}
	public String getDiscover_enabled() {
		return discover_enabled;
	}
	public void setDiscover_enabled(String discover_enabled) {
		this.discover_enabled = discover_enabled;
	}
	public String getDiscover_method() {
		return discover_method;
	}
	public void setDiscover_method(String discover_method) {
		this.discover_method = discover_method;
	}
	public String getDiscover_time() {
		return discover_time;
	}
	public void setDiscover_time(String discover_time) {
		this.discover_time = discover_time;
	}
	public String getPhy_loc() {
		return phy_loc;
	}
	public void setPhy_loc(String phy_loc) {
		this.phy_loc = phy_loc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNatural_id() {
		return natural_id;
	}
	public void setNatural_id(String natural_id) {
		this.natural_id = natural_id;
	}
	public String getSys_up_time() {
		return sys_up_time;
	}
	public void setSys_up_time(String sys_up_time) {
		this.sys_up_time = sys_up_time;
	}
	public String getUpdate_method() {
		return update_method;
	}
	public void setUpdate_method(String update_method) {
		this.update_method = update_method;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getVm_name() {
		return vm_name;
	}
	public void setVm_name(String vm_name) {
		this.vm_name = vm_name;
	}
	public String getDevice_type_id() {
		return device_type_id;
	}
	public void setDevice_type_id(String device_type_id) {
		this.device_type_id = device_type_id;
	}
	public String getPerf_mon_enabled() {
		return perf_mon_enabled;
	}
	public void setPerf_mon_enabled(String perf_mon_enabled) {
		this.perf_mon_enabled = perf_mon_enabled;
	}
	public String getEvent_pulling_method() {
		return event_pulling_method;
	}
	public void setEvent_pulling_method(String event_pulling_method) {
		this.event_pulling_method = event_pulling_method;
	}
	public String getApproved() {
		return approved;
	}
	public void setApproved(String approved) {
		this.approved = approved;
	}
	public String getCollector_id() {
		return collector_id;
	}
	public void setCollector_id(String collector_id) {
		this.collector_id = collector_id;
	}
	public String getService_tag() {
		return service_tag;
	}
	public void setService_tag(String service_tag) {
		this.service_tag = service_tag;
	}
	public String getOs_edition() {
		return os_edition;
	}
	public void setOs_edition(String os_edition) {
		this.os_edition = os_edition;
	}

	
	public Boolean getUnmanaged() {
		return unmanaged;
	}


	public void setUnmanaged(Boolean unmanaged) {
		this.unmanaged = unmanaged;
	}


	@Override
	public String toString() {
		return "Ph_Device [id=" + id + ", cust_org_id=" + cust_org_id + ", access_ip=" + access_ip
				+ ", creation_method=" + creation_method + ", discover_method=" + discover_method + ", name=" + name
				+ ", update_method=" + update_method + ", device_type_id=" + device_type_id + ", perf_mon_enabled="
				+ perf_mon_enabled + ", event_pulling_method=" + event_pulling_method + ", approved=" + approved
				+ ", collector_id=" + collector_id + ", service_tag=" + service_tag + ", unmanaged=" + unmanaged + "]";
	}

	
}
