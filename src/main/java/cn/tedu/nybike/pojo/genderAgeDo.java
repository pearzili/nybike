package cn.tedu.nybike.pojo;

public class genderAgeDo {
	private Integer age;
	private Integer count;
	private String gender;
	public genderAgeDo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public genderAgeDo(Integer age, Integer count, String gender) {
		super();
		this.age = age;
		this.count = count;
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
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
		genderAgeDo other = (genderAgeDo) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "genderAgeDo [age=" + age + ", count=" + count + ", gender=" + gender + "]";
	}
	

}
