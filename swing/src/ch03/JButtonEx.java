package ch03;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JButtonEx extends JFrame {
	private JPanel jPanel;
	private JButton button;
	
	public JButtonEx() {
		initData();
		setinitLayout();
	}
	
	public void initData() {
		setTitle("button action");
		setSize(300, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jPanel = new JPanel();
		jPanel.setBackground(Color.orange);
		
		
	}
	
	public void setinitLayout() {
		setLayout(new FlowLayout());
		
	}
}
