package ch02;

import javax.swing.JButton;
import javax.swing.JFrame;

public class NoLayoutEx extends JFrame{
	private JButton button1;
	private JButton button2;
	private JButton button3;
	
	public NoLayoutEx() {
		initData();
		setinitLayout();
	}
	
	private void initData() {
		setTitle("No layout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		button1 = new JButton("1");
		button2 = new JButton("2");
		button3 = new JButton("3");

	}
	
	private void setinitLayout() {
		setVisible(true);
		setLayout(null);
		button1.setSize(50, 50);
		button1.setLocation(10, 10);
		
		button2.setSize(50, 50);
		button2.setLocation(60, 60);
		
		button3.setSize(50, 50);
		button3.setLocation(110, 110);
		
		add(button1);
		add(button2);
		add(button3);

	}
	
	public static void main(String[] args) {
		new NoLayoutEx();
	}
}
