package gr.com.eurotrade.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CategoryInfo {

	@EmbeddedId
	protected CategoryInfoPK categoryInfoPK;
	
	@Column(length = 45)
	private String descr;

	
	
	@ManyToOne
	@JoinColumn(name="categoryId", insertable = false, updatable = false)
	private Category category;

	@ManyToOne
	@JoinColumn(name="countryId", insertable = false, updatable = false)
	private Country country;

	
	
	
	public CategoryInfoPK getCategoryInfoPK() {
		return categoryInfoPK;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	
	
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public void setCategoryInfoPK(CategoryInfoPK categoryInfoPK) {
		this.categoryInfoPK = categoryInfoPK;
	}

	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result
				+ ((categoryInfoPK == null) ? 0 : categoryInfoPK.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((descr == null) ? 0 : descr.hashCode());
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
		CategoryInfo other = (CategoryInfo) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (categoryInfoPK == null) {
			if (other.categoryInfoPK != null)
				return false;
		} else if (!categoryInfoPK.equals(other.categoryInfoPK))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (descr == null) {
			if (other.descr != null)
				return false;
		} else if (!descr.equals(other.descr))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CategoryInfo [categoryInfoPK=" + categoryInfoPK + ", descr="
				+ descr + ", category=" + category + ", country=" + country
				+ "]";
	}


	
	
	
	
}
