package test_thread;

public class Test_thread extends Thread{

	
	public Test_thread(String name) {
		// TODO �Զ����ɵĹ��캯�����
		super(name);
	}
    public Test_thread() {
		// TODO �Զ����ɵĹ��캯�����
	}
	public void run(){
    	for(int i=0;i<50;i++){
    		System.out.println(getName()+" "+i);
    	}
    }
	public static void main(String[] args) throws InterruptedException {
		// TODO �Զ����ɵķ������
		Test_thread t1=new Test_thread("���߳�1");
		t1.start();
			for(int i=0;i<50;i++){
			if (i==20) {
				new Test_thread("���߳�2").start();
				new Test_thread("���߳�3").start();
			}
			t1.join();//�ȴ�t1�߳����������������߳�
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
      
	}

}
