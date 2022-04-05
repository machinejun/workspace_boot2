package ch05;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

//마우스 어뎁터 클래스를 사용해 보자
public class MyFrameEx6 extends JFrame{
	public MyFrameEx6() {
		
		
		initData();
		setInitLayout();
		addEventListener();
	}
	private void initData() {
		setTitle("어뎁터 클래스 사용");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		
	}
	private void setInitLayout() {
		setVisible(true);
		
	}
	
	private void addEventListener() {
		/* 
		 * - 이벤트를 등록하는 법
		 * 1. 클래스 구현방법( 많을 때)
		 * 2. 익명 구현 객체( 1 ~ 2개 일때)
		 * 3. 내부 클래스를 정의해서 오버라이드를 활용 ( 인터페이스 메소드 중 필요한것만 써야할때)
		 */
		
		this.addMouseListener(new MyCustomMouseListener());
	}
	
	// 내부 클래스 활용
	private class MyCustomMouseListener extends MouseAdapter{
		
		@Override
		public void mouseClicked(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			System.out.println("x : " + x);
			System.out.println("y : " + y);
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			System.out.println("마우스 인");
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			System.out.println("마우스 아웃");
		}
	}
	
	public static void main(String[] args) {
		new MyFrameEx6();
	}
}
