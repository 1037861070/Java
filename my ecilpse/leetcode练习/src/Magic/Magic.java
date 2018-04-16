package Magic;

import java.util.Scanner;

class ways{
	ways(){}
	public String method(int n){
		StringBuffer arrBuffer=new StringBuffer();
		if (n%2==0) {
			arrBuffer.append('2');
			//arrBuffer.append('1');
		}
		else {
			arrBuffer.append('1');
			arrBuffer.append('2');
		}
		return arrBuffer.toString();
	}
	
}
public class Magic {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner scanner = new Scanner(System.in);
		System.out.println("输入你需要的魔法币：");
		int n = scanner.nextInt();
		ways way=new ways();
		System.out.println("" + way.method(n));
	}

}
