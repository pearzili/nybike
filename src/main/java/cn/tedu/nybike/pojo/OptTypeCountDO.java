package cn.tedu.nybike.pojo;

import java.io.Serializable;

public class OptTypeCountDO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3565611816789936471L;
	private Integer optType;
	private Integer count;
	public OptTypeCountDO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OptTypeCountDO(Integer optType, Integer count) {
		super();
		this.optType = optType;
		this.count = count;
	}
	public Integer getOptType() {
		return optType;
	}
	public void setOptType(Integer optType) {
		this.optType = optType;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + ((optType == null) ? 0 : optType.hashCode());
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
		OptTypeCountDO other = (OptTypeCountDO) obj;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (optType == null) {
			if (other.optType != null)
				return false;
		} else if (!optType.equals(other.optType))
			return false;
		return true;
	}
	

}
