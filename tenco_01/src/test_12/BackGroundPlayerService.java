package test_12;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/*
 *  메인 쓰레드 --> 키보드 이벤트 처리
 *  백그라운드에서 계속 관찰
 */

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
		// 색상 확인
		// 도전 과제 던지거나 처리
		while(true) {    // RGB를 통한 문제 해결 좌표로 할수도 있지만 너무 귀찮다.

			Color leftcolor;
			Color rightcolor;
			int buttomColor;

			leftcolor = new Color(image.getRGB(player.getX() - 10, player.getY() + 25));
			rightcolor = new Color(image.getRGB(player.getX() + 50 + 20, player.getY() + 25));
			buttomColor = image.getRGB(player.getX() + 10, player.getY() + 55) + image.getRGB(player.getX() + 40, player.getY() + 55);
			
			//Color buttomColor = new Color(image.getRGB(player.getX() + 25, player.getY() + 60));

			// -1 이 아니라는 것은 빨간색 이거나 파란색 이다.
			
			if(buttomColor != -2) {
				player.setDown(false);
			}else {
				if(!player.isUp() && !player.isDown()) {
					player.down();
				}
			}
			try {
				Thread.sleep(1);  // 캐릭터가 이동될때 쓰레드 보다 칼라값을 찾는 쓰레드를 더 빠르게 해줘야된다. 아니면 쓰레드가 인식을 못해서 파고들어간다.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(leftcolor.getRed() == 255 && leftcolor.getBlue() == 0 && leftcolor.getGreen() == 0) { // 충돌이 일어 날 경우 안쪽으로 밀어 넣어 준다.
				System.out.println("L 충돌");
				player.setLeftWallCrash(true);
				player.setLeft(false);
				player.setLocation(player.getX() + 15, player.getY());
			}else if(rightcolor.getRed() == 255 && rightcolor.getBlue() == 0 && rightcolor.getGreen() == 0) {
				System.out.println("R 충돌");
				player.setRightWallCrash(true);
				player.setLeft(false);
				player.setLocation(player.getX() - 15, player.getY());
			}else {
				player.setLeftWallCrash(false);
				player.setRightWallCrash(false);
			}
			
			
		}
	}

}
