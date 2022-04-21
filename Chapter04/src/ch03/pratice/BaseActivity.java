package ch03.pratice;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BaseActivity extends JFrame{
	String name;
	JPanel panel;
	
	public BaseActivity(String name) {
		this.name = name;
		initData();
		setInitLayout();
	}

	private void setInitLayout() {
		setVisible(true);
		add(panel);
		
	}

	private void initData() {
		setTitle("name");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		
	}

}
