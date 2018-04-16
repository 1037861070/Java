package BAPkg;


/**
* BAPkg/BAResultHelper.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��Ba.idl
* 2017��5��21�� ������ ����03ʱ49��05�� CST
*/

abstract public class BAResultHelper
{
  private static String  _id = "IDL:BAPkg/BAResult:1.0";

  public static void insert (org.omg.CORBA.Any a, BAPkg._BAResult that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static BAPkg._BAResult extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = BAPkg._BAResultHelper.type ();
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (BAPkg.BAResultHelper.id (), "BAResult", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static BAPkg._BAResult read (org.omg.CORBA.portable.InputStream istream)
  {
    BAPkg._BAResult value = null;
    value = BAPkg._BAResultHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, BAPkg._BAResult value)
  {
    BAPkg._BAResultHelper.write (ostream, value);
  }

}
