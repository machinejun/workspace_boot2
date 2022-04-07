package test_07;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel implements Moveable{
	// 위치 상태
	private int X;
	private int Y;
	
	// 움직임 상태
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	
	// 이미지
	private ImageIcon playerR;
	private ImageIcon playerL;
	
	// 플레이어 속도 상태
	private final int SPEED = 4;
	private final int JUMPSPEED = 10;
	private final int DROPSPEED = 1;
	
	
	public Player() {
		initObject();
		initSetting();
	}
	
	private void initObject() {
		playerR = new ImageIcon("images/playerR.png");
		playerL = new ImageIcon("images/playerL.png");
	}
	
	private void initSetting() {
		X = 80;
		Y = 300;
		
		left = false;
		right = false;
		up = false;
		down = false;
		
		setIcon(playerR);
		setSize(50, 50);
		setLocation(X, Y);
		
	}
	
	//event handeler
	@Override
	public void left() {
		System.out.println("left");
		left = true;
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(left) {
					setIcon(playerL);
					X = X - SPEED;
					setLocation(X, Y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		}).start();;
		
		
	}

	@Override
	public void right() {
		System.out.println("left");
		right = true;
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(right) {
					setIcon(playerR);
					X = X + SPEED;
					setLocation(X, Y);	
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
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
				for( int i =0; Y < (160/JUMPSPEED); i++) {
					Y = Y + JUMPSPEED;
					setLocation(X, Y);
					if( Y == 190) {
						break;
					}
					else if( Y == 300) {
						break;
					}
					else if( Y == 420) {
						break;
					}
					else if(Y == 530) {
						break;
					}
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				down = false;
			}
		}).start();
		
	}
	
	
	// left  + up , rigth + up, 
	@Override
	public void up() {
		System.out.println("up");
		up = true;
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for( int i = 0; i < (160 / JUMPSPEED); i++) {
					Y = Y - JUMPSPEED;
					setLocation(X, Y);
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				up = false;
				down();
			}
		}).start();
	}



	public void setLeft(boolean left) {
		this.left = left;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public void setUp(boolean up) {
		this.up = up;
	}
	
	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isLeft() {
		return left;
	}

	public boolean isRight() {
		return right;
	}

	public boolean isUp() {
		return up;
	}

	public boolean isDown() {
		return down;
	}
	
	
	

}
