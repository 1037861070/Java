package ����IOR�ͻ��˻�ȡ������ʱ��;


/**
* BAPkg/BAInterfaceHelper.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��Time.idl
* 2017��5��21�� ������ ����07ʱ12��30�� CST
*/

abstract public class BAInterfaceHelper
{
  private static String  _id = "IDL:BAPkg/BAInterface:1.0";

  public static void insert (org.omg.CORBA.Any a, ����IOR�ͻ��˻�ȡ������ʱ��.BAInterface that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static ����IOR�ͻ��˻�ȡ������ʱ��.BAInterface extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (����IOR�ͻ��˻�ȡ������ʱ��.BAInterfaceHelper.id (), "BAInterface");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static ����IOR�ͻ��˻�ȡ������ʱ��.BAInterface read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_BAInterfaceStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, ����IOR�ͻ��˻�ȡ������ʱ��.BAInterface value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static ����IOR�ͻ��˻�ȡ������ʱ��.BAInterface narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof ����IOR�ͻ��˻�ȡ������ʱ��.BAInterface)
      return (����IOR�ͻ��˻�ȡ������ʱ��.BAInterface)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      ����IOR�ͻ��˻�ȡ������ʱ��._BAInterfaceStub stub = new ����IOR�ͻ��˻�ȡ������ʱ��._BAInterfaceStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static ����IOR�ͻ��˻�ȡ������ʱ��.BAInterface unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof ����IOR�ͻ��˻�ȡ������ʱ��.BAInterface)
      return (����IOR�ͻ��˻�ȡ������ʱ��.BAInterface)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      ����IOR�ͻ��˻�ȡ������ʱ��._BAInterfaceStub stub = new ����IOR�ͻ��˻�ȡ������ʱ��._BAInterfaceStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
