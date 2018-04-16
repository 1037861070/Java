package BAPkg;

public class BAImpl extends BAInterfacePOA {
	public void BACalculation(int a, int b, _BAResultHolder result)
			throws ZeroDivisorException {

		_BAResult res = new _BAResult();
		res.sum = a + b;
		res.minus = a - b;
		res.product = a * b;
		if (b != 0)
			res.quotient = a / b;
		else
			throw new ZeroDivisorException("zero divisor");
		result.value = res;
	}
}
