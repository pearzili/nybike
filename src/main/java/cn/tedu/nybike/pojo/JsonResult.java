package cn.tedu.nybike.pojo;
/**
 * 用于封装服务器给浏览器返回的json数据
 * @author Administrator
 * @param <T>封装数据的泛型
 *
 */
public class JsonResult<T> {
	private Integer state;//自定义的响应状态码
	private String msg;//自定义的消息
	private T data;//查询操作的数据
	public JsonResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JsonResult(Integer state, String msg, T data) {
		super();
		this.state = state;
		this.msg = msg;
		this.data = data;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

}
