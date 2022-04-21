package ch03;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*
 * callee(피호출자)
 * 콜리는 어떠한 이벤트가 발생 하였을 때  >>> 콜백 메서드를 호출한다 ???
 * 그럼 콜러가 
 */
public class Activity2 extends BaseActivity{
	
	CallbackCheckPosition callbackCheckPosition;
	

	public void setCallbackCheckPosition(CallbackCheckPosition callbackCheckPosition) {
		this.callbackCheckPosition = callbackCheckPosition;
	}

	public Activity2(String name) {
		super(name);
		addEventListener();
		
	}
	
	private void addEventListener() {
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				callbackCheckPosition.checkPosition(x, y);
				
			}
		});
	}

}
