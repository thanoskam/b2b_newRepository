package gr.com.eurotrade.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CategoryTranslation {

	@EmbeddedId
	protected CategoryTranslationPK categoryTranslationPK;

	@Column(length = 1000)
	private String name;


	
	@ManyToOne
	@JoinColumn(name="categoryId", insertable = false, updatable = false)
	private Category category;

	@ManyToOne
	@JoinColumn(name="countryId", insertable = false, updatable = false)
	private Country country;

	public CategoryTranslationPK getCategoryTranslationPK() {
		return categoryTranslationPK;
	}

	public void setCategoryTranslationPK(CategoryTranslationPK categoryTranslationPK) {
		this.categoryTranslationPK = categoryTranslationPK;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime
				* result
				+ ((categoryTranslationPK == null) ? 0 : categoryTranslationPK
						.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
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
		CategoryTranslation other = (CategoryTranslation) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (categoryTranslationPK == null) {
			if (other.categoryTranslationPK != null)
				return false;
		} else if (!categoryTranslationPK.equals(other.categoryTranslationPK))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
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
		return "CategoryTranslation [categoryTranslationPK="
				+ categoryTranslationPK + ", name=" + name + ", category="
				+ category + ", country=" + country + "]";
	}

	
	

	
}
