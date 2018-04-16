package BAPkg;


/**
* BAPkg/_BAInterfaceStub.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从Ba.idl
* 2017年5月21日 星期日 下午03时49分05秒 CST
*/

public class _BAInterfaceStub extends org.omg.CORBA.portable.ObjectImpl implements BAPkg.BAInterface
{

  public void BACalculation (int a, int b, BAPkg._BAResultHolder result) throws BAPkg.ZeroDivisorException
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("BACalculation", true);
                $out.write_long (a);
                $out.write_long (b);
                $in = _invoke ($out);
                result.value = BAPkg.BAResultHelper.read ($in);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:BAPkg/ZeroDivisorException:1.0"))
                    throw BAPkg.ZeroDivisorExceptionHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                BACalculation (a, b, result        );
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
