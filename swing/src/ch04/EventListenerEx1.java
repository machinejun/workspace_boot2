package ch04;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class EventListenerEx1 extends JFrame implements ActionListener{
	private JButton button;
	
	public EventListenerEx1() {
		initData();
		setInitLayout();
		addEnventListener();
	}
	
	private void initData() {
		setTitle("evernt Listener 연습");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button = new JButton("button1");
	}
	
	private void setInitLayout() {
		setVisible(true);
		setLayout(new FlowLayout());
		add(button);
	}
	
	private void addEnventListener() {
		// 액션이 일어나면 나에게 알려줘  -> 이벤트를 등록 했다.
		// 등록하다.
		button.addActionListener(this);
	}
	
	//메서드가 호출 되어진다.
	//콜백 되어진다. -> callback method
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.toString());
		// actionPerformed 메서드를 통해서 동작을 처리할 꺼야
		System.out.println("버튼이 클릭되었습니다.");
		
	}
}
