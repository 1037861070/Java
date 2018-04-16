package 基于IOR客户端获取服务器时间;


/**
* BAPkg/BAInterfacePOA.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从Time.idl
* 2017年5月21日 星期日 下午07时12分30秒 CST
*/

public abstract class BAInterfacePOA extends org.omg.PortableServer.Servant
 implements 基于IOR客户端获取服务器时间.BAInterfaceOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("BACalculation", new java.lang.Integer (0));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // BAPkg/BAInterface/BACalculation
       {
         基于IOR客户端获取服务器时间._BAResultHolder result = new 基于IOR客户端获取服务器时间._BAResultHolder ();
         this.BACalculation (result);
         out = $rh.createReply();
         基于IOR客户端获取服务器时间.BAResultHelper.write (out, result.value);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:BAPkg/BAInterface:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public BAInterface _this() 
  {
    return BAInterfaceHelper.narrow(
    super._this_object());
  }

  public BAInterface _this(org.omg.CORBA.ORB orb) 
  {
    return BAInterfaceHelper.narrow(
    super._this_object(orb));
  }


} // class BAInterfacePOA
