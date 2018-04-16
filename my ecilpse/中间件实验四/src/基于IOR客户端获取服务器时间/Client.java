package ����IOR�ͻ��˻�ȡ������ʱ��;

import java.util.Properties;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

public class Client {

	public static void main(String[] args) {
		try{
			 

			Properties env = new Properties(); 
			env.setProperty("org.omg.CORBA.ORBInitialHost", "127.0.0.1");
			env.setProperty("org.omg.CORBA.ORBInitialPort", "1050"); 
			ORB orb = ORB.init(args, env);
			
			org.omg.CORBA.Object temp;
			 
			temp = orb.resolve_initial_references("NameService"); 
			NamingContextExt node = NamingContextExtHelper.narrow(temp); 
			//���ӷ�����
			temp = node.resolve_str("Basic Arithmetic");
			BAInterface ro = BAInterfaceHelper.narrow(temp);
			_BAResultHolder result = new _BAResultHolder(); 
			//����ʵ�����ķ���
			ro.BACalculation(result);
			_BAResult res = result.value; 
			
			String time = res.time;
			System.out.println(time);
			}catch(Exception ex){}

	}
}
