package cn.tedu.nybike.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import cn.tedu.nybike.pojo.JsonResult;
import cn.tedu.nybike.pojo.OperationDo;
import cn.tedu.nybike.pojo.ShowDo;
import cn.tedu.nybike.pojo.genderAgeVo;
import cn.tedu.nybike.service.IOperationService;
import cn.tedu.nybike.util.IPUtils;

@RestController // 表示本类中所有方法返回的都是json字符串
@RequestMapping("/operation")
public class OperationController {

	@Autowired
	IOperationService service;
	
	@RequestMapping("/save")
	public JsonResult<Void> saveOperation(OperationDo opt){
		// 获取用户的ip
		String userIp=IPUtils.getIpAddr();
		// 将ip添加到opt对象中
		opt.setUserIp(userIp);
		// 调用业务层方法，添加一项操作记录
		service.saveOperation(opt);
		// 返回成功提示
		return new JsonResult<Void>(2000, "OK", null);
	}
	@RequestMapping("/showData")
	public JsonResult<ShowDo> findData(){
		JsonResult<ShowDo> jr=new JsonResult<ShowDo>();
		ShowDo sd=service.findData();
		jr.setState(2000);
		jr.setMsg("OK");
		jr.setData(sd);
		// 返回成功提示
		return jr;
	}
	
	@RequestMapping("/gender")
	public JsonResult<genderAgeVo> getGenderData(){
		JsonResult<genderAgeVo> jr=new JsonResult<genderAgeVo>();
		genderAgeVo vo=service.getGenderData();
		jr.setState(2000);
		jr.setMsg("OK");
		jr.setData(vo);
		// 返回成功提示
		return jr;
	}
	@RequestMapping("/subscribe")
	public SseEmitter subscribe(String id,String date,
			Integer stationCountLimit, Integer ipLimit, Long interval) {
		// 参数的非空验证 TODO
		
		// 创建SseEmitter对象
		SseEmitter sseEmitter=new SseEmitter(1*24*60*60*1000L);
		// 启动子线程
		MyRunner runner=new MyRunner(sseEmitter,interval,date,stationCountLimit,ipLimit);
		Thread t1=new Thread(runner);
		t1.start();
		// 为sseEmitter设置onCompleation事件
		sseEmitter.onCompletion(new Runnable() {
			@Override
			public void run() {
				System.err.println( id+"=>SSE终止");
				// 结束子线程的发送数据的循环
				runner.stop();
			}
		});
		
		// 返回sseEmitter
		return sseEmitter;
	}
	
	class MyRunner implements Runnable{
		
		private SseEmitter sseEmitter;
		private String date;
		private Integer stationCountLimit;
		private Integer ipLimit;
		private long interval; // 推送的间隔
		private volatile boolean flag=true;// 循环的开关
		
		public MyRunner(SseEmitter sseEmitter,long interval, String date, Integer stationCountLimit, Integer ipLimit) {
			this.sseEmitter = sseEmitter;
			this.interval=interval;
			this.date = date;
			this.stationCountLimit = stationCountLimit;
			this.ipLimit = ipLimit;
		}
		
		public void stop() {
			this.flag=false;
		}

		@Override
		public void run() {
			// 周期性获取大屏所需数据，调用sseEmitter推送数据
			while(flag) {
				try {
					Thread.sleep(interval);
					sseEmitter.send(service.findOperationData(date, stationCountLimit, ipLimit));
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}	
		}
	}
	
}



