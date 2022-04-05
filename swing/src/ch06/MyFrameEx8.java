package ch06;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;

import javax.imageio.ImageIO;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrameEx8 extends JFrame implements KeyListener{
	private BufferedImage bgImage;
	private BufferedImage imageIcon;
	private Imagelabel imagelabel;
	private String backgroundImage = "image1.jpg";
	private String iconImge = "icon2.png";
	private int x = 100;
	private int y = 100;

	// 내부 클래스 선언

	public MyFrameEx8() {
		initData();
		setInitLayout();
		addEventListener();
		
	}

	private void initData() {
		setTitle("이미지 움직이기");
		setSize(600, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			bgImage = ImageIO.read(new File(backgroundImage));
			imageIcon = ImageIO.read(new File(iconImge));

		} catch (IOException e) {
			System.out.println("파일이 없습니다.");
		}
		imagelabel = new Imagelabel();

	}

	private void setInitLayout() {
		setVisible(true);
		add(imagelabel);
	}

	public void addEventListener() {
		addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			System.out.println("up");
			y -= 10;			
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("down");
			y += 10;
			break;
		case KeyEvent.VK_RIGHT:
			System.out.println("right");
			x += 10;
			break;
		case KeyEvent.VK_LEFT:
			System.out.println("left");
			x -= 10;
			break;
		default:
			System.out.println(e.getKeyChar());
		}
		repaint();
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	private class Imagelabel extends JLabel {

		public Imagelabel() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.drawImage(bgImage, 0, 0, 600, 800, null);
			g.drawImage(imageIcon, x, y, 100, 100, null);
			
		}
	}
	
	public static void main(String[] args) {
		new MyFrameEx8();
		
	}

}
