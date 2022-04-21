package ch01;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/*
 * 호출자(콜리): 징검다리 역할을 하는 인터페이스를 먼저 멤버 변수로 선언한다.
 */
public class SubActivity extends JFrame{
	JButton button;
	JButton button1;
	JButton submit;
	
	int result = 999;
	ICallBackBtnAction callBackBtnAction;
	
	public SubActivity(ICallBackBtnAction iCallBackBtnAction) {
		this.callBackBtnAction = iCallBackBtnAction;
		//callBackBtnAction.clickedAddBtn(); // 하지만 new하지 않았음 >>> nullpointException
		setSize(300, 300);
		setLayout(new GridLayout(3,1));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		button = new JButton("더하기 버튼");
		button1 = new JButton("마이너스 버튼");
		submit = new JButton("submit");
		add(button);
		add(button1);
		add(submit);
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				callBackBtnAction.clickedMinusBtn();
				
			}
		});
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("더하기 버튼 클릭!!!!");
				callBackBtnAction.clickedAddBtn();
			}
		});
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				callBackBtnAction.giveBtn(result);
				
				
			}
		});
		
	}
}
