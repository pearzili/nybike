package cn.tedu.nybike.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.nybike.pojo.JsonResult;
import cn.tedu.nybike.service.ex.EmptyArgumentException;
import cn.tedu.nybike.service.ex.InsertException;
import cn.tedu.nybike.service.ex.ServiceException;

@ControllerAdvice //切面，环绕通知
public class GlobalExceptionController {//全局异常处理类
	/**
	 * 统一处理业务层自定义异常的方法
	 * @param e异常对象
	 * @return
	 */
	@ExceptionHandler(ServiceException.class)
	@ResponseBody
	public JsonResult<Void> handleServiceException(Throwable e){
		//创建json
		JsonResult<Void> jr=new JsonResult<Void>();
		jr.setMsg(e.getMessage());//获取ServiceException添加的消息提示，用户在浏览器就可以看到提示消息
		//根据异常类型，设定状态码
		if(e instanceof EmptyArgumentException) {
			jr.setState(2001);
		}else if(e instanceof InsertException) {
			jr.setState(3001);
		}
		return jr;
	}

}
