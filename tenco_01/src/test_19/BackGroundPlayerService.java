package test_19;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class BackGroundPlayerService implements Runnable{
	
	private BufferedImage image;
	private Player player;
	private List<Bubble> bubbles = new ArrayList<Bubble>();
	
	
	public BackGroundPlayerService(Player player) {
		this.player = player;
		this.bubbles = player.getBubbles();
		try {
			image = ImageIO.read(new File("images/backgroundMapService.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while(true) {  
			
			//1. 버블 충돌 체크
			for(int i = 0; i < bubbles.size(); i++) {
				Bubble target = bubbles.get(i);
				if(target.getState() == 1) {
					if(Math.abs(target.getY() - player.getY()) < 50 && Math.abs(target.getX() - player.getX()) < 50) {
						target.setIcon(target.getBomb());
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						bubbles.remove(target);
						target.setIcon(null);
						
					}
				}
			};
			
			Color leftcolor;
			Color rightcolor;
			int buttomColor;

			leftcolor = new Color(image.getRGB(player.getX()  , player.getY()));
			rightcolor = new Color(image.getRGB(player.getX() + 50 + 15 , player.getY()));
			buttomColor = image.getRGB(player.getX() + 10, player.getY() + 10 ) 
							+ image.getRGB(player.getX() + 50 -10, player.getY() + 10 );

			// 바닥 관리
			if(buttomColor != -2) {
				player.setDown(false);
			}else {
				if(!player.isUp() && !player.isDown()) {
					player.down();
				}
			}
			
			// 벽 충돌 감지
			if(leftcolor.getRed() == 255 && leftcolor.getBlue() == 0 && leftcolor.getGreen() == 0) { 
				player.setLeftWallCrash(true);
				player.setLeft(false);

			}else if(rightcolor.getRed() == 255 && rightcolor.getBlue() == 0 && rightcolor.getGreen() == 0) {
				player.setRightWallCrash(true);
				player.setRight(false);
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
