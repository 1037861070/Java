package �������ͻ��˻�ȡ������ʱ��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws IOException, Exception {
		// TODO �Զ����ɵķ������
   Socket socket=new Socket("192.168.1.103",3001);
   BufferedReader bReader=new BufferedReader(
		   new InputStreamReader(socket.getInputStream()));
   String line=bReader.readLine();
   System.out.println("���Է���������Ϣ��"+line);
   bReader.close();
   socket.close();
	}

}
