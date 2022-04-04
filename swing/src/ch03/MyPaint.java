package ch03;

import java.awt.Graphics;

import javax.swing.*;

class MyPanel extends JPanel{
	
	@Override
	public void paint(Graphics g) {
		super.paint(g); // 이거 지우면 동작 안함
		g.drawString("집을 그려보자", 50, 50);
		g.drawLine(20, 30, 100, 100);
		g.drawRect(100, 100, 150, 150);
	}
	
}

public class MyPaint extends JFrame{
	
	private MyPanel myPanel;
	
	public MyPaint() {
		initData();
		setinitLayout();
	}
	
	private void initData() {
		setTitle("직접 그려보기 연습");
		setSize(800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myPanel = new MyPanel();
	}
	
	private void setinitLayout() {
		setVisible(true);
		add(myPanel);
		
	}
	
	public static void main(String[] args) {
		new MyPaint();
	}
	

}
