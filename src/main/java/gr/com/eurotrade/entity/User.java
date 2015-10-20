package gr.com.eurotrade.entity;


import gr.com.eurotrade.annotation.UniqueUsername;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
public class User {
	@Id
	@GeneratedValue
	private Integer id;

    private Integer erpSellerCode;
  
    private Integer erpCustCode;

	@Size(min = 3, message = "Name must be at least 3 characters!")
	@Column(length = 45, unique = true)
	@UniqueUsername(message = "Such username already exists!")
	private String username;

	@Column(length = 60)
	private String fullname;

	@Email(message="Invalid email address!")
	@Column(length = 45)
	private String email;
	
	@Size(min = 5, message = "password must be at least 5 characters!")
	@Column(length = 200)
	private String password;
	
	private boolean enabled;

	private Integer cust_code;
	
	@Column(length = 15)
    private String phone1;
 
	@Column(length = 15)
	private String phone2;


	/*	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)*/
	@OneToMany(mappedBy="user", cascade=CascadeType.REMOVE)
	private List<Blog> blogList;	
	
	@ManyToOne
	@JoinColumn(name="compId", nullable=false)
	private Company company;
	
	@OneToMany(mappedBy="user")
	private List<UserBrand> userBrandList;
	
	@OneToMany(mappedBy="sellerUser")
	private List<SellerHasCustomer> sellerUserList;

	@OneToMany(mappedBy="customerUser")
	private List<SellerHasCustomer> customerUserList;

	@ManyToMany
	@JoinTable(name = "userHasRole", 
	   joinColumns = { @JoinColumn(name = "userId", referencedColumnName = "id") }, 
	   inverseJoinColumns = { @JoinColumn(name = "roleId" , referencedColumnName="id") })
	private List<Role> roleList;
	
	@ManyToMany
	@JoinTable(name = "userCatExcl", 
	   joinColumns = { @JoinColumn(name = "customerUserId", referencedColumnName = "id") }, 
	   inverseJoinColumns = { @JoinColumn(name = "catId" , referencedColumnName="id") })
	private List<Category> catList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getErpSellerCode() {
		return erpSellerCode;
	}

	public void setErpSellerCode(Integer erpSellerCode) {
		this.erpSellerCode = erpSellerCode;
	}

	public Integer getErpCustCode() {
		return erpCustCode;
	}

	public void setErpCustCode(Integer erpCustCode) {
		this.erpCustCode = erpCustCode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Integer getCust_code() {
		return cust_code;
	}

	public void setCust_code(Integer cust_code) {
		this.cust_code = cust_code;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public List<Blog> getBlogList() {
		return blogList;
	}

	public void setBlogList(List<Blog> blogList) {
		this.blogList = blogList;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<UserBrand> getUserBrandList() {
		return userBrandList;
	}

	public void setUserBrandList(List<UserBrand> userBrandList) {
		this.userBrandList = userBrandList;
	}

	public List<SellerHasCustomer> getSellerUserList() {
		return sellerUserList;
	}

	public void setSellerUserList(List<SellerHasCustomer> sellerUserList) {
		this.sellerUserList = sellerUserList;
	}

	public List<SellerHasCustomer> getCustomerUserList() {
		return customerUserList;
	}

	public void setCustomerUserList(List<SellerHasCustomer> customerUserList) {
		this.customerUserList = customerUserList;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public List<Category> getCatList() {
		return catList;
	}

	public void setCatList(List<Category> catList) {
		this.catList = catList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((blogList == null) ? 0 : blogList.hashCode());
		result = prime * result + ((catList == null) ? 0 : catList.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result
				+ ((cust_code == null) ? 0 : cust_code.hashCode());
		result = prime
				* result
				+ ((customerUserList == null) ? 0 : customerUserList.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result
				+ ((erpCustCode == null) ? 0 : erpCustCode.hashCode());
		result = prime * result
				+ ((erpSellerCode == null) ? 0 : erpSellerCode.hashCode());
		result = prime * result
				+ ((fullname == null) ? 0 : fullname.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone1 == null) ? 0 : phone1.hashCode());
		result = prime * result + ((phone2 == null) ? 0 : phone2.hashCode());
		result = prime * result
				+ ((roleList == null) ? 0 : roleList.hashCode());
		result = prime * result
				+ ((sellerUserList == null) ? 0 : sellerUserList.hashCode());
		result = prime * result
				+ ((userBrandList == null) ? 0 : userBrandList.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (blogList == null) {
			if (other.blogList != null)
				return false;
		} else if (!blogList.equals(other.blogList))
			return false;
		if (catList == null) {
			if (other.catList != null)
				return false;
		} else if (!catList.equals(other.catList))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (cust_code == null) {
			if (other.cust_code != null)
				return false;
		} else if (!cust_code.equals(other.cust_code))
			return false;
		if (customerUserList == null) {
			if (other.customerUserList != null)
				return false;
		} else if (!customerUserList.equals(other.customerUserList))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (enabled != other.enabled)
			return false;
		if (erpCustCode == null) {
			if (other.erpCustCode != null)
				return false;
		} else if (!erpCustCode.equals(other.erpCustCode))
			return false;
		if (erpSellerCode == null) {
			if (other.erpSellerCode != null)
				return false;
		} else if (!erpSellerCode.equals(other.erpSellerCode))
			return false;
		if (fullname == null) {
			if (other.fullname != null)
				return false;
		} else if (!fullname.equals(other.fullname))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone1 == null) {
			if (other.phone1 != null)
				return false;
		} else if (!phone1.equals(other.phone1))
			return false;
		if (phone2 == null) {
			if (other.phone2 != null)
				return false;
		} else if (!phone2.equals(other.phone2))
			return false;
		if (roleList == null) {
			if (other.roleList != null)
				return false;
		} else if (!roleList.equals(other.roleList))
			return false;
		if (sellerUserList == null) {
			if (other.sellerUserList != null)
				return false;
		} else if (!sellerUserList.equals(other.sellerUserList))
			return false;
		if (userBrandList == null) {
			if (other.userBrandList != null)
				return false;
		} else if (!userBrandList.equals(other.userBrandList))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", erpSellerCode=" + erpSellerCode
				+ ", erpCustCode=" + erpCustCode + ", username=" + username
				+ ", fullname=" + fullname + ", email=" + email + ", password="
				+ password + ", enabled=" + enabled + ", cust_code="
				+ cust_code + ", phone1=" + phone1 + ", phone2=" + phone2
				+ ", blogList=" + blogList + ", company=" + company
				+ ", userBrandList=" + userBrandList + ", sellerUserList="
				+ sellerUserList + ", customerUserList=" + customerUserList
				+ ", roleList=" + roleList + ", catList=" + catList + "]";
	}



	
	
}
