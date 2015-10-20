package gr.com.eurotrade.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class SellerHasCustomerPK implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer sellerUserId;
	
	private Integer customerUserId;

	public Integer getSellerUserId() {
		return sellerUserId;
	}

	public void setSellerUserId(Integer sellerUserId) {
		this.sellerUserId = sellerUserId;
	}

	public Integer getCustomerUserId() {
		return customerUserId;
	}

	public void setCustomerUserId(Integer customerUserId) {
		this.customerUserId = customerUserId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((customerUserId == null) ? 0 : customerUserId.hashCode());
		result = prime * result
				+ ((sellerUserId == null) ? 0 : sellerUserId.hashCode());
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
		SellerHasCustomerPK other = (SellerHasCustomerPK) obj;
		if (customerUserId == null) {
			if (other.customerUserId != null)
				return false;
		} else if (!customerUserId.equals(other.customerUserId))
			return false;
		if (sellerUserId == null) {
			if (other.sellerUserId != null)
				return false;
		} else if (!sellerUserId.equals(other.sellerUserId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SellerHasCustomerPK [sellerUserId=" + sellerUserId
				+ ", customerUserId=" + customerUserId + "]";
	}


	
}
