package BAPkg;


/**
* BAPkg/ZeroDivisorException.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��Ba.idl
* 2017��5��21�� ������ ����03ʱ49��05�� CST
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
