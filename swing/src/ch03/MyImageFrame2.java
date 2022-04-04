package ch03;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class MyImageFrame2 extends JFrame{
	
	// 코드를 수정해 주세요
	// 상수 또는 static 을 통해서 처리해주세요
	
	private BufferedImage backGroundImage;
	private BufferedImage imageIcon;
	private MyImagePanel myImagePanel;
	private JButton button;
	private final int[] frameSize = {800, 600};
	private final String backgrounUrl = "image1.jpg";
	private final String iconUrl = "icon2.png";
	
	public MyImageFrame2() {
		initData();
		setInitLayout();
	}
	
	private void initData() {
		setTitle("이미지 백그라운드 넣는 연습");
		setSize(frameSize[0], frameSize[1]);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			backGroundImage = ImageIO.read(new File(backgrounUrl)); // image 파일을 메모리에 올림
			imageIcon = ImageIO.read(new File(iconUrl));
		} catch (IOException e) {
			System.out.println("파일이 없습니다.");
		}
		
		myImagePanel = new MyImagePanel();
	}
	
	private void setInitLayout() {
		setVisible(true);
		setResizable(false);
		add(myImagePanel);
		
	}
	
	private class MyImagePanel extends JPanel{
		Scanner sc;
		private int[] iconLoaction = {0, 0};
		private final int[] iconSize = {100 , 100};
		private final int[] backGroundSize = {800 , 600};
		
		public MyImagePanel() {
			setIconLocation();
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.drawImage(backGroundImage, 0, 0, backGroundSize[0], backGroundSize[1], null);
			g.drawImage(imageIcon, iconLoaction[0], iconLoaction[1], iconSize[0], iconSize[1], null);
		}
		
		public void setIconLocation() {
			sc = new Scanner(System.in);
			System.out.println("아이콘의 위치를 입력하세요");
			System.out.print("x축 : ");
			int x = sc.nextInt();
			System.out.print("y축 : ");
			int y = sc.nextInt();
			
			iconLoaction[0] = x;
			iconLoaction[1] = y;
		
		}
	}// end of inner class
}// end of outer class
