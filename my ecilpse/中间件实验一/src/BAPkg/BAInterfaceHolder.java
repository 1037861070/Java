package BAPkg;

/**
* BAPkg/BAInterfaceHolder.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��Ba.idl
* 2017��5��21�� ������ ����03ʱ49��05�� CST
*/

public final class BAInterfaceHolder implements org.omg.CORBA.portable.Streamable
{
  public BAPkg.BAInterface value = null;

  public BAInterfaceHolder ()
  {
  }

  public BAInterfaceHolder (BAPkg.BAInterface initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = BAPkg.BAInterfaceHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    BAPkg.BAInterfaceHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return BAPkg.BAInterfaceHelper.type ();
  }

}
