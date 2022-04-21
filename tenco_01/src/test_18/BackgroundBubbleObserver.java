package test_18;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class BackgroundBubbleObserver {
	private BufferedImage image;
	private Bubble bubble;
	
	private final int LEFT_XPOSITON =0;
	private final int RIGHT_XPOSITON = 70;
	private final int TOP__XPOSITON = 25;
	
	public BackgroundBubbleObserver(Bubble bubble) {
		this.bubble = bubble;
		try {
			image = ImageIO.read(new File("images/backgroundMapService.png"));
		} catch (IOException e) {
			System.out.println("파일이 없습니다.");
		}
	}
	
	public boolean checkLeftWall() {
		return isCrashColor(LEFT_XPOSITON);
	}
	
	public boolean checkRightWall() {
		return isCrashColor(RIGHT_XPOSITON);
	}
	
	public boolean checkTopWall() {
		return isCrashColor(TOP__XPOSITON);
	}
	
	private boolean isCrashColor(int correction) {
		Color topColor = new Color(image.getRGB(bubble.getX() + correction, bubble.getY()));
		if(topColor.getRed() == 255 && topColor.getGreen() == 0 && topColor.getBlue() == 0) {
			return true;
		}
		return false;
	}
	
	
}
