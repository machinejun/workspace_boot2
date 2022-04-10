package JumpKing;

import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.xml.crypto.Data;

import org.graalvm.compiler.core.common.util.Util;
import org.jcp.xml.dsig.internal.dom.Utils;

public class Player extends JLabel implements Moveable {
	// 위치 상태
	private int X;
	private int Y;

	// 움직임 상태
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	private boolean sightR = true;
	private boolean sightL = false;

	// 이미지
	private ImageIcon playerR;
	private ImageIcon playerL;

	// 벽에 충돌한 상태
	private boolean leftWallCrash;
	private boolean rightWallCrash;

	// 플레이어 속도 상태
	private final int SPEED = 2;
	private final int JUMPSPEED = 3;

	// Back_service로 주기위해 생성하는데 OOP의 개념에선 좀 안맞는다.
	private BackgroundPanel backgroundPanel;

	public Player(BackgroundPanel backgroundPanel) {
		this.backgroundPanel = backgroundPanel;
		initObject();
		initSetting();
		initBackGroundPlayerSerivce();
	}

	private void initBackGroundPlayerSerivce() {
		new Thread(new BackGroundPlayerService(this, backgroundPanel)).start();

	}

	private void initObject() {
		playerR = new ImageIcon("images/playerR.png");
		playerL = new ImageIcon("images/playerL.png");
	}

	private void initSetting() {
		X = 100;
		Y = 200;

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

	// event handler
	@Override
	public void left() {
		System.out.println("left");
		left = true;
		sightR = false;
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (left) {
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
		}).start();
		;

	}

	@Override
	public void right() {
		System.out.println("rigft");
		right = true;
		sightR = true;
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (right) {
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
				while (down) {
					if (sightR && !sightL) {
						X = X + SPEED;
						Y = Y + JUMPSPEED;
					} else if (!sightL && sightR) {
						X = X - SPEED;
						Y = Y + JUMPSPEED;
					} else {
						Y = Y + JUMPSPEED;
					}

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

	// left + up , right + up,
	@Override
	public void up() {
		System.out.println("up");

		up = true;
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 141; i++) {
					X = X + SPEED;
					if (i < 21) {
						Y = Y - JUMPSPEED;
					} else if (i < 41) {
						Y = Y - JUMPSPEED + 1;
					} else if (i < 61) {
						Y = Y - JUMPSPEED + 2;
					} else if (i < 81) {
						Y = Y - JUMPSPEED + 3;
					} else if (i < 101) {
						Y = Y + JUMPSPEED - 2;
					} else if (i < 121) {
						Y = Y + JUMPSPEED - 1;
					} else {
						Y = Y + JUMPSPEED;
					}
					setLocation(X, Y);
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO: handle exception
					}
				}
				down();
			}
		}).start();
	}

	public void setY(int y) {
		Y = y;
	}

	public boolean isSightR() {
		return sightR;
	}

	public void setSightR(boolean sightR) {
		this.sightR = sightR;
	}

	public boolean isLeftWallCrash() {
		return leftWallCrash;
	}

	public void setLeftWallCrash(boolean leftWallCrash) {
		this.leftWallCrash = leftWallCrash;
	}

	public boolean isRightWallCrash() {
		return rightWallCrash;
	}

	public void setRightWallCrash(boolean rightWallCrash) {
		this.rightWallCrash = rightWallCrash;
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
