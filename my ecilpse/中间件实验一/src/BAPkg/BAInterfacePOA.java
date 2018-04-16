package BAPkg;


/**
* BAPkg/BAInterfacePOA.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从Ba.idl
* 2017年5月21日 星期日 下午03时49分05秒 CST
*/

public abstract class BAInterfacePOA extends org.omg.PortableServer.Servant
 implements BAPkg.BAInterfaceOperations, org.omg.CORBA.portable.InvokeHandler
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
         try {
           int a = in.read_long ();
           int b = in.read_long ();
           BAPkg._BAResultHolder result = new BAPkg._BAResultHolder ();
           this.BACalculation (a, b, result);
           out = $rh.createReply();
           BAPkg.BAResultHelper.write (out, result.value);
         } catch (BAPkg.ZeroDivisorException $ex) {
           out = $rh.createExceptionReply ();
           BAPkg.ZeroDivisorExceptionHelper.write (out, $ex);
         }
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
