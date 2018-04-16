package BAPkg;


/**
* BAPkg/ZeroDivisorException.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从Ba.idl
* 2017年5月21日 星期日 下午03时49分05秒 CST
*/

public final class ZeroDivisorException extends org.omg.CORBA.UserException
{

  public ZeroDivisorException ()
  {
    super(ZeroDivisorExceptionHelper.id());
  } // ctor


  public ZeroDivisorException (String $reason)
  {
    super(ZeroDivisorExceptionHelper.id() + "  " + $reason);
  } // ctor

} // class ZeroDivisorException
