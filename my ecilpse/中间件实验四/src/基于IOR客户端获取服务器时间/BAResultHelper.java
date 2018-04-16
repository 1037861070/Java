package 基于IOR客户端获取服务器时间;


/**
* BAPkg/BAResultHelper.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从Time.idl
* 2017年5月21日 星期日 下午07时12分30秒 CST
*/

abstract public class BAResultHelper
{
  private static String  _id = "IDL:BAPkg/BAResult:1.0";

  public static void insert (org.omg.CORBA.Any a, 基于IOR客户端获取服务器时间._BAResult that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static 基于IOR客户端获取服务器时间._BAResult extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = 基于IOR客户端获取服务器时间._BAResultHelper.type ();
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (基于IOR客户端获取服务器时间.BAResultHelper.id (), "BAResult", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static 基于IOR客户端获取服务器时间._BAResult read (org.omg.CORBA.portable.InputStream istream)
  {
    基于IOR客户端获取服务器时间._BAResult value = null;
    value = 基于IOR客户端获取服务器时间._BAResultHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, 基于IOR客户端获取服务器时间._BAResult value)
  {
    基于IOR客户端获取服务器时间._BAResultHelper.write (ostream, value);
  }

}
