package test_20;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Data;

@Data
public class Enemy2 extends JLabel implements Moveable{
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
	private EnemyWay enemyWay = EnemyWay.LEFT;
	
	// 이미지
	private ImageIcon enemyR;
	private ImageIcon enemyL;
	
	// 벽에 충돌한 상태
	private boolean leftWallCrash;
	private boolean rightWallCrash;
	
	private boolean isLive = true;
	
	
	// 적군 속도 상태
	private final int SPEED = 2;
	private final int JUMPSPEED = 1;

	public Enemy2(BubbleFrame mcontext) {
		this.mContext = mcontext;
		initObject();
		initSetting();
		//initBackGroundPlayerSerivce();
	}
	
	private void initBackGroundPlayerSerivce() {
		//new Thread(new BackGroundPlayerService(this)).start();
		
	}

	private void initObject() {
		enemyR = new ImageIcon("images/enemyR.png");
		enemyL = new ImageIcon("images/enemyL.png");
	}
	
	private void initSetting() {
		X = 300;
		Y = 200;
		
		left = false;
		right = false;
		up = false;
		down = false;
		isLive = true;
		
		leftWallCrash = false;
		rightWallCrash = false;
		
		setIcon(enemyR);
		setSize(50, 50);
		setLocation(X, Y);
		
	}
	
	//event handeler
	@Override
	public void left() {
		System.out.println("left");
		left = true;
		enemyWay = EnemyWay.LEFT;
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(left) {
					setIcon(enemyL);
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
		enemyWay = EnemyWay.RIGHT;
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(right) {
					setIcon(enemyR);
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
//	public Bubble attackBubble() {
//		return new Bubble(this);
//	}
//	
	
	

}
