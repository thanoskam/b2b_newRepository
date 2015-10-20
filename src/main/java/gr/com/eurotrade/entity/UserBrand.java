package gr.com.eurotrade.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UserBrand {

	@EmbeddedId
	protected UserBrandPK userBrandPK;
	
	private Integer discountPc;

	
	
	@ManyToOne
	@JoinColumn(name="userId", insertable = false, updatable = false)
	private User user;

	@ManyToOne
	@JoinColumn(name="brandId", insertable = false, updatable = false)
	private Brand brand;

	public UserBrandPK getUserBrandPK() {
		return userBrandPK;
	}

	public void setUserBrandPK(UserBrandPK userBrandPK) {
		this.userBrandPK = userBrandPK;
	}

	public Integer getDiscountPc() {
		return discountPc;
	}

	public void setDiscountPc(Integer discountPc) {
		this.discountPc = discountPc;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result
				+ ((discountPc == null) ? 0 : discountPc.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result
				+ ((userBrandPK == null) ? 0 : userBrandPK.hashCode());
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
		UserBrand other = (UserBrand) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (discountPc == null) {
			if (other.discountPc != null)
				return false;
		} else if (!discountPc.equals(other.discountPc))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (userBrandPK == null) {
			if (other.userBrandPK != null)
				return false;
		} else if (!userBrandPK.equals(other.userBrandPK))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserBrand [userBrandPK=" + userBrandPK + ", discountPc="
				+ discountPc + ", user=" + user + ", brand=" + brand + "]";
	}

	
	
	
	

}
