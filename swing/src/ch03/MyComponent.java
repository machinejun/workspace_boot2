package ch03;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;

public class MyComponent extends JFrame{
	
	private JPanel jPanel;
	private JButton jButton;
	private JLabel jLabel;
	JTextField jTextField;
	private JPasswordField jPasswordField;
	private JCheckBox checkBox;
	
	public MyComponent() {
		initData();
		setInitLayout();
	}
	
	private void initData() {
		setTitle("컴포넌트 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 800);
			
		jPanel = new JPanel();
		
		Dimension dimension = new Dimension(600, 500);
		
		jPanel.setPreferredSize(dimension);
		jButton = new JButton("button");
		jLabel = new JLabel("라벨");
		jTextField = new JTextField("힌트", 20);
		jPasswordField = new JPasswordField("패스워드", 20);
		checkBox = new JCheckBox("check box", true);
	}
	
	private void setInitLayout() {
		setVisible(true);
		setLayout(new FlowLayout(FlowLayout.LEFT, 100, 200)); // 굳이 메모리에 할당할 필요가 없을 때
	
		add(jPanel);
		jPanel.setBackground(Color.GREEN);
		jPanel.add(jButton);
		jPanel.add(jLabel);
		jPanel.add(jTextField);
		jPanel.add(jPasswordField);
		jPanel.add(checkBox);
		
	}

	public void setjTextField(JTextField jTextField) {
		this.jTextField = jTextField;
	}
	
	
	
}
