package Thread_ex;

import javax.swing.JFrame;

class MyRunable3 extends JFrame {
	int grade;
	// Java 문법 -> 내부 익명 구현 객체를 변수에 담기
	Runnable runnable = new Runnable() {  
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println("->");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO: handle exception
				}
			}
			
		}
	};
	
	// 생성자
	public MyRunable3() {
	}
}



public class RunableTest2 {
	
	public static void main(String[] args) {
		MyRunable3 runable3 = new MyRunable3();

	}
}
