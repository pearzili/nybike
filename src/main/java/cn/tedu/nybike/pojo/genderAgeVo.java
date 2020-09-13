package cn.tedu.nybike.pojo;

import java.util.List;

public class genderAgeVo {
	private List<Integer> ageData;
	private List<Integer> countData;
	private List<String> genderData;
	public genderAgeVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public genderAgeVo(List<Integer> ageData, List<Integer> countData, List<String> genderData) {
		super();
		this.ageData = ageData;
		this.countData = countData;
		this.genderData = genderData;
	}
	public List<Integer> getAgeData() {
		return ageData;
	}
	public void setAgeData(List<Integer> ageData) {
		this.ageData = ageData;
	}
	public List<Integer> getCountData() {
		return countData;
	}
	public void setCountData(List<Integer> countData) {
		this.countData = countData;
	}
	public List<String> getGenderData() {
		return genderData;
	}
	public void setGenderData(List<String> genderData) {
		this.genderData = genderData;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ageData == null) ? 0 : ageData.hashCode());
		result = prime * result + ((countData == null) ? 0 : countData.hashCode());
		result = prime * result + ((genderData == null) ? 0 : genderData.hashCode());
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
		genderAgeVo other = (genderAgeVo) obj;
		if (ageData == null) {
			if (other.ageData != null)
				return false;
		} else if (!ageData.equals(other.ageData))
			return false;
		if (countData == null) {
			if (other.countData != null)
				return false;
		} else if (!countData.equals(other.countData))
			return false;
		if (genderData == null) {
			if (other.genderData != null)
				return false;
		} else if (!genderData.equals(other.genderData))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "genderAgeVo [ageData=" + ageData + ", countData=" + countData + ", genderData=" + genderData + "]";
	}
	

}
