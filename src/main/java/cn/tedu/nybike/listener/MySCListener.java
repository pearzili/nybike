package cn.tedu.nybike.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import cn.tedu.nybike.util.HttpUtils;

@WebListener
public class MySCListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// sce是事件对象，其中包含了对事件源的引用，及对ServletContext的引用
		ServletContext sc=sce.getServletContext();
		
		// 希望应用启动后马上执行什么逻辑，写这里
		// 创建子线程
			Thread t1=new Thread(new Runnable() {
			String infoUrl="https://gbfs.citibikenyc.com/gbfs/en/station_information.json";
			String statusUrl="https://gbfs.citibikenyc.com/gbfs/en/station_status.json";
			@Override
			public void run() { // 子线程启动后执行的逻辑
				while(true) {
					// 请求站点信息数据和状态数据
					String infoData=HttpUtils.get(infoUrl);
					String statusData=HttpUtils.get(statusUrl);
					// 缓存到ServletContext中
					sc.setAttribute("infoData", infoData);
					sc.setAttribute("statusData", statusData);
					System.err.println(System.currentTimeMillis()+"=>"+infoData.length()+","+statusData.length());
					try {
						// 暂停30秒,不知能一直获取数据等待一下在获取
						Thread.sleep(30*1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		// 启动子线程
		t1.start();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// 希望应用即将被销毁前执行什么逻辑，写这里
	}

}
