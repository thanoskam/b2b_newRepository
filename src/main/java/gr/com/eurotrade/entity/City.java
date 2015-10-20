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
public class City {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min = 1, message = "Name must be at least 1 characters!")
	@Column(length = 45)
	private String name;

	

	@OneToMany(mappedBy = "city")
	private List<CompanyAddress> companyAddressList;

	@ManyToOne
	@JoinColumn(name="stateId", nullable=false)
	private State state;


	
	public boolean isNew() {
		return (this.id == null);
	}

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

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
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
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		City other = (City) obj;
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
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", companyAddressList="
				+ companyAddressList + ", state=" + state + "]";
	}


	
	
	
}
