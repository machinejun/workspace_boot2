package ch05;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MyFrameEx7 extends JFrame implements KeyListener{

	private JTextArea textArea;

	
	public MyFrameEx7() {
		initData();
		setInitLayout();
		addEventListener();
	}
	
	private void initData() {
		setTitle("키 이벤트 연습");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textArea = new JTextArea();
	}
	
	private void setInitLayout() {
		setVisible(true);
		add(textArea);
	}
	private void addEventListener() {
		textArea.addKeyListener(this);
	}
	

	
	@Override
	// 문자 키에만 반응
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	// 키보드를 눌렀을 때 반응
	public void keyPressed(KeyEvent e) {
//		char c = e.getKeyChar();
//		int keyCode = e.getKeyCode();
//		textArea.append("\n" + "c : " + c + "\n" +"keyCode : " + keyCode);
//		System.out.println("c : " + c);
//		System.out.println("keyCode : " + keyCode);
		/*
		 *  도전과제
		 *  textArea에 키보드 그리고 캐릭터 c 값을  
		 */
		// 콘솔창에 왼쪽 화살표, 오른쪽 구분해서 콘솔창에 찍어주어라
		switch(e.getKeyCode()){
			case KeyEvent.VK_UP :
				System.out.println("up");
				break;
			case KeyEvent.VK_DOWN :
				System.out.println("down");
				break;
			case KeyEvent.VK_RIGHT :
				System.out.println("right");
				break;
			case KeyEvent.VK_LEFT :
				System.out.println("left");
				break;
			default :
				System.out.println(e.getKeyChar());
		}

	}
	@Override
	// 키보드를 눌렀다 땟을 때 반응
	public void keyReleased(KeyEvent e) {
		
		
	}
	
	public static void main(String[] args) {
		new MyFrameEx7();
	}
}
