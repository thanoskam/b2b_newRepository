package gr.com.eurotrade.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Branch {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	private String abr;

	
	
	@OneToMany(mappedBy="branch")
	private List<Country> countryList;
	
	@OneToMany(mappedBy="branchDelay1")
	private List<Delay> delayList1;
	
	@OneToMany(mappedBy="branchDelay2")
	private List<Delay> delayList2;

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

	public String getAbr() {
		return abr;
	}

	public void setAbr(String abr) {
		this.abr = abr;
	}

	public List<Country> getCountryList() {
		return countryList;
	}

	public void setCountryList(List<Country> countryList) {
		this.countryList = countryList;
	}

	public List<Delay> getDelayList1() {
		return delayList1;
	}

	public void setDelayList1(List<Delay> delayList1) {
		this.delayList1 = delayList1;
	}

	public List<Delay> getDelayList2() {
		return delayList2;
	}

	public void setDelayList2(List<Delay> delayList2) {
		this.delayList2 = delayList2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abr == null) ? 0 : abr.hashCode());
		result = prime * result
				+ ((countryList == null) ? 0 : countryList.hashCode());
		result = prime * result
				+ ((delayList1 == null) ? 0 : delayList1.hashCode());
		result = prime * result
				+ ((delayList2 == null) ? 0 : delayList2.hashCode());
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
		Branch other = (Branch) obj;
		if (abr == null) {
			if (other.abr != null)
				return false;
		} else if (!abr.equals(other.abr))
			return false;
		if (countryList == null) {
			if (other.countryList != null)
				return false;
		} else if (!countryList.equals(other.countryList))
			return false;
		if (delayList1 == null) {
			if (other.delayList1 != null)
				return false;
		} else if (!delayList1.equals(other.delayList1))
			return false;
		if (delayList2 == null) {
			if (other.delayList2 != null)
				return false;
		} else if (!delayList2.equals(other.delayList2))
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
		return "Branch [id=" + id + ", name=" + name + ", abr=" + abr
				+ ", countryList=" + countryList + ", delayList1=" + delayList1
				+ ", delayList2=" + delayList2 + "]";
	}
	
	
	
	
	
	
}
