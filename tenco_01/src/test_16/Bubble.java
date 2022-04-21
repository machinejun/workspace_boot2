package test_16;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bubble extends JLabel implements Moveable{
	
	// 1단계
	private BubbleFrame mContext;
	
	//의존성 컴포지션
	private Player player;
	// --------------------------
	private BackgroundBubbleObserver backgroundBubbleObserver;
	
	//위치 상태
	private int x;
	private int y;
	
	//움직임 상태
	private boolean left;
	private boolean right;
	private boolean up;
	
	// 적군을 맞춘 상태
	private int state; // 0. 기본, 1. 적군 가둠
	
	private ImageIcon bubble; // 기본 물방울
	private ImageIcon bubbled; // 적을 가둔 물방울 형태
	private ImageIcon bomb; // 물방울이 터진 상태
	
	
	
	// 의존 주입 --> 생성자에서 주입을 받는다.
//	public Bubble(Player player) {
//		this.player = player;
//		initObject();
//		initSetting();
//		initThread();
//	}
	
	public Bubble(BubbleFrame mContext) {
		this.mContext = mContext;
		this.player = mContext.player;
		initObject();
		initSetting();
		initThread();
	}
	
	
	private void initObject() {
		bubble = new ImageIcon("images/bubble.png");
		bubbled = new ImageIcon("images/bubbled.png");
		bomb = new ImageIcon("images/bomb.png");
		backgroundBubbleObserver = new BackgroundBubbleObserver(this);
	}
	
	private void initSetting() {
		left = false;
		right = false;
		up = false;
		
		x = player.getX();
		y = player.getY();
		
		setIcon(bubble);
		setSize(50, 50);
		
		state = 0;
		
	}
	
	private void initThread() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				if(player.getPlayerWay() == PlayerWay.LEFT) {
					left();
				}else {
					right();
				}
				
			}
		}).start();
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

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

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public ImageIcon getBubble() {
		return bubble;
	}

	public void setBubble(ImageIcon bubble) {
		this.bubble = bubble;
	}

	public ImageIcon getBubbled() {
		return bubbled;
	}

	public void setBubbled(ImageIcon bubbled) {
		this.bubbled = bubbled;
	}

	public ImageIcon getBomb() {
		return bomb;
	}

	public void setBomb(ImageIcon bomb) {
		this.bomb = bomb;
	}

	@Override
	public void left() {
		left = true;
		for(int i = 0; i < 400; i++) {
			x--;
			// 현재 생상 체크(메서드 호출)
			setLocation(x, y);
			if(backgroundBubbleObserver.checkLeftWall()) {
				left = false;
				break;
			}
			threadSleep(1);
		}
		left = false;
		up();
	}

	@Override
	public void right() {
		right = true;
		for(int i = 0; i < 400; i++) {
			x++;
			setLocation(x, y);
			if(backgroundBubbleObserver.checkRightWall()) {
				right = false;
				break;
			}
			threadSleep(1);
		}
		right = false;
		up();
	}

	@Override
	public void up() {
		System.out.println("호출");
		up = true;
		while(up) {
			y--;
			setLocation(x, y);
			if(backgroundBubbleObserver.checkTopWall()) {
				System.out.println("dddd");
				break;
			}
			threadSleep(1);
		}
		up = false;
		removebubble();
	}
	
	private void removebubble() {
		System.out.println("ddddddddd");
		try {
			Thread.sleep(2000);
			System.out.println("터짐");
			setIcon(bomb);
			Thread.sleep(1000);
			mContext.remove(this); // 메모리에서 제거
			mContext.repaint(); // JFrame에서 다시 그림
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
	}

	private void threadSleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
