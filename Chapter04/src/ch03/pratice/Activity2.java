package ch03.pratice;

import javax.swing.JLabel;

public class Activity2 extends BaseActivity{
	
	JLabel label;
	CallbackCheck check = new CallbackCheck() {
		
		@Override
		public void checkButton(String str) {
			label = new JLabel(str);
			add(label);
			
		}
	};
	
	
	public Activity2(String name) {
		super(name);
		
	}

}
