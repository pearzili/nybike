package cn.tedu.nybike.pojo;

import java.io.Serializable;
/**
 * 封装用户IP和访问次数
 */
public class UserIPCountDO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6029981233304147901L;
	private String userIP;
	private Integer count;
	public UserIPCountDO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserIPCountDO(String userIP, Integer count) {
		super();
		this.userIP = userIP;
		this.count = count;
	}
	public String getUserIP() {
		return userIP;
	}
	public void setUserIP(String userIP) {
		this.userIP = userIP;
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
		result = prime * result + ((userIP == null) ? 0 : userIP.hashCode());
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
		UserIPCountDO other = (UserIPCountDO) obj;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (userIP == null) {
			if (other.userIP != null)
				return false;
		} else if (!userIP.equals(other.userIP))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserIpCountDo [userIP=" + userIP + ", count=" + count + "]";
	}
	

}
