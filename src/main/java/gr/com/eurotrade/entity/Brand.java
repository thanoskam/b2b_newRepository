package gr.com.eurotrade.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Brand {

	@Id
	@GeneratedValue
	private Integer id;
	
	private Integer erpBrandId;
	
	@Column(length = 45)
	private String name;
	
	private Boolean published;

	
	

	@OneToMany(mappedBy="brand")
	private List<Product> productList;

	@OneToMany(mappedBy="brand")
	private List<UserBrand> userBrandList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getErpBrandId() {
		return erpBrandId;
	}

	public void setErpBrandId(Integer erpBrandId) {
		this.erpBrandId = erpBrandId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getPublished() {
		return published;
	}

	public void setPublished(Boolean published) {
		this.published = published;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public List<UserBrand> getUserBrandList() {
		return userBrandList;
	}

	public void setUserBrandList(List<UserBrand> userBrandList) {
		this.userBrandList = userBrandList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((erpBrandId == null) ? 0 : erpBrandId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((productList == null) ? 0 : productList.hashCode());
		result = prime * result
				+ ((published == null) ? 0 : published.hashCode());
		result = prime * result
				+ ((userBrandList == null) ? 0 : userBrandList.hashCode());
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
		Brand other = (Brand) obj;
		if (erpBrandId == null) {
			if (other.erpBrandId != null)
				return false;
		} else if (!erpBrandId.equals(other.erpBrandId))
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
		if (productList == null) {
			if (other.productList != null)
				return false;
		} else if (!productList.equals(other.productList))
			return false;
		if (published == null) {
			if (other.published != null)
				return false;
		} else if (!published.equals(other.published))
			return false;
		if (userBrandList == null) {
			if (other.userBrandList != null)
				return false;
		} else if (!userBrandList.equals(other.userBrandList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Brand [id=" + id + ", erpBrandId=" + erpBrandId + ", name="
				+ name + ", published=" + published + ", productList="
				+ productList + ", userBrandList=" + userBrandList + "]";
	}
	

	
	
	
}
