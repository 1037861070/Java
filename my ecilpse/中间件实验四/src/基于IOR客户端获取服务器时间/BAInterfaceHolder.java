package ����IOR�ͻ��˻�ȡ������ʱ��;

/**
* BAPkg/BAInterfaceHolder.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��Time.idl
* 2017��5��21�� ������ ����07ʱ12��30�� CST
*/

public final class BAInterfaceHolder implements org.omg.CORBA.portable.Streamable
{
  public ����IOR�ͻ��˻�ȡ������ʱ��.BAInterface value = null;

  public BAInterfaceHolder ()
  {
  }

  public BAInterfaceHolder (����IOR�ͻ��˻�ȡ������ʱ��.BAInterface initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ����IOR�ͻ��˻�ȡ������ʱ��.BAInterfaceHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    ����IOR�ͻ��˻�ȡ������ʱ��.BAInterfaceHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return ����IOR�ͻ��˻�ȡ������ʱ��.BAInterfaceHelper.type ();
  }

}
