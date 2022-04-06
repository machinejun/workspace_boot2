package Thread_ex;

// 1번째 방법 : 다른 작업자를 생성하는 방법(상속) -> run이라는 메서드를 구현하였습니다.
class MyCustomThread extends Thread {
	String name;
	
	public MyCustomThread(String name) {
		this.name = name;
	}
	// 쓰레드는 약속되어 있습니다.
	@Override
	public void run() {
		// 쓰레드에서 구현해 놨음 -> 다시 재정의
		// run 이라는 메서드는 쓰레드가 동작을 명령받으면 동작을 수행하는 코드 영역이다.
		
		int i ;
		for(i = 0; i < 50 ; i++) {
			System.out.println(name + " : " + i);
			try {
				Thread.sleep(300);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
}


public class ThreadTest2 {
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread()); 
		System.out.println("메인 쓰레드 시작");
		// 작업자 만들기
		MyCustomThread thread1 = new MyCustomThread("서브 작업자1");
		MyCustomThread thread2 = new MyCustomThread("서브 작업자2");
		MyCustomThread thread3 = new MyCustomThread("서브 작업자3");
		// 쓰레드를 시작하는 방법 > start 라는 메서드를 사용하지 않으면 작동 안함
		// 작업 수행을 순서대로 호출 하더라도 실제 작업은 랜덤으로 진행된다.
		thread1.start();
		thread2.start();
		thread3.start();
		
		
		System.out.println("메인 쓰레드 종료");
	}
}
