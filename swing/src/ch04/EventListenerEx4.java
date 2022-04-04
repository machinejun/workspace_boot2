package ch04;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class EventListenerEx4 extends JFrame implements MouseListener{
	private JLabel label;
	
	public EventListenerEx4() {
		initData();
		setInitLayout();
		addEventListener();
	}
	
	private void initData() {
		setTitle("마우스 이벤트");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label = new JLabel("hello java~~~~~~~~!");
	}
	
	private void setInitLayout() {
		setVisible(true);
		setLayout(null);
		add(label);
		label.setSize(100,50);
		label.setLocation(100, 100);
		label.setBorder(new LineBorder(Color.black, 1));
		
	}
	
	private void addEventListener() {
		this.addMouseListener(this);
	}
	
	// 마우스가 클릭 되었을 때 호출
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("x 좌표갑 : " + e.getX());
		System.out.println("y 좌표갑 : " + e.getY());
		
		System.out.println(label.getBounds());
		System.out.println("label width: " + label.getBounds().width);
		System.out.println("label height: " + label.getBounds().height);
		// 얘를 수정해서 정확성을 높히자
		
		label.setLocation(e.getX()  , e.getY());
	}
	// 마우스가 눌러졌을 때 호출
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	// 마우스가 눌렀다가 떨어졌을 때 호출
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	// 마우스가 어떤 영역 안으로 들어 왔을 때 호출
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	// 마우스가 어떤 영역 밖으로 나갔을 때 호출
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	//메인 함수
	public static void main(String[] args) {
		new EventListenerEx4();
	}//end of main
}
