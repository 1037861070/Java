package BAPkg;

/**
* BAPkg/ZeroDivisorExceptionHolder.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��Ba.idl
* 2017��5��21�� ������ ����03ʱ49��05�� CST
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
