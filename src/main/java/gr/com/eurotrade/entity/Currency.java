package gr.com.eurotrade.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class Currency {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min = 1, message = "Name must be at least 1 characters!!")
	@Column(length = 45)
	private String name;

	@Column(length = 45)
	private String symbol;


	
	@OneToMany(mappedBy="currency")
	private List<Country> countrieList;



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSymbol() {
		return symbol;
	}



	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}



	public List<Country> getCountrieList() {
		return countrieList;
	}



	public void setCountrieList(List<Country> countrieList) {
		this.countrieList = countrieList;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((countrieList == null) ? 0 : countrieList.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
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
		Currency other = (Currency) obj;
		if (countrieList == null) {
			if (other.countrieList != null)
				return false;
		} else if (!countrieList.equals(other.countrieList))
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
		if (symbol == null) {
			if (other.symbol != null)
				return false;
		} else if (!symbol.equals(other.symbol))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Currency [id=" + id + ", name=" + name + ", symbol=" + symbol
				+ ", countrieList=" + countrieList + "]";
	}




	
}
