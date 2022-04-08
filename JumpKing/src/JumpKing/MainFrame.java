package JumpKing;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;


public class MainFrame extends JFrame{
	private BackgroundPanel backgroundPanel;
	private Player player;
	
	
	public MainFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}
	
	private void initData() {
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		backgroundPanel = new BackgroundPanel();
		player = new Player(backgroundPanel);
	}
	
	private void setInitLayout() {
		setVisible(true);
		add(backgroundPanel);
		backgroundPanel.setLayout(null);  // layout > null로 선언 안하면 setLocation 못씀
		backgroundPanel.add(player);
	}
	
	private void addEventListener() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println(e.getKeyCode());
				switch (e.getKeyCode()) {
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
				default:
				}
			}
		});
	}
	public static void main(String[] args) {
		new MainFrame();
	}
	
}
