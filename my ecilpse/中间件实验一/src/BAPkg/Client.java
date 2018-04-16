package BAPkg;
import org.omg.CORBA.ORB; import org.omg.CORBA.Object;
import org.omg.CosNaming.NamingContextExt; import org.omg.CosNaming.NamingContextExtHelper; import java.util.Properties;
public class Client {
public static void main(String[] args)
{

		try {

			Properties env = new Properties();
			env.setProperty("org.omg.CORBA.ORBInitialHost", "127.0.0.1");
			env.setProperty("org.omg.CORBA.ORBInitialPort", "1050");
			ORB orb = ORB.init(args, env);
			org.omg.CORBA.Object temp;

			temp = orb.resolve_initial_references("NameService");
			NamingContextExt node = NamingContextExtHelper.narrow(temp);
			temp = node.resolve_str("Basic Arithmetic");
			BAInterface ro = BAInterfaceHelper.narrow(temp);
			int a = 30, b = 20;
			_BAResultHolder result = new _BAResultHolder();
			ro.BACalculation(a, b, result);
			_BAResult res = result.value;
			System.out.println("sum = " + res.sum + "\n" + "minus = "
					+ res.minus + "\n" + "product = " + res.product + "\n"
					+ "quotient = " + res.quotient);

		} catch (Exception ex) {
		}
		
	}
}
