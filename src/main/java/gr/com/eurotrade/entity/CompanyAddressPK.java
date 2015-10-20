package gr.com.eurotrade.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CompanyAddressPK implements Serializable {
											
	private static final long serialVersionUID = 1L;
	
	private Integer aaPerCompany;
	
	private Integer companyId;

	public Integer getAaPerCompany() {
		return aaPerCompany;
	}

	public void setAaPerCompany(Integer aaPerCompany) {
		this.aaPerCompany = aaPerCompany;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((aaPerCompany == null) ? 0 : aaPerCompany.hashCode());
		result = prime * result
				+ ((companyId == null) ? 0 : companyId.hashCode());
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
		CompanyAddressPK other = (CompanyAddressPK) obj;
		if (aaPerCompany == null) {
			if (other.aaPerCompany != null)
				return false;
		} else if (!aaPerCompany.equals(other.aaPerCompany))
			return false;
		if (companyId == null) {
			if (other.companyId != null)
				return false;
		} else if (!companyId.equals(other.companyId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CompanyAddressPK [aaPerCompany=" + aaPerCompany
				+ ", companyId=" + companyId + "]";
	}



}
