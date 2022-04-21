package ch03.pratice;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

//callee
public class Activity1 extends BaseActivity{
	CallbackCheck callbackCheck;

	JButton button1;
	JButton button2;
	
	public Activity1(String name) {
		super(name);
		button1 = new JButton("true");
		button2 = new JButton("false");
		add(button1);
		add(button2);
		setLayout(new FlowLayout());
		addEventListener();
		
	}
	
	public void setCallbackCheck(CallbackCheck callbackCheck) {
		this.callbackCheck = callbackCheck;
	}



	private void addEventListener() {
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				callbackCheck.checkButton("true"); // callbackcheck가 널이다.
				
			}
		});
		
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				callbackCheck.checkButton("false");
				
			}
		});
	}
	
}
