package cn.tedu.nybike.util;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtils {
	
	private static final String BufferedInputStream = null;

	/**
	 * 发送GET请求，并返回响应内容的方法
	 * @param urlStr 请求的url
	 * @return 响应数据
	 */
	public static String get(String urlStr){
        String message="";
        try {
            URL url=new URL(urlStr);
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");//设置提交模式，get方法的返回的数据时放在url上的，而post是放在正文里面
            connection.setConnectTimeout(20*1000);//设置延时时间
            connection.connect();//连接
            //InputStream inputStream=connection.getInputStream();//读数据，IuputStream是不带缓存的，应该使用BufferedInputStream返回的数据
            int code=connection.getResponseCode();
            java.io.BufferedInputStream bf;
            if(code!=200)
            {
            	bf=new java.io.BufferedInputStream(connection.getErrorStream());
            }
            else
            {
            	bf=new java.io.BufferedInputStream(connection.getInputStream());   
            	byte[] data=new byte[1024*512];// 512kb缓存空间
            	StringBuffer sb=new StringBuffer();
            	int length=0;
            	while ((length=bf.read(data))!=-1){
            		String s=new String(data,0,length);
            		sb.append(s);
            	}
            	message=sb.toString();
            	bf.close();
            	connection.disconnect();
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
				Thread.sleep(5*1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
            return get(urlStr);
        }
        return message;
    }

}

