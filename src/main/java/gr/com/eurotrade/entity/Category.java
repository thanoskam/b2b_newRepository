package gr.com.eurotrade.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue
	private Integer id;
	
	private Integer erpCatId;
	
	private Boolean published;

	private boolean isDeleted;
	
	
	@OneToMany(mappedBy="category")
	private List<Product> productList;

	@ManyToMany(mappedBy="catList")
	private List<User> userList;
	
	@OneToMany(mappedBy="category")
	private List<CategoryInfo> categoryInfoList;

	@OneToMany(mappedBy="category")
	private List<CategoryTranslation> categoryTranslationList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getErpCatId() {
		return erpCatId;
	}

	public void setErpCatId(Integer erpCatId) {
		this.erpCatId = erpCatId;
	}

	public Boolean getPublished() {
		return published;
	}

	public void setPublished(Boolean published) {
		this.published = published;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public List<CategoryInfo> getCategoryInfoList() {
		return categoryInfoList;
	}

	public void setCategoryInfoList(List<CategoryInfo> categoryInfoList) {
		this.categoryInfoList = categoryInfoList;
	}

	public List<CategoryTranslation> getCategoryTranslationList() {
		return categoryTranslationList;
	}

	public void setCategoryTranslationList(
			List<CategoryTranslation> categoryTranslationList) {
		this.categoryTranslationList = categoryTranslationList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((categoryInfoList == null) ? 0 : categoryInfoList.hashCode());
		result = prime
				* result
				+ ((categoryTranslationList == null) ? 0
						: categoryTranslationList.hashCode());
		result = prime * result
				+ ((erpCatId == null) ? 0 : erpCatId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isDeleted ? 1231 : 1237);
		result = prime * result
				+ ((productList == null) ? 0 : productList.hashCode());
		result = prime * result
				+ ((published == null) ? 0 : published.hashCode());
		result = prime * result
				+ ((userList == null) ? 0 : userList.hashCode());
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
		Category other = (Category) obj;
		if (categoryInfoList == null) {
			if (other.categoryInfoList != null)
				return false;
		} else if (!categoryInfoList.equals(other.categoryInfoList))
			return false;
		if (categoryTranslationList == null) {
			if (other.categoryTranslationList != null)
				return false;
		} else if (!categoryTranslationList
				.equals(other.categoryTranslationList))
			return false;
		if (erpCatId == null) {
			if (other.erpCatId != null)
				return false;
		} else if (!erpCatId.equals(other.erpCatId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isDeleted != other.isDeleted)
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
		if (userList == null) {
			if (other.userList != null)
				return false;
		} else if (!userList.equals(other.userList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", erpCatId=" + erpCatId + ", published="
				+ published + ", isDeleted=" + isDeleted + ", productList="
				+ productList + ", userList=" + userList
				+ ", categoryInfoList=" + categoryInfoList
				+ ", categoryTranslationList=" + categoryTranslationList + "]";
	}
	
	
}
