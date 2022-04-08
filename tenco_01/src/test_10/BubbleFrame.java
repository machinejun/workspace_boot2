package test_10;

import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class BubbleFrame extends JFrame {
	private JLabel backgroundMap;
	private JLabel backgroundMap2;
	private Player player;
	private Bubble bubble;


	public BubbleFrame() {
		initObject();
		initSetting();
		initListener();
		setVisible(true);
	}

	private void initObject() {

		backgroundMap = new JLabel(new ImageIcon("images/backgroundMap.png"));
		backgroundMap2 = new JLabel(new ImageIcon("images/backgroundMapService.png"));
		
		setContentPane(backgroundMap);
		setContentPane(backgroundMap);
		
		player = new Player();
		add(player);

	}

	private void initSetting() {
		setSize(300, 600);
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void initListener() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println(e.getKeyCode());
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					if (!(player.isLeft()) && !player.isLeftWallCrash()) { // 쓰레드의 중복 실행이 되어서 가속되는 것을 막기우해서 left()가 실행되고 있을때는 실행 되지 못하게 하고 충돌이 일어났을 때는 동작되지 않게만듬
						player.left();
					}
					break;
				case KeyEvent.VK_RIGHT:
					if (!(player.isRight()) && !player.isLeftWallCrash()) {
						player.right();
					}
					break;
				case KeyEvent.VK_UP:
					System.out.println("점프");
					if (!(player.isUp()) && !(player.isDown())) { // 점프 + 떨어지지 않을 때만 실행 가능
						player.up();
					}
					break;

				case KeyEvent.VK_DOWN:
					if (!(player.isUp()) && !(player.isDown())) { 
						player.down();
					}
					break;
				case KeyEvent.VK_SPACE: 
 					bubble = new Bubble();  // 미사일은 생성되고 사라지고를 반복해야함
					add(bubble);
					bubble.shotBubbleL(player);
					bubble = null;
				default:
				}
			}// end of keypressed

			// 키보드 해제 이벤트 처리
			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					player.setLeft(false);
					break;
				case KeyEvent.VK_RIGHT:
					player.setRight(false);
					break;
				case KeyEvent.VK_UP:
					player.setUp(false);
					break;
				case KeyEvent.VK_DOWN:
					player.setDown(false);
					break;
				case KeyEvent.VK_0:
					imgUrl = "Map.png"
				default:
					break;
				}
			}
		});
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}
}
