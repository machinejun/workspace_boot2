package ch03;


import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;


public class MyHouseFrame extends JFrame{ // 외부 클래스
	HousePanel housePanel;
	
	public MyHouseFrame() {
		initData();
		setinitLayout();
	}
	
	private void initData() {
		setTitle("집 그리기");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		housePanel = new HousePanel();
		
	}
	
	private void setinitLayout() {
		setVisible(true);
		housePanel.setBackground(Color.green);
		housePanel.setBounds(25, 25, 50, 50);
		add(housePanel);
	}
	
	public static void main(String[] args) {
		new MyHouseFrame();	
	}
	
	private class HousePanel extends JPanel{  // 내부 클래스  -> 클래스 안에 클래스를 작성하는 문법
		
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawRect(150, 200, 300, 200);
			g.drawLine(150, 200, 150+150, 100);
			g.drawLine(150+300, 200, 150+150, 100);
			g.drawRect(150+200, 200+20, 80, 80);
			g.drawLine(150+200, 200+20+40, 150+200+80, 200+20+40);
			g.drawLine(150+200+40, 200+20, 150+200+40, 200+20+80);
		}
	} // end of inner class
} // end of class
