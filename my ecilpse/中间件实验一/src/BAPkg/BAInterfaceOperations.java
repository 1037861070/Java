package BAPkg;


/**
* BAPkg/BAInterfaceOperations.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��Ba.idl
* 2017��5��21�� ������ ����03ʱ49��05�� CST
*/

public interface BAInterfaceOperations 
{
  void BACalculation (int a, int b, BAPkg._BAResultHolder result) throws BAPkg.ZeroDivisorException;
} // interface BAInterfaceOperations
