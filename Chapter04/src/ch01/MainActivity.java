package ch01;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;


/*
 *  콜백을 받는 객체(응답자)
 *  : ICallBackBtnAction 인터페이스를 구현해서 정의하면 된다.
 *  콜리는 : 콜백 받는 객체의 주소값을 알고 있어야 메서드가 호출 되었다고 알릴 수 있다.
 *  
 */
public class MainActivity extends JFrame implements ICallBackBtnAction{
	int count;
	JLabel label;
	
	public MainActivity() {
		count = 0;
		label = new JLabel("count : " + count);
		setSize(300, 300);
		setLayout(new FlowLayout());
		setVisible(true);
		add(label);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		new SubActivity(this);
	}

	@Override
	public void clickedAddBtn() {
		System.out.println("+ 버튼에 콜백 받았습니다.");
		count++;
		
		
	}
	// - 버튼의 버튼의 동작을 받는 콜백 메서드 

	@Override
	public void clickedMinusBtn() {
		count--;
		
	}


	@Override
	public void giveBtn(int result) {
		label.setText("count : " + result);
		
	}
}
