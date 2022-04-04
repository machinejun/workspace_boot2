package ch04;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TwoButtonEx1 extends JFrame implements ActionListener{
	JPanel panel1;
	JPanel panel2;
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	Image image;
	
	public TwoButtonEx1() {
		image = new ImageIcon("image1.jpg").getImage();
		initData();
		setInitLayout();
		addEventListener();
	}
	
	public void initData() {
		setTitle("두개의 버튼 테스트");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel1 = new JPanel();
		panel2 = new JPanel();
		button1 = new JButton("버튼(RED)");
		button2 = new JButton("버튼(BLUE)");
		button3 = new JButton("버튼(YELLOW)");
		button4 = new JButton("버튼(PINK)");
	}
	
	public void setInitLayout() {
		setVisible(true);
		setLayout(new GridLayout(2,1));
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER,30, 20));
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER,30, 20));
		add(panel1);
		add(panel2);
		panel1.add(button1);
		panel1.add(button2);
		panel2.add(button3);
		panel2.add(button4);
	}
	
	public void addEventListener() {
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button1) {
			panel1.setBackground(Color.red);
		}else if (e.getSource() == button2) {
			panel1.setBackground(Color.blue);
		}else if(e.getSource() == button3) {
			panel2.setBackground(Color.yellow);
		}else if(e.getSource() == button4) {
			panel2.setBackground(Color.pink);
		}
		
	}
	public static void main(String[] args) {
		new TwoButtonEx1();
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this.panel1);
		super.paint(g);
	};
	

}
