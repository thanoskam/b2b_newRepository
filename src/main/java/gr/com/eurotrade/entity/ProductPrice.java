package gr.com.eurotrade.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProductPrice {

	@EmbeddedId
	protected ProductPricePK productPricePK;

	private double wlsCost;

	private double sprCost;


	@ManyToOne
	@JoinColumn(name="productId", insertable = false, updatable = false)
	private Product product;

	@ManyToOne
	@JoinColumn(name="countryId", insertable = false, updatable = false)
	private Country country;

	public ProductPricePK getProductPricePK() {
		return productPricePK;
	}

	public void setProductPricePK(ProductPricePK productPricePK) {
		this.productPricePK = productPricePK;
	}

	public double getWlsCost() {
		return wlsCost;
	}

	public void setWlsCost(double wlsCost) {
		this.wlsCost = wlsCost;
	}

	public double getSprCost() {
		return sprCost;
	}

	public void setSprCost(double sprCost) {
		this.sprCost = sprCost;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
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
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result
				+ ((productPricePK == null) ? 0 : productPricePK.hashCode());
		long temp;
		temp = Double.doubleToLongBits(sprCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(wlsCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		ProductPrice other = (ProductPrice) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (productPricePK == null) {
			if (other.productPricePK != null)
				return false;
		} else if (!productPricePK.equals(other.productPricePK))
			return false;
		if (Double.doubleToLongBits(sprCost) != Double
				.doubleToLongBits(other.sprCost))
			return false;
		if (Double.doubleToLongBits(wlsCost) != Double
				.doubleToLongBits(other.wlsCost))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductPrice [productPricePK=" + productPricePK + ", wlsCost="
				+ wlsCost + ", sprCost=" + sprCost + ", product=" + product
				+ ", country=" + country + "]";
	}


	
}
