package 基于IOR客户端获取服务器时间;

import java.util.Date;

public class BAImpl extends BAInterfacePOA{

	@Override
	public void BACalculation(_BAResultHolder result) {
		// TODO 自动生成的方法存根
		Date date = new Date();
		
		String time = date.toString();
		
		_BAResult res = new _BAResult();
		
		res.time = time;
		result.value = res;
	}
	
}