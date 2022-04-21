package test_19;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bubble extends JLabel implements Moveable{
	private BubbleFrame mContext;
	//2 단계
	private Bubble bubbleContext = this;
	//의존성 컴포지션
	private Player player;
	
	private BackgroundBubbleObserver backgroundBubbleObserver;
	private Enemy2 enemy;
	
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
	public Bubble(BubbleFrame mContext) {
		this.mContext = mContext;
		this.player = mContext.getPlayer();
		this.enemy = mContext.getEnemy();
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
			if((Math.abs(x - enemy.getX()) < 10) && (Math.abs(y - enemy.getY()) > 0) && (Math.abs(y - enemy.getY()) < 50)){
				System.out.println("물방울이 적군과 충돌");
				if(enemy.isLive()) {
					attack();
					break;
				}
				
				
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
			if((Math.abs(x - enemy.getX()) < 10) && (Math.abs(y - enemy.getY()) > 0) && (Math.abs(y - enemy.getY()) < 50)){
				System.out.println("물방울이 적군과 충돌");
				if(enemy.isLive()) {
					attack();
					break;
				}
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
		if(state == 0) {
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		up = false;
		if(state != 1) {
			removebubble();
		}
	}
	
//	private void poppbubble() {
//		if(state == 1 && ) {
//			System.out.println("hhhj");
//			removebubble();
//		}
//	}
	
	private void removebubble() {
		
		try {
			Thread.sleep(2000);
			setIcon(bomb);
			Thread.sleep(1000);
			bubbleContext = null;
			setIcon(null);		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void attack() {
		state = 1;
		setIcon(bubbled);
		enemy.setLive(false);
		// 적군의 상태값 부여
		
		
		
		// 메모리에 지우는것
		mContext.remove(enemy);
		mContext.repaint();
		// 자바 특성, 불필요한 메모리를 지우더라도 >> 가비지 컬렉터는 즉시 발생하지 않음
	}

	private void threadSleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
