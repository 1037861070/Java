package 面向对象客户端获取服务器时间;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws IOException, Exception {
		// TODO 自动生成的方法存根
   Socket socket=new Socket("192.168.1.103",3001);
   BufferedReader bReader=new BufferedReader(
		   new InputStreamReader(socket.getInputStream()));
   String line=bReader.readLine();
   System.out.println("来自服务器的消息："+line);
   bReader.close();
   socket.close();
	}

}
