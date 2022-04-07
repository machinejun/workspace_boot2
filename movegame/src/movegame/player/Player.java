package movegame.player;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Player extends JPanel implements PlayerMove{
	// 플레이어 이미지
	private BufferedImage player;
	private BufferedImage playerL;
	private BufferedImage playerR;
	// 플레이어 좌표
	int x;
	int y;
	// 플레이어 상태
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	
	//좌표 겟터
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	// 상태 겟터 셋터
	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}
	
	// 이미지 겟터
	public BufferedImage getPlayer() {
		return player;
	}


	public Player() {
		initData();
	}
	
	
	private void initData() {
		try {
			playerL = ImageIO.read(new File("images/playerL.png"));
			playerR = ImageIO.read(new File("images/playerR.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		player = playerL;
	}

	@Override
	public void right() {
		right = true;
		player = playerL;
		new Thread(new Runnable() {
			@Override
			public void run() {
				x += 10;
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();	
	}

	@Override
	public void left() {
		left = true;
		player = playerR;
		new Thread(new Runnable() {
			@Override
			public void run() {
				x -= 10;
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();	
	}

	@Override
	public void down() {
		System.out.println("down");
		down = true;
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for( int i = 0; i < (130 /2); i++) {
					y = y + 2;
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				down = false;
			}
		}).start();
		
	}

	@Override
	public void jump() {
		System.out.println("up");
		up = true;
		new Thread(new Runnable() {	
			@Override
			public void run() {
				for( int i = 0; i < (130 / 2); i++) {
					y = y - 2;
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				up = false;
				down();
			}
		}).start();
		
	}
	

}
