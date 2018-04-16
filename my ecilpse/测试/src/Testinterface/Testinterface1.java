package Testinterface;
import java.util.*;
public class Testinterface1 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
    Scanner input=new Scanner(System.in);
    System.out.println("请输入两个整数：");
    int a=input.nextInt();
    int b=input.nextInt();
    inter1 B=new inter1(a,b);
    B.sub();
   System.out.println("两数之差为："+B.result());
   Interface.A A1=new Interface().new A(a);//非静态内部类创建实例的方法
   A1.add(b);//a-b
   System.out.println("两数之和为："+A1.result1());
   System.out.println(Interface.B.D());//输出静态内部类中的静态方法
   System.out.println(inter.mAX);//输出接口中常量
	}

}
