package ch03;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyTowPanel extends JFrame{
	
	private JPanel jPanel;
	private JPanel jPanel2;
	
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private Button button5;
	
	public MyTowPanel() {
		initData();
		setInitLayout();
	}
	
	private void initData() {
		setTitle("패널연습");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jPanel = new JPanel();
		jPanel.setBackground(Color.yellow);
		
		
		jPanel2 = new JPanel();
		jPanel2.setBackground(Color.blue);
		
		
		button1 =new Button("button1");
		button2 =new Button("button2");
		button3 =new Button("button3");
		button4 =new Button("button4");
		button5 =new Button("button5");
		
	}
	
	private void setInitLayout() {
		setVisible(true);
		setLayout(new GridLayout(2,1));
		add(jPanel);
		add(jPanel2);
		jPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		jPanel2.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		jPanel.add(button1);
		jPanel.add(button2);
		jPanel.add(button3);
		
		jPanel2.add(button4);
		jPanel2.add(button5);
		
	}
	
	public static void main(String[] args) {
		new MyTowPanel();
	}
}
