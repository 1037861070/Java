package BAPkg;


/**
* BAPkg/_BAResult.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��Ba.idl
* 2017��5��21�� ������ ����03ʱ49��05�� CST
*/

public final class _BAResult implements org.omg.CORBA.portable.IDLEntity
{
  public int sum = (int)0;
  public int minus = (int)0;
  public int product = (int)0;
  public int quotient = (int)0;

  public _BAResult ()
  {
  } // ctor

  public _BAResult (int _sum, int _minus, int _product, int _quotient)
  {
    sum = _sum;
    minus = _minus;
    product = _product;
    quotient = _quotient;
  } // ctor

} // class _BAResult
