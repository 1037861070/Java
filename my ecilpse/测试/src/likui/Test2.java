package likui;

public class Test2 {
private int a;
private String li="hello";
Test2(){}
Test2(int a,String li){
	this.a=a;
	li.equals(this.li);
	System.out.println(a+"  "+li);
}
void add(){
	this.a+=2;
}
int input(){
	return this.a;
}
}

class Test3 extends Test2{
	private int b;
	Test3(int a,String li,int b){
		super(a,li);
		this.b=b;
		System.out.println(a+"   "+li);
	}
	void sub(){
		this.b-=2;
	}
	int input1(){
		return this.b;
	}
}