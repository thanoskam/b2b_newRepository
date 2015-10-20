package gr.com.eurotrade.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class DelayPK implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer branchFromId;
	
	private Integer branchToId;

	
	
	public Integer getBranchFromId() {
		return branchFromId;
	}

	public void setBranchFromId(Integer branchFromId) {
		this.branchFromId = branchFromId;
	}

	public Integer getBranchToId() {
		return branchToId;
	}

	public void setBranchToId(Integer branchToId) {
		this.branchToId = branchToId;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((branchFromId == null) ? 0 : branchFromId.hashCode());
		result = prime * result
				+ ((branchToId == null) ? 0 : branchToId.hashCode());
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
		DelayPK other = (DelayPK) obj;
		if (branchFromId == null) {
			if (other.branchFromId != null)
				return false;
		} else if (!branchFromId.equals(other.branchFromId))
			return false;
		if (branchToId == null) {
			if (other.branchToId != null)
				return false;
		} else if (!branchToId.equals(other.branchToId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DelayPK [branchFromId=" + branchFromId + ", branchToId="
				+ branchToId + "]";
	}

	
	
}
