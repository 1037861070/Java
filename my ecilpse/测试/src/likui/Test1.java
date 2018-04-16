package likui;

public class Test1 {
public static int math=250;
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int b;
		b=(int)(Math.random()*100);
     System.out.println(Test1.math);
     Test2 t2=new Test2(518,"I Love You!");
     Test3 t3=new Test3(b,"I Hate You!",1312);
     t2.add();
     t3.sub();
     System.out.println(t2.input());
     System.out.println(t3.input1());
	}

}
