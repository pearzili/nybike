package cn.tedu.nybike.pojo;

public class StationClickCountDO {
	private Integer stationId;
	private String name;
	private Integer count;
	public StationClickCountDO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StationClickCountDO(Integer stationId, String name, Integer count) {
		super();
		this.stationId = stationId;
		this.name = name;
		this.count = count;
	}
	public Integer getStationId() {
		return stationId;
	}
	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((stationId == null) ? 0 : stationId.hashCode());
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
		StationClickCountDO other = (StationClickCountDO) obj;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (stationId == null) {
			if (other.stationId != null)
				return false;
		} else if (!stationId.equals(other.stationId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "StationClickCountDo [stationId=" + stationId + ", name=" + name + ", count=" + count + "]";
	}
	
	

}
