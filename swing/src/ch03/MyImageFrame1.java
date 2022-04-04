package ch03;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class MyImageFrame1 extends JFrame{
	
	public MyImageFrame1() {
		initData();
		setInitData();
	}
	
	private void initData() {
		setTitle("jpanel에 이미지 넣기");
		setSize(800, 600);

	}
	
	private void setInitData() {
		setVisible(true);
		add(new ImagePanel());
		
	}
	public static void main(String[] args) {
		new MyImageFrame1();
	}
	
	private class ImagePanel extends JPanel{
		
		private Image image;
		
		public ImagePanel() {
			image = new ImageIcon("image1.jpg").getImage();
		}
		
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		}
	}
}
