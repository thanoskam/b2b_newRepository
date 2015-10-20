package gr.com.eurotrade.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class AddressType {

	@Id
//	@GeneratedValue
	private Integer id;
	
	private String name;

	
	@OneToMany(mappedBy = "addressType")
	private List<CompanyAddress> companyAddressList;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<CompanyAddress> getCompanyAddressList() {
		return companyAddressList;
	}


	public void setCompanyAddressList(List<CompanyAddress> companyAddressList) {
		this.companyAddressList = companyAddressList;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((companyAddressList == null) ? 0 : companyAddressList
						.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		AddressType other = (AddressType) obj;
		if (companyAddressList == null) {
			if (other.companyAddressList != null)
				return false;
		} else if (!companyAddressList.equals(other.companyAddressList))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "AddressType [id=" + id + ", name=" + name
				+ ", companyAddressList=" + companyAddressList + "]";
	}

	
	
}
