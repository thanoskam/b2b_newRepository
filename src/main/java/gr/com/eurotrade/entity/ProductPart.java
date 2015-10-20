package gr.com.eurotrade.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProductPart {

	@EmbeddedId
	protected ProductPartPK productPartPK;

	
	

	public ProductPartPK getProductPartPK() {
		return productPartPK;
	}

	public void setProductPartPK(ProductPartPK productPartPK) {
		this.productPartPK = productPartPK;
	}

	@ManyToOne
	@JoinColumn(name="productId1", insertable = false, updatable = false)
	private Product product1;

	@ManyToOne
	@JoinColumn(name="productId2", insertable = false, updatable = false)
	private Product product2;

	
	
	
	public Product getProduct1() {
		return product1;
	}

	public void setProduct1(Product product1) {
		this.product1 = product1;
	}

	public Product getProduct2() {
		return product2;
	}

	public void setProduct2(Product product2) {
		this.product2 = product2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((product1 == null) ? 0 : product1.hashCode());
		result = prime * result
				+ ((product2 == null) ? 0 : product2.hashCode());
		result = prime * result
				+ ((productPartPK == null) ? 0 : productPartPK.hashCode());
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
		ProductPart other = (ProductPart) obj;
		if (product1 == null) {
			if (other.product1 != null)
				return false;
		} else if (!product1.equals(other.product1))
			return false;
		if (product2 == null) {
			if (other.product2 != null)
				return false;
		} else if (!product2.equals(other.product2))
			return false;
		if (productPartPK == null) {
			if (other.productPartPK != null)
				return false;
		} else if (!productPartPK.equals(other.productPartPK))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product_Rel [productPartPK=" + productPartPK + ", product1="
				+ product1 + ", product2=" + product2 + "]";
	}


	
	
}
