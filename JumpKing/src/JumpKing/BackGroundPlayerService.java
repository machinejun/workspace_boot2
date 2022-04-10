package JumpKing;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/*
 *  메인 쓰레드 --> 키보드 이벤트 처리
 *  백그라운드에서 계속 관찰
 */

public class BackGroundPlayerService implements Runnable {

	private BufferedImage image;
	private Player player;
	private BackgroundPanel backgroundPanel;

	public BackGroundPlayerService(Player player, BackgroundPanel backgroundPanel) {
		this.backgroundPanel = backgroundPanel;
		this.player = player;
		try {
			image = ImageIO.read(new File("images/backgroundServicemap.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) { 
			if (player.getY() <= 50 && BackgroundPanel.stageNum == 1) {
				BackgroundPanel.stageNum = 2;
				backgroundPanel.stageChage();
				player.setY(550);
			} else if (player.getY() >= 580 && BackgroundPanel.stageNum == 2) {
				BackgroundPanel.stageNum = 1;
				backgroundPanel.stageChage();
				player.setY(60);
			}

		}

	}
}
