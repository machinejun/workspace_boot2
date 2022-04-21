package JumpKing;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BackgroundLabel extends JPanel{
	private BufferedImage stage1Img;
	private BufferedImage stage2Img;
	private BufferedImage stageImg;
	static int stageNum = 1;
	
	public public BackgroundLabel() {
		try {
			stage1Img = ImageIO.read(new File("images/showlabel2.png"));
			stage2Img = ImageIO.read(new File("images/showlabel1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stageImg = stage1Img;
	}
	
	public void stageChage() {
		System.out.println("stage Change");
		if(stageNum == 1) {
			stageImg = stage1Img;
		}else if (stageNum == 2) {
			stageImg = stage2Img;
		}
		repaint();
	}
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(stageImg, 0, 0, 1440,980,null);
	}
	
	
}
