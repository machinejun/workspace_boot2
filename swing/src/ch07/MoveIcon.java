package ch07;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MoveIcon extends JFrame implements KeyListener{
	
	private BufferedImage bgImage;
	private BufferedImage imgIcon;
	private ImagePanel imagePanel ;
	private String bgImageUrl = "image1.jpg";
	private String imgIconUrl = "icon2.png";
	
	int xPoint = 200;
	int yPoint = 200;
	// 1. 내부 클래스 만들기
	
	public MoveIcon() {
		initData();
		setInitLayout();
		addEventListener();
	}
	
	private void initData() {
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 이미지를 그리기 위해서는 메모리에 올려야함
		try {
			bgImage = ImageIO.read(new File(bgImageUrl));
			imgIcon = ImageIO.read(new File(imgIconUrl));
		} catch (IOException e) {
			System.out.println("파일 없습니다.");
			//System.exit(0); // 0 을 누르면 종료합니다.
		}
		imagePanel = new ImagePanel();
	}
	
	private void setInitLayout() {
		setVisible(true);
		setResizable(false);
		add(imagePanel);
	}
	
	private void addEventListener() {
		this.addKeyListener(this);
	}
	
	private class ImagePanel extends JPanel{
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), null);
			g.drawImage(imgIcon, xPoint, yPoint, 100, 100, null);
			
			
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_UP) {
			//yPoint -= 10;
			yPoint = (yPoint < 0) ? 0 : yPoint -10; 
		}else if(keyCode == KeyEvent.VK_DOWN) {
			//yPoint += 10;
			yPoint = (yPoint > 380) ? 380 : yPoint +10; 

		}else if(keyCode == KeyEvent.VK_RIGHT) {
			//xPoint += 10;
			xPoint = (xPoint > 420) ? 420 : xPoint +10;

		}else if(keyCode == KeyEvent.VK_LEFT) {
			//xPoint -= 10;
			xPoint = (xPoint < 0) ? 0 : xPoint -10; 
		}
		
		repaint();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		new MoveIcon();
	}
	
	
}
