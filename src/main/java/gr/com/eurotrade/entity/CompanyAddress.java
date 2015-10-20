package gr.com.eurotrade.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class CompanyAddress {

	@EmbeddedId
	protected CompanyAddressPK companyAddressPK;

	@Size(min = 1, message = "Address must be at least 1 characters!")
	@Column(length = 45)
	private String address;

	@Column(length = 1000)
	private String remark;

		

	@ManyToOne(optional = false)
	@JoinColumn(name="companyId", insertable = false, updatable = false)
	private Company company;

	@ManyToOne
	@JoinColumn(name="addressTypeId", nullable=false)
	private AddressType addressType;

	@ManyToOne
	@JoinColumn(name="operationTypeId")
	private OperationType operationType;

   @JoinColumn(name = "cityId", nullable=false)
    @ManyToOne(optional = false)
    private City city;

public CompanyAddressPK getCompanyAddressPK() {
	return companyAddressPK;
}

public void setCompanyAddressPK(CompanyAddressPK companyAddressPK) {
	this.companyAddressPK = companyAddressPK;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getRemark() {
	return remark;
}

public void setRemark(String remark) {
	this.remark = remark;
}

public Company getCompany() {
	return company;
}

public void setCompany(Company company) {
	this.company = company;
}

public AddressType getAddressType() {
	return addressType;
}

public void setAddressType(AddressType addressType) {
	this.addressType = addressType;
}

public OperationType getOperationType() {
	return operationType;
}

public void setOperationType(OperationType operationType) {
	this.operationType = operationType;
}

public City getCity() {
	return city;
}

public void setCity(City city) {
	this.city = city;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((address == null) ? 0 : address.hashCode());
	result = prime * result
			+ ((addressType == null) ? 0 : addressType.hashCode());
	result = prime * result + ((city == null) ? 0 : city.hashCode());
	result = prime * result + ((company == null) ? 0 : company.hashCode());
	result = prime * result
			+ ((companyAddressPK == null) ? 0 : companyAddressPK.hashCode());
	result = prime * result
			+ ((operationType == null) ? 0 : operationType.hashCode());
	result = prime * result + ((remark == null) ? 0 : remark.hashCode());
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
	CompanyAddress other = (CompanyAddress) obj;
	if (address == null) {
		if (other.address != null)
			return false;
	} else if (!address.equals(other.address))
		return false;
	if (addressType == null) {
		if (other.addressType != null)
			return false;
	} else if (!addressType.equals(other.addressType))
		return false;
	if (city == null) {
		if (other.city != null)
			return false;
	} else if (!city.equals(other.city))
		return false;
	if (company == null) {
		if (other.company != null)
			return false;
	} else if (!company.equals(other.company))
		return false;
	if (companyAddressPK == null) {
		if (other.companyAddressPK != null)
			return false;
	} else if (!companyAddressPK.equals(other.companyAddressPK))
		return false;
	if (operationType == null) {
		if (other.operationType != null)
			return false;
	} else if (!operationType.equals(other.operationType))
		return false;
	if (remark == null) {
		if (other.remark != null)
			return false;
	} else if (!remark.equals(other.remark))
		return false;
	return true;
}

@Override
public String toString() {
	return "CompanyAddress [companyAddressPK=" + companyAddressPK
			+ ", address=" + address + ", remark=" + remark + ", company="
			+ company + ", addressType=" + addressType + ", operationType="
			+ operationType + ", city=" + city + "]";
}


   
    
}
