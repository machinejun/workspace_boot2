package test_18;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Data;

@Data
public class Player extends JLabel implements Moveable{
	private BubbleFrame mContext;
	
	// 위치 상태
	private int X;
	private int Y;
	
	// 움직임 상태
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	private boolean sightR = true;
	private PlayerWay playerWay = PlayerWay.RIGHT;
	
	// 이미지
	private ImageIcon playerR;
	private ImageIcon playerL;
	
	// 벽에 충돌한 상태
	private boolean leftWallCrash;
	private boolean rightWallCrash;
	
	
	// 플레이어 속도 상태
	private final int SPEED = 4;
	private final int JUMPSPEED = 2;

	public Player(BubbleFrame mContext) {
		this.mContext = mContext;
		initObject();
		initSetting();
		initBackGroundPlayerSerivce();
	}
	
	private void initBackGroundPlayerSerivce() {
		new Thread(new BackGroundPlayerService(this)).start();
		
	}

	private void initObject() {
		playerR = new ImageIcon("images/playerR.png");
		playerL = new ImageIcon("images/playerL.png");
	}
	
	private void initSetting() {
		X = 80;
		Y = 500;
		
		left = false;
		right = false;
		up = false;
		down = false;
		
		leftWallCrash = false;
		rightWallCrash = false;
		
		setIcon(playerR);
		setSize(50, 50);
		setLocation(X, Y);
		
	}
	
	//event handeler
	@Override
	public void left() {
		System.out.println("left");
		left = true;
		playerWay = PlayerWay.LEFT;
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
					} catch (ArrayIndexOutOfBoundsException e) {
						e.printStackTrace();
					}
				}
				
			}
		}).start();;
		
		
	}

	@Override
	public void right() {
		System.out.println("rigft");
		right = true;
		playerWay = PlayerWay.RIGHT;
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
				while(down) {
					Y = Y + JUMPSPEED;
					setLocation(X, Y);
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO: handle exception
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
				for( int i = 0; i < (130 / JUMPSPEED); i++) {
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
	
	// 메서드 이름 >> 동사 + 명사  => 권장
	public void attackBubble() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				Bubble bubble = new Bubble(mContext.getPlayer());
				mContext.add(bubble);
				if(playerWay == PlayerWay.LEFT) {
					bubble.left();
				}else {
					bubble.right();
				}
				
			}
		}).start();
	}
	
	
	

}
