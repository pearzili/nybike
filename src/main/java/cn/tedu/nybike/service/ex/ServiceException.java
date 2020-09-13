package cn.tedu.nybike.service.ex;
/**
 * 业务层自定义异常的父类
 * 自定义异常开发步骤
 * 1、声明一个类，以Exception结尾
 * 2、继承Exception(编译异常)或RuntimeException(运行时异常)
 * 3、添加所有的构造器，并保证构造器中调用了父类的构造器
 * @author Administrator
 *
 */
public class ServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 850601258508878278L;

	public ServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
