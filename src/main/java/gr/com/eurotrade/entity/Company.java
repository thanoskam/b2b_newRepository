package gr.com.eurotrade.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class Company {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min = 1, message = "Name must be at least 1 characters!")
	@Column(length = 45)
	private String name;


	
	@ManyToOne
	@JoinColumn(name="countryId", nullable=false)
	private Country country;
	
	@OneToMany(mappedBy="company")
	private List<User> userList;

    @OneToMany(mappedBy = "company")
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

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
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
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((userList == null) ? 0 : userList.hashCode());
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
		Company other = (Company) obj;
		if (companyAddressList == null) {
			if (other.companyAddressList != null)
				return false;
		} else if (!companyAddressList.equals(other.companyAddressList))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
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
		if (userList == null) {
			if (other.userList != null)
				return false;
		} else if (!userList.equals(other.userList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", country=" + country
				+ ", userList=" + userList + ", companyAddressList="
				+ companyAddressList + "]";
	}

	
    
}
