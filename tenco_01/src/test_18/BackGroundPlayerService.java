package test_18;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BackGroundPlayerService implements Runnable{
	
	private BufferedImage image;
	private Player player;
	
	public BackGroundPlayerService(Player player) {
		this.player = player;
		try {
			image = ImageIO.read(new File("images/backgroundMapService.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while(true) {  
			Color leftcolor;
			Color rightcolor;
			int buttomColor;

			leftcolor = new Color(image.getRGB(player.getX()  , player.getY()));
			rightcolor = new Color(image.getRGB(player.getX() + 50 + 15 , player.getY()));
			buttomColor = image.getRGB(player.getX() + 10, player.getY() ) 
							+ image.getRGB(player.getX() + 50 -10, player.getY() );

			// 바닥 관리
			if(buttomColor != -2) {
				System.out.println("바닥에 부딪힘");
				player.setDown(false);
			}else {
				if(!player.isUp() && !player.isDown()) {
					player.down();
				}
			}
			
			// 벽 충돌 감지
			if(leftcolor.getRed() == 255 && leftcolor.getBlue() == 0 && leftcolor.getGreen() == 0) { 
				System.out.println("L 충돌");
				player.setLeftWallCrash(true);
				player.setLeft(false);
				//player.setLocation(player.getX() + 20, player.getY());
			}else if(rightcolor.getRed() == 255 && rightcolor.getBlue() == 0 && rightcolor.getGreen() == 0) {
				System.out.println("R 충돌");
				player.setRightWallCrash(true);
				player.setRight(false);
				//player.setLocation(player.getX() - 15, player.getY());
			}else {
				player.setLeftWallCrash(false);
				player.setRightWallCrash(false);

			}
			
			// 스테이지 관리
			
			try {
				Thread.sleep(1);  
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
