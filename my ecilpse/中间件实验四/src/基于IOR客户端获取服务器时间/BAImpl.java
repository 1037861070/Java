package ����IOR�ͻ��˻�ȡ������ʱ��;

import java.util.Date;

public class BAImpl extends BAInterfacePOA{

	@Override
	public void BACalculation(_BAResultHolder result) {
		// TODO �Զ����ɵķ������
		Date date = new Date();
		
		String time = date.toString();
		
		_BAResult res = new _BAResult();
		
		res.time = time;
		result.value = res;
	}
	
}