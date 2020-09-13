package cn.tedu.nybike.pojo;

import java.util.List;

public class ShowDo {
	private List<Integer> mapId;//地图的名字
	private List<String> mapName;//地图的名字
	private List<Integer> mapStationCount;//地图站点上数量总和
	private List<Double> mapLon;//地图站点的经度
	private List<Double> maplat;//地图站点的纬度;
	public ShowDo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShowDo(List<Integer> mapId,List<String> mapName, List<Integer> mapStationCount, List<Double> mapLon, List<Double> maplat) {
		super();
		this.mapId=mapId;
		this.mapName = mapName;
		this.mapStationCount = mapStationCount;
		this.mapLon = mapLon;
		this.maplat = maplat;
	}
	
	public List<Integer> getMapId() {
		return mapId;
	}
	public void setMapId(List<Integer> mapId) {
		this.mapId = mapId;
	}
	public List<String> getMapName() {
		return mapName;
	}
	public void setMapName(List<String> mapName) {
		this.mapName = mapName;
	}
	public List<Integer> getMapStationCount() {
		return mapStationCount;
	}
	public void setMapStationCount(List<Integer> mapStationCount) {
		this.mapStationCount = mapStationCount;
	}
	public List<Double> getMapLon() {
		return mapLon;
	}
	public void setMapLon(List<Double> mapLon) {
		this.mapLon = mapLon;
	}
	public List<Double> getMaplat() {
		return maplat;
	}
	public void setMaplat(List<Double> maplat) {
		this.maplat = maplat;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mapId == null) ? 0 : mapId.hashCode());
		result = prime * result + ((mapLon == null) ? 0 : mapLon.hashCode());
		result = prime * result + ((mapName == null) ? 0 : mapName.hashCode());
		result = prime * result + ((mapStationCount == null) ? 0 : mapStationCount.hashCode());
		result = prime * result + ((maplat == null) ? 0 : maplat.hashCode());
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
		ShowDo other = (ShowDo) obj;
		if (mapId == null) {
			if (other.mapId != null)
				return false;
		} else if (!mapId.equals(other.mapId))
			return false;
		if (mapLon == null) {
			if (other.mapLon != null)
				return false;
		} else if (!mapLon.equals(other.mapLon))
			return false;
		if (mapName == null) {
			if (other.mapName != null)
				return false;
		} else if (!mapName.equals(other.mapName))
			return false;
		if (mapStationCount == null) {
			if (other.mapStationCount != null)
				return false;
		} else if (!mapStationCount.equals(other.mapStationCount))
			return false;
		if (maplat == null) {
			if (other.maplat != null)
				return false;
		} else if (!maplat.equals(other.maplat))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ShowDo [mapId=" + mapId + ", mapName=" + mapName + ", mapStationCount=" + mapStationCount + ", mapLon="
				+ mapLon + ", maplat=" + maplat + "]";
	}
	

}
