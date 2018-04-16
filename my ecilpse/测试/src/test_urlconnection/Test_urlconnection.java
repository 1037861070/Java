package test_urlconnection;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class Test_urlconnection {

	public static String sendGet(String url,String param) throws IOException{
		String result ="";
		String urlname=url+"?"+param;
		try {
			URL realUrl=new URL(urlname);
			URLConnection connection=realUrl.openConnection();
			connection.setRequestProperty("accept", "*/*");
			connection.connect();
			Map<String, java.util.List<String>> map =connection.getHeaderFields();
			for(String key:map.keySet())
			{
				System.out.println(key+"  "+map.get(key));
			}
			BufferedReader in=new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
			String line;
			while((line=in.readLine())!=null)
			{
				result=result+"\n"+line;
			}
			
			
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
        try {
        
			String string=Test_urlconnection.sendGet("http://localhost:8080/Test/login.jsp", null);
			System.out.println(string);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
