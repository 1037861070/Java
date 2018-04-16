package FSM测试用例;
import java.util.Scanner;
public class FSMtest {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
     int CLOSED=1,CLOSING=2,OPENED=3,OPENING=4;
     System.out.println("请输入当前状态");
     Scanner inputScanner=new Scanner(System.in);
   
	 int state=inputScanner.nextInt();
	 int count = 0;
do {
	count++;
	 switch (state) {
	case 1:
		state=4;
		System.out.println("当前状态为:CLOSED"+"转到：OPENING");
		break;
	case 2:
		state=1;
		System.out.println("当前状态为:CLOSING"+"转到：CLOSED");
		break;
	case 3:
		state=2;
		System.out.println("当前状态为:OPENED"+"转到：CLOSING");
		break;
	case 4:
		state=3;
		System.out.println("当前状态为:OPENING"+"转到：OPENED");
		break;
	default:
		break;
	}
} while (count < 5);
	}

}
