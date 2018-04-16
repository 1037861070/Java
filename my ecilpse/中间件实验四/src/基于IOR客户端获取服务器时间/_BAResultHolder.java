package 基于IOR客户端获取服务器时间;

/**
* BAPkg/_BAResultHolder.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从Time.idl
* 2017年5月21日 星期日 下午07时12分30秒 CST
*/

public final class _BAResultHolder implements org.omg.CORBA.portable.Streamable
{
  public 基于IOR客户端获取服务器时间._BAResult value = null;

  public _BAResultHolder ()
  {
  }

  public _BAResultHolder (基于IOR客户端获取服务器时间._BAResult initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = 基于IOR客户端获取服务器时间._BAResultHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    基于IOR客户端获取服务器时间._BAResultHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return 基于IOR客户端获取服务器时间._BAResultHelper.type ();
  }

}
