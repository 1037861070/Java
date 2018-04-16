package test_thread;

public class Test_thread extends Thread{

	
	public Test_thread(String name) {
		// TODO 自动生成的构造函数存根
		super(name);
	}
    public Test_thread() {
		// TODO 自动生成的构造函数存根
	}
	public void run(){
    	for(int i=0;i<50;i++){
    		System.out.println(getName()+" "+i);
    	}
    }
	public static void main(String[] args) throws InterruptedException {
		// TODO 自动生成的方法存根
		Test_thread t1=new Test_thread("子线程1");
		t1.start();
			for(int i=0;i<50;i++){
			if (i==20) {
				new Test_thread("子线程2").start();
				new Test_thread("子线程3").start();
			}
			t1.join();//等待t1线程运行完再启动主线程
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
      
	}

}
