package BAPkg;

/**
* BAPkg/ZeroDivisorExceptionHolder.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从Ba.idl
* 2017年5月21日 星期日 下午03时49分05秒 CST
*/

public final class ZeroDivisorExceptionHolder implements org.omg.CORBA.portable.Streamable
{
  public BAPkg.ZeroDivisorException value = null;

  public ZeroDivisorExceptionHolder ()
  {
  }

  public ZeroDivisorExceptionHolder (BAPkg.ZeroDivisorException initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = BAPkg.ZeroDivisorExceptionHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    BAPkg.ZeroDivisorExceptionHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return BAPkg.ZeroDivisorExceptionHelper.type ();
  }

}
