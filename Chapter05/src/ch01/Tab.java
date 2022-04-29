package ch01;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class Tab extends JFrame{
	JTabbedPane tab = new JTabbedPane();
	public Tab() {
		
		setVisible(true);
		setSize(500 , 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tab.add("tab1", new JTextArea());
		tab.add("tab2", new JTextArea());
		tab.add("tab3", new JTextArea());
		add(tab);
	}
	
	public static void main(String[] args) {
		new Tab();
	}
}
