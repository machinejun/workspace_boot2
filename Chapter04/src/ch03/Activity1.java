package ch03;

import java.awt.Color;


/*
 * caller(호출자)
 * 콜러는 콜백 인터페이스를 멤버 변수로 가지고 있다.
 */

public class Activity1 extends BaseActivity{
	//콜백 메서드
	CallbackCheckPosition CheckPosition = new CallbackCheckPosition() {
		
		@Override
		public void checkPosition(int x, int y) {
			System.out.println(name);
			System.out.println(name + "가 호출을 받았습니다.");
			System.out.println("x : " + x + "y : " + y);
			
		}
	};

	public Activity1(String name) {
		super(name);
		
	}
	
	@Override // 주석 but compiler가 무시하지 않는다.(체킹하는 용도)
	protected void initDate() {
		super.initDate();
	}
	
	@Override
	protected void setInitLayout() {
		super.setInitLayout();
		panel.setBackground(Color.blue);
	}

}
