package cn.tedu.nybike.pojo;
import java.io.Serializable;
import java.util.Date;

/**
 * 每个类之前都要有注释。
 * 用于封装用户一次操作信息的实体类
 * 实体类开发规范
 * 1.所有属性用private修饰,使用包裹类类型(可以合理地表示空值，基本数据类型不可以合理地表示空值)
 * 2.提供必要的get/set方法
 * 3.显示生命无参构造器
 * 	原因：如果一个类声明了带参构造器，编译器不会再自动添加无参构造器。主流框架创建实体类实例时，是通过反射调用无参构造器
 * 如果一个实体类没有无参构造器，会有异常抛出
 * 4.重写hashCode和equal方法，为基于hash算法的容器提供支持
 * 5.重写toString方法，便于在异常排查时查看对象的属性值
 * 6.实现Serializable接口
 * DO类表示DataOject，类的属性和数据库表的字段一一对应。通常与数据库的字段或从数据库返回的字典一致
 * @author Administrator
 *
 */
public class OperationDo implements Serializable{

	/**
	 * 序列化对象使用的ID
	 */
	private static final long serialVersionUID = 2535920353665885373L;
	private Long id;
	private Integer optType;
	private String userIp;
	private Integer stationId;
	private Double dragStartLat;//拖拽开始的纬度
	private Double dragStartLon;//拖拽结束的经度
	private Double dragEndLat;
	private Double dragEndLon;	
	private Integer zoomStartLevel;
	private Integer zoomEndLevel;
	private Date createdTime;
	public OperationDo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OperationDo(Long id, Integer optType, String userIp, Integer stationId, Double dragStartLat,
			Double dragStartLon, Double dragEndLat, Double dragEndLon, Integer zoomStartLevel, Integer zoomEndLevel,
			Date createdTime) {
		super();
		this.id = id;
		this.optType = optType;
		this.userIp = userIp;
		this.stationId = stationId;
		this.dragStartLat = dragStartLat;
		this.dragStartLon = dragStartLon;
		this.dragEndLat = dragEndLat;
		this.dragEndLon = dragEndLon;
		this.zoomStartLevel = zoomStartLevel;
		this.zoomEndLevel = zoomEndLevel;
		this.createdTime = createdTime;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getOptType() {
		return optType;
	}
	public void setOptType(Integer optType) {
		this.optType = optType;
	}
	public String getUserIp() {
		return userIp;
	}
	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}
	public Integer getStationId() {
		return stationId;
	}
	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}
	public Double getDragStartLat() {
		return dragStartLat;
	}
	public void setDragStartLat(Double dragStartLat) {
		this.dragStartLat = dragStartLat;
	}
	public Double getDragStartLon() {
		return dragStartLon;
	}
	public void setDragStartLon(Double dragStartLon) {
		this.dragStartLon = dragStartLon;
	}
	public Double getDragEndLat() {
		return dragEndLat;
	}
	public void setDragEndLat(Double dragEndLat) {
		this.dragEndLat = dragEndLat;
	}
	public Double getDragEndLon() {
		return dragEndLon;
	}
	public void setDragEndLon(Double dragEndLon) {
		this.dragEndLon = dragEndLon;
	}
	public Integer getZoomStartLevel() {
		return zoomStartLevel;
	}
	public void setZoomStartLevel(Integer zoomStartLevel) {
		this.zoomStartLevel = zoomStartLevel;
	}
	public Integer getZoomEndLevel() {
		return zoomEndLevel;
	}
	public void setZoomEndLevel(Integer zoomEndLevel) {
		this.zoomEndLevel = zoomEndLevel;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdTime == null) ? 0 : createdTime.hashCode());
		result = prime * result + ((dragEndLat == null) ? 0 : dragEndLat.hashCode());
		result = prime * result + ((dragEndLon == null) ? 0 : dragEndLon.hashCode());
		result = prime * result + ((dragStartLat == null) ? 0 : dragStartLat.hashCode());
		result = prime * result + ((dragStartLon == null) ? 0 : dragStartLon.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((optType == null) ? 0 : optType.hashCode());
		result = prime * result + ((stationId == null) ? 0 : stationId.hashCode());
		result = prime * result + ((userIp == null) ? 0 : userIp.hashCode());
		result = prime * result + ((zoomEndLevel == null) ? 0 : zoomEndLevel.hashCode());
		result = prime * result + ((zoomStartLevel == null) ? 0 : zoomStartLevel.hashCode());
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
		OperationDo other = (OperationDo) obj;
		if (createdTime == null) {
			if (other.createdTime != null)
				return false;
		} else if (!createdTime.equals(other.createdTime))
			return false;
		if (dragEndLat == null) {
			if (other.dragEndLat != null)
				return false;
		} else if (!dragEndLat.equals(other.dragEndLat))
			return false;
		if (dragEndLon == null) {
			if (other.dragEndLon != null)
				return false;
		} else if (!dragEndLon.equals(other.dragEndLon))
			return false;
		if (dragStartLat == null) {
			if (other.dragStartLat != null)
				return false;
		} else if (!dragStartLat.equals(other.dragStartLat))
			return false;
		if (dragStartLon == null) {
			if (other.dragStartLon != null)
				return false;
		} else if (!dragStartLon.equals(other.dragStartLon))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (optType == null) {
			if (other.optType != null)
				return false;
		} else if (!optType.equals(other.optType))
			return false;
		if (stationId == null) {
			if (other.stationId != null)
				return false;
		} else if (!stationId.equals(other.stationId))
			return false;
		if (userIp == null) {
			if (other.userIp != null)
				return false;
		} else if (!userIp.equals(other.userIp))
			return false;
		if (zoomEndLevel == null) {
			if (other.zoomEndLevel != null)
				return false;
		} else if (!zoomEndLevel.equals(other.zoomEndLevel))
			return false;
		if (zoomStartLevel == null) {
			if (other.zoomStartLevel != null)
				return false;
		} else if (!zoomStartLevel.equals(other.zoomStartLevel))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OperationDo [id=" + id + ", optType=" + optType + ", userIp=" + userIp + ", stationId=" + stationId
				+ ", dragStartLat=" + dragStartLat + ", dragStartLon=" + dragStartLon + ", dragEndLat=" + dragEndLat
				+ ", dragEndLon=" + dragEndLon + ", zoomStartLevel=" + zoomStartLevel + ", zoomEndLevel=" + zoomEndLevel
				+ ", createdTime=" + createdTime + "]";
	}
	
	 

}
