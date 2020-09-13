package cn.tedu.nybike.pojo;


/**
 * 与数据库表station_info中一条数据相对应的JavaBean
 */
public class StationInfoDO {
	private int station_id; //站点id
	private String name; //站点名称
	private double lat; //站点纬度
	private double lon; //站点经度
	
	public StationInfoDO() {
		
	}

	public StationInfoDO(int id, String name, double lat, double lon) {
		this.station_id = id;
		this.name = name;
		this.lat = lat;
		this.lon = lon;
	}

	public int getStation_id() {
		return station_id;
	}

	public void setStation_id(int station_id) {
		this.station_id = station_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	@Override
	public String toString() {
		return station_id+"," + name + "," + lat + "," + lon;
	}

}
