package Testinterface;
import java.util.*;
public class Testinterface1 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
    Scanner input=new Scanner(System.in);
    System.out.println("����������������");
    int a=input.nextInt();
    int b=input.nextInt();
    inter1 B=new inter1(a,b);
    B.sub();
   System.out.println("����֮��Ϊ��"+B.result());
   Interface.A A1=new Interface().new A(a);//�Ǿ�̬�ڲ��ഴ��ʵ���ķ���
   A1.add(b);//a-b
   System.out.println("����֮��Ϊ��"+A1.result1());
   System.out.println(Interface.B.D());//�����̬�ڲ����еľ�̬����
   System.out.println(inter.mAX);//����ӿ��г���
	}

}
