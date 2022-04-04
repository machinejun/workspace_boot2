package ch04;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class EventListenerEx2 extends JFrame implements ActionListener{
	JButton button1;
	JButton button2;
	
	public EventListenerEx2() {
		initData();
		setInitLayout();
		addEventListener();
	}
	
	public void initData() {
		setTitle("이벤트 리스너2");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button1 = new JButton("버튼1");
		button2 = new JButton("버튼2");
	}
	
	public void setInitLayout() {
		setVisible(true);
		setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		add(button1);
		add(button2);
	}
	
	public void addEventListener() {
		button1.addActionListener(this);
		button2.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 1번 방법
		
//		if(e.getActionCommand().equals(button1.getText())) {
//			System.out.println("버튼 1이 클릭되었습니다.");
//		}else {
//			System.out.println("버튼 2가 클릭되었습니다.");
//		}
		
		//2 번 방법
		
		JButton jbutton = (JButton) e.getSource(); // 넘어오는 오브젝트가 Jbutton
		if(jbutton.getText().equals(this.button1.getText())) {
			System.out.println(button1.getText() + "가 클릭되었습니다.");
		}else {
			System.out.println(button2.getText() + "가 클릭되었습니다.");
		}
		// 문제 1 > 버튼 1이 눌러졌는지 버튼 2가 눌러졌는지 구분해서 화면에 출력하세요
		
	}

}
