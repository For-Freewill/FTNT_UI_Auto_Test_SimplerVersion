package ftnt.qa.autotest.ui.framework.db.model;

public class DeviceModel {
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
	
	public DeviceModel() {
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((access_ip == null) ? 0 : access_ip.hashCode());
		result = prime * result + ((approved == null) ? 0 : approved.hashCode());
		result = prime * result + ((asset_category == null) ? 0 : asset_category.hashCode());
		result = prime * result + ((asset_weight == null) ? 0 : asset_weight.hashCode());
		result = prime * result + ((collector_id == null) ? 0 : collector_id.hashCode());
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		result = prime * result + ((creation_method == null) ? 0 : creation_method.hashCode());
		result = prime * result + ((creation_time == null) ? 0 : creation_time.hashCode());
		result = prime * result + ((cust_org_id == null) ? 0 : cust_org_id.hashCode());
		result = prime * result + ((device_type_id == null) ? 0 : device_type_id.hashCode());
		result = prime * result + ((discover_agent == null) ? 0 : discover_agent.hashCode());
		result = prime * result + ((discover_enabled == null) ? 0 : discover_enabled.hashCode());
		result = prime * result + ((discover_method == null) ? 0 : discover_method.hashCode());
		result = prime * result + ((discover_time == null) ? 0 : discover_time.hashCode());
		result = prime * result + ((event_pulling_method == null) ? 0 : event_pulling_method.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((last_modified_time == null) ? 0 : last_modified_time.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((natural_id == null) ? 0 : natural_id.hashCode());
		result = prime * result + ((os_edition == null) ? 0 : os_edition.hashCode());
		result = prime * result + ((perf_mon_enabled == null) ? 0 : perf_mon_enabled.hashCode());
		result = prime * result + ((phy_loc == null) ? 0 : phy_loc.hashCode());
		result = prime * result + ((service_tag == null) ? 0 : service_tag.hashCode());
		result = prime * result + ((sys_up_time == null) ? 0 : sys_up_time.hashCode());
		result = prime * result + ((unmanaged == null) ? 0 : unmanaged.hashCode());
		result = prime * result + ((update_method == null) ? 0 : update_method.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		result = prime * result + ((vm_name == null) ? 0 : vm_name.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeviceModel other = (DeviceModel) obj;
		if (access_ip == null) {
			if (other.access_ip != null)
				return false;
		} else if (!access_ip.equals(other.access_ip))
			return false;
		if (approved == null) {
			if (other.approved != null)
				return false;
		} else if (!approved.equals(other.approved))
			return false;
		if (asset_category == null) {
			if (other.asset_category != null)
				return false;
		} else if (!asset_category.equals(other.asset_category))
			return false;
		if (asset_weight == null) {
			if (other.asset_weight != null)
				return false;
		} else if (!asset_weight.equals(other.asset_weight))
			return false;
		if (collector_id == null) {
			if (other.collector_id != null)
				return false;
		} else if (!collector_id.equals(other.collector_id))
			return false;
		if (contact == null) {
			if (other.contact != null)
				return false;
		} else if (!contact.equals(other.contact))
			return false;
		if (creation_method == null) {
			if (other.creation_method != null)
				return false;
		} else if (!creation_method.equals(other.creation_method))
			return false;
		if (creation_time == null) {
			if (other.creation_time != null)
				return false;
		} else if (!creation_time.equals(other.creation_time))
			return false;
		if (cust_org_id == null) {
			if (other.cust_org_id != null)
				return false;
		} else if (!cust_org_id.equals(other.cust_org_id))
			return false;
		if (device_type_id == null) {
			if (other.device_type_id != null)
				return false;
		} else if (!device_type_id.equals(other.device_type_id))
			return false;
		if (discover_agent == null) {
			if (other.discover_agent != null)
				return false;
		} else if (!discover_agent.equals(other.discover_agent))
			return false;
		if (discover_enabled == null) {
			if (other.discover_enabled != null)
				return false;
		} else if (!discover_enabled.equals(other.discover_enabled))
			return false;
		if (discover_method == null) {
			if (other.discover_method != null)
				return false;
		} else if (!discover_method.equals(other.discover_method))
			return false;
		if (discover_time == null) {
			if (other.discover_time != null)
				return false;
		} else if (!discover_time.equals(other.discover_time))
			return false;
		if (event_pulling_method == null) {
			if (other.event_pulling_method != null)
				return false;
		} else if (!event_pulling_method.equals(other.event_pulling_method))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (last_modified_time == null) {
			if (other.last_modified_time != null)
				return false;
		} else if (!last_modified_time.equals(other.last_modified_time))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (natural_id == null) {
			if (other.natural_id != null)
				return false;
		} else if (!natural_id.equals(other.natural_id))
			return false;
		if (os_edition == null) {
			if (other.os_edition != null)
				return false;
		} else if (!os_edition.equals(other.os_edition))
			return false;
		if (perf_mon_enabled == null) {
			if (other.perf_mon_enabled != null)
				return false;
		} else if (!perf_mon_enabled.equals(other.perf_mon_enabled))
			return false;
		if (phy_loc == null) {
			if (other.phy_loc != null)
				return false;
		} else if (!phy_loc.equals(other.phy_loc))
			return false;
		if (service_tag == null) {
			if (other.service_tag != null)
				return false;
		} else if (!service_tag.equals(other.service_tag))
			return false;
		if (sys_up_time == null) {
			if (other.sys_up_time != null)
				return false;
		} else if (!sys_up_time.equals(other.sys_up_time))
			return false;
		if (unmanaged == null) {
			if (other.unmanaged != null)
				return false;
		} else if (!unmanaged.equals(other.unmanaged))
			return false;
		if (update_method == null) {
			if (other.update_method != null)
				return false;
		} else if (!update_method.equals(other.update_method))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		if (vm_name == null) {
			if (other.vm_name != null)
				return false;
		} else if (!vm_name.equals(other.vm_name))
			return false;
		return true;
	}

	
}
