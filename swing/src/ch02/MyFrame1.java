package ch02;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame1 extends JFrame {
	private BorderLayout borderLayout;
	private JButton[] buttons = new JButton[5];
	private String[] titles = { "북", "센터", "남", "동", "서" };
	private String[] driections = { 
			BorderLayout.NORTH, 
			BorderLayout.CENTER, 
			BorderLayout.SOUTH, 
			BorderLayout.EAST,
			BorderLayout.WEST };
	
	public MyFrame1() {
		initData();
		setInitLayout();
	}
	
	private void initData() {
		setTitle("BorderLayout Test");
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		borderLayout = new BorderLayout();
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(titles[i]);
		}
		
	}
	
	private void setInitLayout() {
		setLayout(borderLayout);
		for (int i = 0; i < buttons.length; i++) {
			add(buttons[i], driections[i]);
		}
		
	}
}

