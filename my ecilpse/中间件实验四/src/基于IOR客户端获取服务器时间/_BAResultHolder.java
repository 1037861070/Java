package ����IOR�ͻ��˻�ȡ������ʱ��;

/**
* BAPkg/_BAResultHolder.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��Time.idl
* 2017��5��21�� ������ ����07ʱ12��30�� CST
*/

public final class _BAResultHolder implements org.omg.CORBA.portable.Streamable
{
  public ����IOR�ͻ��˻�ȡ������ʱ��._BAResult value = null;

  public _BAResultHolder ()
  {
  }

  public _BAResultHolder (����IOR�ͻ��˻�ȡ������ʱ��._BAResult initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ����IOR�ͻ��˻�ȡ������ʱ��._BAResultHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    ����IOR�ͻ��˻�ȡ������ʱ��._BAResultHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return ����IOR�ͻ��˻�ȡ������ʱ��._BAResultHelper.type ();
  }

}
