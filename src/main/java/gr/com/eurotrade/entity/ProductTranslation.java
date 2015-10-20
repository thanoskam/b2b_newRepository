package gr.com.eurotrade.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProductTranslation {

	@EmbeddedId
	protected ProductTranslationPK productTranslationPK;

	@Column(length = 1000)
	private String descr;

	@Column(length = 1000)
	private String remark;

	
	

	@ManyToOne
	@JoinColumn(name="productId", insertable = false, updatable = false)
	private Product product;

	@ManyToOne
	@JoinColumn(name="countryId", insertable = false, updatable = false)
	private Country country;

	public ProductTranslationPK getProductTranslationPK() {
		return productTranslationPK;
	}

	public void setProductTranslationPK(ProductTranslationPK productTranslationPK) {
		this.productTranslationPK = productTranslationPK;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Product getproduct() {
		return product;
	}

	public void setproduct(Product product) {
		this.product = product;
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
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((descr == null) ? 0 : descr.hashCode());
		result = prime * result
				+ ((product == null) ? 0 : product.hashCode());
		result = prime
				* result
				+ ((productTranslationPK == null) ? 0 : productTranslationPK
						.hashCode());
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
		ProductTranslation other = (ProductTranslation) obj;
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
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (productTranslationPK == null) {
			if (other.productTranslationPK != null)
				return false;
		} else if (!productTranslationPK.equals(other.productTranslationPK))
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
		return "ProductTranslation [productTranslationPK="
				+ productTranslationPK + ", descr=" + descr + ", remark="
				+ remark + ", product=" + product + ", country=" + country
				+ "]";
	}



	
}
