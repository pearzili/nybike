package cn.tedu.nybike.service.ex;
/**
 * 验证参数为空时抛出的异常
 * @author Administrator
 *
 */
public class EmptyArgumentException extends ServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8544019876420398023L;

	public EmptyArgumentException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmptyArgumentException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public EmptyArgumentException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public EmptyArgumentException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public EmptyArgumentException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
