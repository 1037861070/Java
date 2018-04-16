package 基于IOR客户端获取服务器时间;

import org.omg.CORBA.ORB; 
import org.omg.CosNaming.NamingContextExt; 
import org.omg.CosNaming.NamingContextExtHelper; 
import  org.omg.CosNaming.NameComponent;
import  org.omg.PortableServer.POA; 
import org.omg.PortableServer.POAHelper;
 
import java.util.Properties;

public class Serve {
	public static void main(String[] args) {
		try{
			Properties env = new Properties();
			env.setProperty("org.omg.CORBA.ORBInitialHost",	"127.0.0.1");
			env.setProperty("org.omg.CORBA.ORBInitialPort",	"1050");
			//orb初始化
			ORB orb = ORB.init(args, env);
			org.omg.CORBA.Object temp;
			temp = orb.resolve_initial_references("RootPOA"); 
			//poa初始化
			POA poa = POAHelper.narrow(temp);
			poa.the_POAManager().activate();
			BAImpl servant = new BAImpl();
			temp = poa.servant_to_reference(servant); 
			BAInterface ro = BAInterfaceHelper.narrow(temp); 
			temp = orb.resolve_initial_references("NameService");
			NamingContextExt node = NamingContextExtHelper.narrow(temp); 
			//将ro绑定到这个名称下
			NameComponent[] path = node.to_name("Basic Arithmetic"); 
			node.rebind(path, ro);
			System.out.println("Server is running......."); 
			orb.run();
			}catch(Exception ex){
				
			}
	}
	

}
