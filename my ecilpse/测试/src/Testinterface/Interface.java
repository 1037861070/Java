package Testinterface;

public class Interface {
private int a=5;
private static int d=10;
public class A{
	int b;
	A(){}
	A(int b){
		this.b=b;
	}
	public void add(int c){
		this.b=c+b;
	}
	public int result1(){
		return this.b;
	}
}
public static class B{
	B(){}
	static public int D(){
		return Interface.d;
	}
}
}

interface inter {
	int mAX=20;
	public void sub();
}
class inter1 extends Interface implements inter{

	private int a1;
	private int b1;
	inter1(){}
	inter1(int a1,int b1){
		this.a1=a1;
		this.b1=b1;
		
	}
	public void sub() {
		this.a1-=b1;
	}
	public int result(){
		return this.a1;
	}
}
