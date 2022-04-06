package Thread_ex;

class MyCustomThread2 extends Thread{
	
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println( i + " : " + Thread.currentThread() );
		}
	}
}


public class ThreadTest3 {
	
	public static void main(String[] args) {
		//  priority : 우선 순위 : 0 ~ 10 > 우선 순위를 넣더라고 큰 차이가 별로 없다
		System.out.println(Thread.currentThread());
		MyCustomThread2 thread1 = new MyCustomThread2();
		MyCustomThread2 thread2 = new MyCustomThread2();
		MyCustomThread2 thread3 = new MyCustomThread2();
		thread1.start();
		thread2.start();
		thread3.start();
		
	}
	
}
