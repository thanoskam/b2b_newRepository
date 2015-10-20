package gr.com.eurotrade.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PreorderStatus {

	@Id
//	@GeneratedValue
	private Integer id;
	
	private String name;

	private String descr;

	
	
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

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	
	
	
}
