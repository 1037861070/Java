package FSM��������;
import java.util.Scanner;
public class FSMtest {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
     int CLOSED=1,CLOSING=2,OPENED=3,OPENING=4;
     System.out.println("�����뵱ǰ״̬");
     Scanner inputScanner=new Scanner(System.in);
   
	 int state=inputScanner.nextInt();
	 int count = 0;
do {
	count++;
	 switch (state) {
	case 1:
		state=4;
		System.out.println("��ǰ״̬Ϊ:CLOSED"+"ת����OPENING");
		break;
	case 2:
		state=1;
		System.out.println("��ǰ״̬Ϊ:CLOSING"+"ת����CLOSED");
		break;
	case 3:
		state=2;
		System.out.println("��ǰ״̬Ϊ:OPENED"+"ת����CLOSING");
		break;
	case 4:
		state=3;
		System.out.println("��ǰ״̬Ϊ:OPENING"+"ת����OPENED");
		break;
	default:
		break;
	}
} while (count < 5);
	}

}
