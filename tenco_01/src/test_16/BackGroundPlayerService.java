package test_16;

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

			leftcolor = new Color(image.getRGB(player.getX() - 5, player.getY() + 25));
			rightcolor = new Color(image.getRGB(player.getX() + 50 , player.getY() + 25));
			buttomColor = image.getRGB(player.getX(), player.getY() + 55) + image.getRGB(player.getX() + 50, player.getY() + 55);

			if(buttomColor != -2) {
				player.setDown(false);
			}else {
				if(!player.isUp() && !player.isDown()) {
					player.down();
				}
			}
		
			
			if(leftcolor.getRed() == 255 && leftcolor.getBlue() == 0 && leftcolor.getGreen() == 0) { 
				player.setLeftWallCrash(true);
				player.setLeft(false);
				player.setLocation(player.getX() + 15, player.getY());
			}else if(rightcolor.getRed() == 255 && rightcolor.getBlue() == 0 && rightcolor.getGreen() == 0) {
				System.out.println("R 충돌");
				player.setRightWallCrash(true);
				player.setRight(false);
				player.setLocation(player.getX() - 15, player.getY());
			}else {
				player.setLeftWallCrash(false);
				player.setRightWallCrash(false);
			}
			try {
				Thread.sleep(1);  
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}

}
