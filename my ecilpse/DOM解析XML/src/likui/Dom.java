package likui;
import java.util.*;

public class Dom {

public static void main(String[] args) throws Exception {
		// TODO �Զ����ɵķ������
	int count;
	Ways ways=new Ways();
	Scanner scr=new Scanner(System.in);
	do {
		System.out.println("��ѡ����Ҫ���еĲ���:");
		System.out.println("1.��������ѧ���ĸ��Ƴɼ�");
		System.out.println("2.����һ��ѧ���ĸ��Ƴɼ�");
		System.out.println("3.���һ��ѧ�����Ƴɼ�");
		System.out.println("4.ɾ��һ��ѧ�����Ƴɼ�");
		System.out.println("5.�˳�");
		count=scr.nextInt();
		switch (count) {
		case 1:	ways.checkxml();
			break;
		case 2:	System.out.println("ѧ������:");
		   String name=scr.next();
			if (!ways.checkstudent(name)) {
				System.out.print("û�д�ѧ��!");
			}
			break;
		case 3:
			ways.insertxml();
			break;
		case 4:System.out.println("ѧ��������");
		String nameString=scr.next();
			if (!ways.deletexml(nameString)) {
				System.out.print("û�д�ѧ��!");
			}
			break;
		case 5:	
			break;
		default:
			break;
		}
		
	} while (count!=5); 
     }
}

