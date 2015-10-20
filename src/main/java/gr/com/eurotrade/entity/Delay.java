package gr.com.eurotrade.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Delay {

	@EmbeddedId
	protected DelayPK delayPK;
	
	private Integer delay;

	
	@ManyToOne
	@JoinColumn(name="branchFromId", insertable = false, updatable = false)
	private Branch branchDelay1;

	@ManyToOne
	@JoinColumn(name="branchToId", insertable = false, updatable = false)
	private Branch branchDelay2;
	
	
	
	
	public DelayPK getDelayPK() {
		return delayPK;
	}

	public void setDelayPK(DelayPK delayPK) {
		this.delayPK = delayPK;
	}

	public Integer getDelay() {
		return delay;
	}

	public void setDelay(Integer delay) {
		this.delay = delay;
	}

	public Branch getBranchDelay1() {
		return branchDelay1;
	}

	public void setBranchDelay1(Branch branchDelay1) {
		this.branchDelay1 = branchDelay1;
	}

	public Branch getBranchDelay2() {
		return branchDelay2;
	}

	public void setBranchDelay2(Branch branchDelay2) {
		this.branchDelay2 = branchDelay2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((branchDelay1 == null) ? 0 : branchDelay1.hashCode());
		result = prime * result
				+ ((branchDelay2 == null) ? 0 : branchDelay2.hashCode());
		result = prime * result + ((delay == null) ? 0 : delay.hashCode());
		result = prime * result + ((delayPK == null) ? 0 : delayPK.hashCode());
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
		Delay other = (Delay) obj;
		if (branchDelay1 == null) {
			if (other.branchDelay1 != null)
				return false;
		} else if (!branchDelay1.equals(other.branchDelay1))
			return false;
		if (branchDelay2 == null) {
			if (other.branchDelay2 != null)
				return false;
		} else if (!branchDelay2.equals(other.branchDelay2))
			return false;
		if (delay == null) {
			if (other.delay != null)
				return false;
		} else if (!delay.equals(other.delay))
			return false;
		if (delayPK == null) {
			if (other.delayPK != null)
				return false;
		} else if (!delayPK.equals(other.delayPK))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Delay [delayPK=" + delayPK + ", delay=" + delay
				+ ", branchDelay1=" + branchDelay1 + ", branchDelay2="
				+ branchDelay2 + "]";
	}

	
	
	
	
	
}
