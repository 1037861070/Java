package �������ͻ��˻�ȡ������ʱ��;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.Date;

public class Server {

	public static void main(String[] args) throws Exception {
		// TODO �Զ����ɵķ������
		System.out.println("�������ӷ�����...");
ServerSocket socket=new ServerSocket(3001);
while(true){
	Socket s=socket.accept();
	Calendar cl=Calendar.getInstance();
	Date date=cl.getTime();
	PrintStream ps=new PrintStream(s.getOutputStream());
	System.out.print("�򿪷���������...");
	ps.println("�����ʱ���ǣ�"+date);
	ps.close();
	s.close();
	
}

	}

}
