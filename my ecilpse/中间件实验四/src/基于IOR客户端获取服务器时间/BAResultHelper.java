package ����IOR�ͻ��˻�ȡ������ʱ��;


/**
* BAPkg/BAResultHelper.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��Time.idl
* 2017��5��21�� ������ ����07ʱ12��30�� CST
*/

abstract public class BAResultHelper
{
  private static String  _id = "IDL:BAPkg/BAResult:1.0";

  public static void insert (org.omg.CORBA.Any a, ����IOR�ͻ��˻�ȡ������ʱ��._BAResult that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static ����IOR�ͻ��˻�ȡ������ʱ��._BAResult extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = ����IOR�ͻ��˻�ȡ������ʱ��._BAResultHelper.type ();
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (����IOR�ͻ��˻�ȡ������ʱ��.BAResultHelper.id (), "BAResult", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static ����IOR�ͻ��˻�ȡ������ʱ��._BAResult read (org.omg.CORBA.portable.InputStream istream)
  {
    ����IOR�ͻ��˻�ȡ������ʱ��._BAResult value = null;
    value = ����IOR�ͻ��˻�ȡ������ʱ��._BAResultHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, ����IOR�ͻ��˻�ȡ������ʱ��._BAResult value)
  {
    ����IOR�ͻ��˻�ȡ������ʱ��._BAResultHelper.write (ostream, value);
  }

}
