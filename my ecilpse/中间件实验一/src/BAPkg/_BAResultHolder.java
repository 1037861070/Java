package BAPkg;

/**
* BAPkg/_BAResultHolder.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��Ba.idl
* 2017��5��21�� ������ ����03ʱ49��05�� CST
*/

public final class _BAResultHolder implements org.omg.CORBA.portable.Streamable
{
  public BAPkg._BAResult value = null;

  public _BAResultHolder ()
  {
  }

  public _BAResultHolder (BAPkg._BAResult initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = BAPkg._BAResultHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    BAPkg._BAResultHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return BAPkg._BAResultHelper.type ();
  }

}
