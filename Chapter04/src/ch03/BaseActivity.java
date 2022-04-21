package ch03;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BaseActivity extends JFrame{
	String name;
	JPanel panel;
	
	public BaseActivity(String name) {
		this.name = name;
		initDate();
		setInitLayout();
	}

	protected void setInitLayout() {
		setVisible(true);
		add(panel);
		
	}

	protected void initDate() {
		setTitle(this.name);
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		
	}
}
