package Thread_ex;

import java.util.Iterator;

import javax.swing.JFrame;

// runnable 인터페이스를 구현해서 만들기 - 2번쨰
// 자바는 다중 상속이 허용되지 않으므로 다른 클래스를 상속한 경우
// thread를 만들기 위해서 runnable interface를 구현하도록 합니다.

class MyRunnable1 extends JFrame implements Runnable{
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("➳");
		}
		
	}
}

public class RunableTest1 {

	public static void main(String[] args) {
		// 사용 방법
		MyRunnable1 runnable1 = new MyRunnable1();
		// Runnable 구현한 객체는 Thread를 생성해서 매개 변수에 담고 쓰레드를 시작하면 된다.
		Thread thread = new Thread(runnable1);
		thread.start();
	}
}


