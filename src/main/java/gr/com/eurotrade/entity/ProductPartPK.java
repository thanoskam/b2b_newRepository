package gr.com.eurotrade.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ProductPartPK implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer productId1;
	
	private Integer productId2;

	public Integer getProductId1() {
		return productId1;
	}

	public void setProductId1(Integer productId1) {
		this.productId1 = productId1;
	}

	public Integer getProductId2() {
		return productId2;
	}

	public void setProductId2(Integer productId2) {
		this.productId2 = productId2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((productId1 == null) ? 0 : productId1.hashCode());
		result = prime * result
				+ ((productId2 == null) ? 0 : productId2.hashCode());
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
		ProductPartPK other = (ProductPartPK) obj;
		if (productId1 == null) {
			if (other.productId1 != null)
				return false;
		} else if (!productId1.equals(other.productId1))
			return false;
		if (productId2 == null) {
			if (other.productId2 != null)
				return false;
		} else if (!productId2.equals(other.productId2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductPartPK [productId1=" + productId1 + ", productId2="
				+ productId2 + "]";
	}

	
	
	
	
}
