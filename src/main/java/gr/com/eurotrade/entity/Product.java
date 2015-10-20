package gr.com.eurotrade.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(length = 45)
	private String code;
	
	@Column(length = 45)
	private String dfv1;

	@Column(length = 45)
	private String dfv2;

	@Column(length = 45)
	private String barcode;

	private Integer modelYear;
	
	private String specFilename;

	private boolean isDeleted;
	
	private boolean published;

	
	@ManyToOne
	@JoinColumn(name="brandId")
	private Brand brand;

	@ManyToOne
	@JoinColumn(name="catId")
	private Category category;

	@ManyToOne
	@JoinColumn(name="discountLineId")
	private DiscountLine discountLine;

	@OneToMany(mappedBy="product1")
	private List<ProductPart> productPartList1;

	@OneToMany(mappedBy="product2")
	private List<ProductPart> productPartList2;

	@OneToMany(mappedBy="product")
	private List<ProductTranslation> productTranslationList;
	
	@OneToMany(mappedBy="product")
	private List<ProductPrice> productPriceList;

	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDfv1() {
		return dfv1;
	}

	public void setDfv1(String dfv1) {
		this.dfv1 = dfv1;
	}

	public String getDfv2() {
		return dfv2;
	}

	public void setDfv2(String dfv2) {
		this.dfv2 = dfv2;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public Integer getModelYear() {
		return modelYear;
	}

	public void setModelYear(Integer modelYear) {
		this.modelYear = modelYear;
	}

	public String getSpecFilename() {
		return specFilename;
	}

	public void setSpecFilename(String specFilename) {
		this.specFilename = specFilename;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public DiscountLine getDiscountLine() {
		return discountLine;
	}

	public void setDiscountLine(DiscountLine discountLine) {
		this.discountLine = discountLine;
	}

	public List<ProductPart> getProductPartList1() {
		return productPartList1;
	}

	public void setProductPartList1(List<ProductPart> productPartList1) {
		this.productPartList1 = productPartList1;
	}

	public List<ProductPart> getProductPartList2() {
		return productPartList2;
	}

	public void setProductPartList2(List<ProductPart> productPartList2) {
		this.productPartList2 = productPartList2;
	}

	public List<ProductTranslation> getProductTranslationList() {
		return productTranslationList;
	}

	public void setProductTranslationList(
			List<ProductTranslation> productTranslationList) {
		this.productTranslationList = productTranslationList;
	}

	public List<ProductPrice> getProductPriceList() {
		return productPriceList;
	}

	public void setProductPriceList(List<ProductPrice> productPriceList) {
		this.productPriceList = productPriceList;
	}

	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((barcode == null) ? 0 : barcode.hashCode());
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((dfv1 == null) ? 0 : dfv1.hashCode());
		result = prime * result + ((dfv2 == null) ? 0 : dfv2.hashCode());
		result = prime * result
				+ ((discountLine == null) ? 0 : discountLine.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isDeleted ? 1231 : 1237);
		result = prime * result
				+ ((modelYear == null) ? 0 : modelYear.hashCode());
		result = prime
				* result
				+ ((productPartList1 == null) ? 0 : productPartList1.hashCode());
		result = prime
				* result
				+ ((productPartList2 == null) ? 0 : productPartList2.hashCode());
		result = prime
				* result
				+ ((productPriceList == null) ? 0 : productPriceList.hashCode());
		result = prime
				* result
				+ ((productTranslationList == null) ? 0
						: productTranslationList.hashCode());
		result = prime * result + (published ? 1231 : 1237);
		result = prime * result
				+ ((specFilename == null) ? 0 : specFilename.hashCode());
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
		Product other = (Product) obj;
		if (barcode == null) {
			if (other.barcode != null)
				return false;
		} else if (!barcode.equals(other.barcode))
			return false;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (dfv1 == null) {
			if (other.dfv1 != null)
				return false;
		} else if (!dfv1.equals(other.dfv1))
			return false;
		if (dfv2 == null) {
			if (other.dfv2 != null)
				return false;
		} else if (!dfv2.equals(other.dfv2))
			return false;
		if (discountLine == null) {
			if (other.discountLine != null)
				return false;
		} else if (!discountLine.equals(other.discountLine))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isDeleted != other.isDeleted)
			return false;
		if (modelYear == null) {
			if (other.modelYear != null)
				return false;
		} else if (!modelYear.equals(other.modelYear))
			return false;
		if (productPartList1 == null) {
			if (other.productPartList1 != null)
				return false;
		} else if (!productPartList1.equals(other.productPartList1))
			return false;
		if (productPartList2 == null) {
			if (other.productPartList2 != null)
				return false;
		} else if (!productPartList2.equals(other.productPartList2))
			return false;
		if (productPriceList == null) {
			if (other.productPriceList != null)
				return false;
		} else if (!productPriceList.equals(other.productPriceList))
			return false;
		if (productTranslationList == null) {
			if (other.productTranslationList != null)
				return false;
		} else if (!productTranslationList.equals(other.productTranslationList))
			return false;
		if (published != other.published)
			return false;
		if (specFilename == null) {
			if (other.specFilename != null)
				return false;
		} else if (!specFilename.equals(other.specFilename))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", code=" + code + ", dfv1=" + dfv1
				+ ", dfv2=" + dfv2 + ", barcode=" + barcode + ", modelYear="
				+ modelYear + ", specFilename=" + specFilename + ", isDeleted="
				+ isDeleted + ", published=" + published + ", brand=" + brand
				+ ", category=" + category + ", discountLine=" + discountLine
				+ ", productPartList1=" + productPartList1
				+ ", productPartList2=" + productPartList2
				+ ", productTranslationList=" + productTranslationList
				+ ", productPriceList=" + productPriceList + "]";
	}

	
	
	
}
