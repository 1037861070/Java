package test_thread;


public class Test_runnable implements Runnable{
	   private int i;
	   public  void run(){
		   for(;i<50;i++){
			   System.out.println(Thread.currentThread().getName()+" "+i);
		   }
	   }
	   public static void main(String args[]){
		   for(int i=0;i<50;i++){
			   System.out.println(Thread.currentThread().getName()+" "+i);
			   if(i==10){
				   Test_thread t1=new Test_thread();
				  Test_thread t2=new Test_thread();
				   new Thread(t1,"线程1").start();
				   new Thread(t2,"线程2").start();
			
			   }
		   }
	   }
	}
