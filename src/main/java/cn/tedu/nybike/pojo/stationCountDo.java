package cn.tedu.nybike.pojo;
/**
 * 统计这个站点的骑行人数
 * @author Administrator
 *
 */
public class stationCountDo {
	private Integer stationId;//站点id;
	private String name;//站点名称
	private Integer count;//站点的骑行人数
	private Double lon;//经度
	private Double lat;//纬度
	public stationCountDo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public stationCountDo(Integer stationId,String name, Integer count, Double lon, Double lat) {
		super();
		this.stationId=stationId;
		this.name = name;
		this.count = count;
		this.lon = lon;
		this.lat = lat;
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
	public Double getLon() {
		return lon;
	}
	public void setLon(Double lon) {
		this.lon = lon;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + ((lat == null) ? 0 : lat.hashCode());
		result = prime * result + ((lon == null) ? 0 : lon.hashCode());
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
		stationCountDo other = (stationCountDo) obj;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (lat == null) {
			if (other.lat != null)
				return false;
		} else if (!lat.equals(other.lat))
			return false;
		if (lon == null) {
			if (other.lon != null)
				return false;
		} else if (!lon.equals(other.lon))
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
		return "stationCountDo [stationId=" + stationId + ", name=" + name + ", count=" + count + ", lon=" + lon
				+ ", lat=" + lat + "]";
	}
	


	

}
