package gr.com.eurotrade.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SellerHasCustomer {

	@EmbeddedId
	protected SellerHasCustomerPK sellerHasCustomerPK;

	
	@ManyToOne
	@JoinColumn(name="sellerUserId", insertable = false, updatable = false)
	private User sellerUser;

	@ManyToOne
	@JoinColumn(name="customerUserId", insertable = false, updatable = false)
	private User customerUser;

	public SellerHasCustomerPK getSellerHasCustomerPK() {
		return sellerHasCustomerPK;
	}

	public void setSellerHasCustomerPK(SellerHasCustomerPK sellerHasCustomerPK) {
		this.sellerHasCustomerPK = sellerHasCustomerPK;
	}

	public User getSellerUser() {
		return sellerUser;
	}

	public void setSellerUser(User sellerUser) {
		this.sellerUser = sellerUser;
	}

	public User getCustomerUser() {
		return customerUser;
	}

	public void setCustomerUser(User customerUser) {
		this.customerUser = customerUser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((customerUser == null) ? 0 : customerUser.hashCode());
		result = prime
				* result
				+ ((sellerHasCustomerPK == null) ? 0 : sellerHasCustomerPK
						.hashCode());
		result = prime * result
				+ ((sellerUser == null) ? 0 : sellerUser.hashCode());
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
		SellerHasCustomer other = (SellerHasCustomer) obj;
		if (customerUser == null) {
			if (other.customerUser != null)
				return false;
		} else if (!customerUser.equals(other.customerUser))
			return false;
		if (sellerHasCustomerPK == null) {
			if (other.sellerHasCustomerPK != null)
				return false;
		} else if (!sellerHasCustomerPK.equals(other.sellerHasCustomerPK))
			return false;
		if (sellerUser == null) {
			if (other.sellerUser != null)
				return false;
		} else if (!sellerUser.equals(other.sellerUser))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SellerHasCustomer [sellerHasCustomerPK=" + sellerHasCustomerPK
				+ ", sellerUser=" + sellerUser + ", customerUser="
				+ customerUser + "]";
	}

	
	
	
	
}
