package 面向对象客户端获取服务器时间;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.Date;

public class Server {

	public static void main(String[] args) throws Exception {
		// TODO 自动生成的方法存根
		System.out.println("正在连接服务器...");
ServerSocket socket=new ServerSocket(3001);
while(true){
	Socket s=socket.accept();
	Calendar cl=Calendar.getInstance();
	Date date=cl.getTime();
	PrintStream ps=new PrintStream(s.getOutputStream());
	System.out.print("打开服务器连接...");
	ps.println("我这的时间是："+date);
	ps.close();
	s.close();
	
}

	}

}
