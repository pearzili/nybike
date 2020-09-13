package cn.tedu.nybike.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 封装数据大屏所需的数据
 * @author Administrator
 *
 */
public class OperationVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2073813658976499457L;
	private List<Integer> accessCountXData;
	private List<String> accessCountYData;
	private List<Integer> stationCountXData;
	private List<String> stationCountNameData;
	private List<Integer> stationCountYData;
	private List<String> ipCountXData;
	private List<Integer> ipCountYData;
	public OperationVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OperationVO(List<Integer> accessCountXData, List<String> accessCounYData, List<Integer> stationCountXData,
			List<String> stationCountNameData, List<Integer> stationCountYData, List<String> ipCountXData,
			List<Integer> ipCountYData) {
		super();
		this.accessCountXData = accessCountXData;
		this.accessCountYData = accessCounYData;
		this.stationCountXData = stationCountXData;
		this.stationCountNameData = stationCountNameData;
		this.stationCountYData = stationCountYData;
		this.ipCountXData = ipCountXData;
		this.ipCountYData = ipCountYData;
	}
	public List<Integer> getAccessCountXData() {
		return accessCountXData;
	}
	public void setAccessCountXData(List<Integer> accessCountXData) {
		this.accessCountXData = accessCountXData;
	}
	public List<String> getAccessCounYXData() {
		return accessCountYData;
	}
	public void setAccessCounYXData(List<String> accessCounYXData) {
		this.accessCountYData = accessCounYXData;
	}
	public List<Integer> getStationCountXData() {
		return stationCountXData;
	}
	public void setStationCountXData(List<Integer> stationCountXData) {
		this.stationCountXData = stationCountXData;
	}
	public List<String> getStationCountNameData() {
		return stationCountNameData;
	}
	public void setStationCountNameData(List<String> stationCountNameData) {
		this.stationCountNameData = stationCountNameData;
	}
	public List<Integer> getStationCountYData() {
		return stationCountYData;
	}
	public void setStationCountYData(List<Integer> stationCountYData) {
		this.stationCountYData = stationCountYData;
	}
	public List<String> getIpCountXData() {
		return ipCountXData;
	}
	public void setIpCountXData(List<String> ipCountXData) {
		this.ipCountXData = ipCountXData;
	}
	public List<Integer> getIpCountYData() {
		return ipCountYData;
	}
	public void setIpCountYData(List<Integer> ipCountYData) {
		this.ipCountYData = ipCountYData;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accessCountYData == null) ? 0 : accessCountYData.hashCode());
		result = prime * result + ((accessCountXData == null) ? 0 : accessCountXData.hashCode());
		result = prime * result + ((ipCountXData == null) ? 0 : ipCountXData.hashCode());
		result = prime * result + ((ipCountYData == null) ? 0 : ipCountYData.hashCode());
		result = prime * result + ((stationCountNameData == null) ? 0 : stationCountNameData.hashCode());
		result = prime * result + ((stationCountXData == null) ? 0 : stationCountXData.hashCode());
		result = prime * result + ((stationCountYData == null) ? 0 : stationCountYData.hashCode());
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
		OperationVO other = (OperationVO) obj;
		if (accessCountYData == null) {
			if (other.accessCountYData != null)
				return false;
		} else if (!accessCountYData.equals(other.accessCountYData))
			return false;
		if (accessCountXData == null) {
			if (other.accessCountXData != null)
				return false;
		} else if (!accessCountXData.equals(other.accessCountXData))
			return false;
		if (ipCountXData == null) {
			if (other.ipCountXData != null)
				return false;
		} else if (!ipCountXData.equals(other.ipCountXData))
			return false;
		if (ipCountYData == null) {
			if (other.ipCountYData != null)
				return false;
		} else if (!ipCountYData.equals(other.ipCountYData))
			return false;
		if (stationCountNameData == null) {
			if (other.stationCountNameData != null)
				return false;
		} else if (!stationCountNameData.equals(other.stationCountNameData))
			return false;
		if (stationCountXData == null) {
			if (other.stationCountXData != null)
				return false;
		} else if (!stationCountXData.equals(other.stationCountXData))
			return false;
		if (stationCountYData == null) {
			if (other.stationCountYData != null)
				return false;
		} else if (!stationCountYData.equals(other.stationCountYData))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OperationVO [accessCountXData=" + accessCountXData + ", accessCounYXData=" + accessCountYData
				+ ", stationCountXData=" + stationCountXData + ", stationCountNameData=" + stationCountNameData
				+ ", stationCountYData=" + stationCountYData + ", ipCountXData=" + ipCountXData + ", ipCountYData="
				+ ipCountYData + "]";
	}
	
}
