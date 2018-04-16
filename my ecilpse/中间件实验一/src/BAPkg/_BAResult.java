package BAPkg;


/**
* BAPkg/_BAResult.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从Ba.idl
* 2017年5月21日 星期日 下午03时49分05秒 CST
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
