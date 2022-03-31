package ch01;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame{
	
	public MyFrame() {
		super.setTitle("My Frame");
		super.setSize(500, 500);
		super.setVisible(true);
//		super.setDefaultCloseOperation(ABORT);
	}
	

	
	
	
	public static void main(String[] args) {
		//new MyFrame();
		String title = JOptionPane.showInputDialog("hello");
		System.out.println(title);
		
	}// end of main
}
