package ����IOR�ͻ��˻�ȡ������ʱ��;


/**
* BAPkg/_BAResultHelper.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��Time.idl
* 2017��5��21�� ������ ����07ʱ12��30�� CST
*/

abstract public class _BAResultHelper
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
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [1];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[0] = new org.omg.CORBA.StructMember (
            "time",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (����IOR�ͻ��˻�ȡ������ʱ��._BAResultHelper.id (), "BAResult", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static ����IOR�ͻ��˻�ȡ������ʱ��._BAResult read (org.omg.CORBA.portable.InputStream istream)
  {
    ����IOR�ͻ��˻�ȡ������ʱ��._BAResult value = new ����IOR�ͻ��˻�ȡ������ʱ��._BAResult ();
    value.time = istream.read_string ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, ����IOR�ͻ��˻�ȡ������ʱ��._BAResult value)
  {
    ostream.write_string (value.time);
  }

}
