package test_07;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BubbleFrame extends JFrame {
	private JLabel backgroundMap;
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
		setContentPane(backgroundMap);
		player = new Player();
		
		add(player);
		
	}

	private void initSetting() {
		setSize(1000, 640);
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
					if(!(player.isLeft())) {
						player.left();
					}	
					break;
				case KeyEvent.VK_RIGHT:
					if(!(player.isRight())) {
						player.right();
					}
					break;
				case KeyEvent.VK_UP:
					System.out.println("점프");
					if(!(player.isUp()) && !(player.isDown())) {
						player.up();
					}
					break;
					
				case KeyEvent.VK_DOWN:
					if(!(player.isUp()) && !(player.isDown())) {
						player.down();
					}
					break;
				case KeyEvent.VK_SPACE:
					System.out.println("space");
					bubble = new Bubble();
					add(bubble);
					bubble.shotBubbleL(player);

					break;
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
