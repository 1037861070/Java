package 基于IOR客户端获取服务器时间;

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
			//连接服务器
			temp = node.resolve_str("Basic Arithmetic");
			BAInterface ro = BAInterfaceHelper.narrow(temp);
			_BAResultHolder result = new _BAResultHolder(); 
			//调用实例化的方法
			ro.BACalculation(result);
			_BAResult res = result.value; 
			
			String time = res.time;
			System.out.println(time);
			}catch(Exception ex){}

	}
}
