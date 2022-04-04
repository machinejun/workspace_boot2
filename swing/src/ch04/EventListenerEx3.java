package ch04;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class EventListenerEx3 extends JFrame{
	
	private JButton button1;
	private JButton button2;
	
	public EventListenerEx3() {
		initDate();
		setInitLayout();
		addEventListener();
	}
	
	private void initDate() {
		setTitle("익명 구현 객체에 이해");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button1 = new JButton("button1");
		button2 = new JButton("button2");
		
		add(button1, "Center");
		add(button2, "Center");
	}
	
	private void setInitLayout() {
		setVisible(true);
		setLayout(new FlowLayout());
	}
	
	private void addEventListener() {
		// 익명 구현 객체 사용법 !!
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼1이 클릭됨");
			}
		});
		
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼2이 클릭됨");
			}
		});
	}
	
	public static void main(String[] args) {
		//익명 클래스
		new EventListenerEx3();
		// EventListenerEx3 listenerEx3 = new EventListenerEx3();
	}

}
