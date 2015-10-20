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
public class Country {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min = 1, message = "Code must be at least 1 characters!")
	@Column(length = 10)
	private String code;
	
	@Size(min = 1, message = "Name must be at least 1 characters!")
	@Column(length = 45)
	private String name;
	
		
		
	@OneToMany(mappedBy="country")
	private List<Company> companyList;
	
    @ManyToOne
	@JoinColumn(name="curId", nullable=false)
	private Currency currency;

	@ManyToOne
	@JoinColumn(name="branch_id", nullable=false)
	private Branch branch;
	
	@OneToMany(mappedBy="country")
	private List<CategoryInfo> categoryInfoList;

	@OneToMany(mappedBy="country")
	private List<ProductTranslation> productTranslationList;

	@OneToMany(mappedBy = "countryId")
	private List<DiscountLine> discountLineList;
	
	@OneToMany(mappedBy="country")
	private List<Region> regionList;

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Company> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<Company> companyList) {
		this.companyList = companyList;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public List<CategoryInfo> getCategoryInfoList() {
		return categoryInfoList;
	}

	public void setCategoryInfoList(List<CategoryInfo> categoryInfoList) {
		this.categoryInfoList = categoryInfoList;
	}

	public List<ProductTranslation> getProductTranslationList() {
		return productTranslationList;
	}

	public void setProductTranslationList(
			List<ProductTranslation> productTranslationList) {
		this.productTranslationList = productTranslationList;
	}

	public List<DiscountLine> getDiscountLineList() {
		return discountLineList;
	}

	public void setDiscountLineList(List<DiscountLine> discountLineList) {
		this.discountLineList = discountLineList;
	}

	public List<Region> getRegionList() {
		return regionList;
	}

	public void setRegionList(List<Region> regionList) {
		this.regionList = regionList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((branch == null) ? 0 : branch.hashCode());
		result = prime
				* result
				+ ((categoryInfoList == null) ? 0 : categoryInfoList.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result
				+ ((companyList == null) ? 0 : companyList.hashCode());
		result = prime * result
				+ ((currency == null) ? 0 : currency.hashCode());
		result = prime
				* result
				+ ((discountLineList == null) ? 0 : discountLineList.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime
				* result
				+ ((productTranslationList == null) ? 0
						: productTranslationList.hashCode());
		result = prime * result
				+ ((regionList == null) ? 0 : regionList.hashCode());
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
		Country other = (Country) obj;
		if (branch == null) {
			if (other.branch != null)
				return false;
		} else if (!branch.equals(other.branch))
			return false;
		if (categoryInfoList == null) {
			if (other.categoryInfoList != null)
				return false;
		} else if (!categoryInfoList.equals(other.categoryInfoList))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (companyList == null) {
			if (other.companyList != null)
				return false;
		} else if (!companyList.equals(other.companyList))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (discountLineList == null) {
			if (other.discountLineList != null)
				return false;
		} else if (!discountLineList.equals(other.discountLineList))
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
		if (productTranslationList == null) {
			if (other.productTranslationList != null)
				return false;
		} else if (!productTranslationList.equals(other.productTranslationList))
			return false;
		if (regionList == null) {
			if (other.regionList != null)
				return false;
		} else if (!regionList.equals(other.regionList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", code=" + code
				+ ", companyList=" + companyList + ", currency=" + currency
				+ ", branch=" + branch + ", categoryInfoList="
				+ categoryInfoList + ", productTranslationList="
				+ productTranslationList + ", discountLineList="
				+ discountLineList + ", regionList=" + regionList + "]";
	}
	


	

}
