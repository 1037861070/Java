package 基于IOR客户端获取服务器时间;


/**
* BAPkg/BAInterfaceHelper.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从Time.idl
* 2017年5月21日 星期日 下午07时12分30秒 CST
*/

abstract public class BAInterfaceHelper
{
  private static String  _id = "IDL:BAPkg/BAInterface:1.0";

  public static void insert (org.omg.CORBA.Any a, 基于IOR客户端获取服务器时间.BAInterface that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static 基于IOR客户端获取服务器时间.BAInterface extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (基于IOR客户端获取服务器时间.BAInterfaceHelper.id (), "BAInterface");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static 基于IOR客户端获取服务器时间.BAInterface read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_BAInterfaceStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, 基于IOR客户端获取服务器时间.BAInterface value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static 基于IOR客户端获取服务器时间.BAInterface narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof 基于IOR客户端获取服务器时间.BAInterface)
      return (基于IOR客户端获取服务器时间.BAInterface)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      基于IOR客户端获取服务器时间._BAInterfaceStub stub = new 基于IOR客户端获取服务器时间._BAInterfaceStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static 基于IOR客户端获取服务器时间.BAInterface unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof 基于IOR客户端获取服务器时间.BAInterface)
      return (基于IOR客户端获取服务器时间.BAInterface)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      基于IOR客户端获取服务器时间._BAInterfaceStub stub = new 基于IOR客户端获取服务器时间._BAInterfaceStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
