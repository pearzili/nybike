package cn.tedu.nybike.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller//配置该类是SpringMVC的Controller类，将它交给SpirngMVC框架管理
@RequestMapping("/realtimeData")//配置该类的所有方法映射的父路径
public class RealtimeDataController {
	@RequestMapping(value="/infoData",produces="application/json;charset=UTF-8")//用户访问的路径是/realtimeData/infoData
	@ResponseBody//指明当前方法直接返回数据，否则String会被默认为资源的路径
	public String getInfoData(HttpServletRequest req,HttpServletResponse resp) {
		//从ServletContext中获取数据
		ServletContext sc=req.getServletContext();
		String infoData=(String) sc.getAttribute("infoData");//数据默认是object类型
		if(infoData==null)//如果缓冲区中没有数据
		{
			return "{data:{stations:[]}}";
		}
		return infoData;
	}
	@RequestMapping(value="/statusData",produces="application/json;charset=UTF-8")//用户访问的路径是/realtimeData/statusData
	@ResponseBody//指明当前方法直接返回数据，否则String会被默认为资源的路径
	public String getStatusData(HttpServletRequest req,HttpServletResponse resp) {
		//从ServletContext中获取数据
		ServletContext sc=req.getServletContext();
		String statusData=(String) sc.getAttribute("statusData");//数据默认是object类型
		if(statusData==null)//如果缓冲区中没有数据
		{
			return "{data:{stations:[]}}";
		}
		return statusData;
	}
}
