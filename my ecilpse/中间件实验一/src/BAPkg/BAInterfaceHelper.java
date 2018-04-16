package BAPkg;


/**
* BAPkg/BAInterfaceHelper.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从Ba.idl
* 2017年5月21日 星期日 下午03时49分05秒 CST
*/

abstract public class BAInterfaceHelper
{
  private static String  _id = "IDL:BAPkg/BAInterface:1.0";

  public static void insert (org.omg.CORBA.Any a, BAPkg.BAInterface that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static BAPkg.BAInterface extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (BAPkg.BAInterfaceHelper.id (), "BAInterface");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static BAPkg.BAInterface read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_BAInterfaceStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, BAPkg.BAInterface value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static BAPkg.BAInterface narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof BAPkg.BAInterface)
      return (BAPkg.BAInterface)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      BAPkg._BAInterfaceStub stub = new BAPkg._BAInterfaceStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static BAPkg.BAInterface unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof BAPkg.BAInterface)
      return (BAPkg.BAInterface)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      BAPkg._BAInterfaceStub stub = new BAPkg._BAInterfaceStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
