package test_15;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

// 쓰레드로 만들지 않을 거임
// why? > 느려진다.
public class BackgroundBubbleObserver {
	private BufferedImage image;
	private Bubble bubble;
	
	// Color 멤버 변수로 만드는게 좋은가 ? -> 지역변수를 쓰는게 더 좋다. why?>> 한번 생성한 후 사용하고 버려질 것이기 떄문
	// 리팩토링 과정 연습 >> 
	
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
		// 1 단계
		return isCrashColor(LEFT_XPOSITON);
	}
	
	public boolean checkRightWall() {
		// 2 단계
		return isCrashColor(RIGHT_XPOSITON);
	}
	
	public boolean checkTopWall() {
		// 3 단계
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
