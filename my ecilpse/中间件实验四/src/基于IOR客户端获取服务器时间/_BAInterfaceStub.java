package 基于IOR客户端获取服务器时间;


/**
* BAPkg/_BAInterfaceStub.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从Time.idl
* 2017年5月21日 星期日 下午07时12分30秒 CST
*/

public class _BAInterfaceStub extends org.omg.CORBA.portable.ObjectImpl implements 基于IOR客户端获取服务器时间.BAInterface
{

  public void BACalculation (基于IOR客户端获取服务器时间._BAResultHolder result)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("BACalculation", true);
                $in = _invoke ($out);
                result.value = 基于IOR客户端获取服务器时间.BAResultHelper.read ($in);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                BACalculation (result        );
            } finally {
                _releaseReply ($in);
            }
  } // BACalculation

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:BAPkg/BAInterface:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _BAInterfaceStub
