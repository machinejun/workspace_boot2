package movegame;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import movegame.player.Player;


// 패널로 움직일려고 하면 전체 리페인트를 해야해서 >>>> 동작이 느려진다.
public class MainF extends JFrame {
	BgPanel bgPanel;
	Player player;

	public MainF() {
		initData();
		initLayout();
		addEventListener();
	}

	private void initData() {
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		player = new Player();
		bgPanel = new BgPanel(player);
		add(bgPanel);
		bgPanel.add(player);
	}

	private void initLayout() {
		setVisible(true);

	}

	private void addEventListener() {

		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("이벤트 작동 ?");

				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					System.out.println("left");
					if(!(player.isLeft())) {
						player.left();
					}
					break;
					
				case KeyEvent.VK_RIGHT:
					System.out.println("right");
					if(!(player.isRight())) {
						player.right();
					}
					break;
				case KeyEvent.VK_UP:
					System.out.println("up");
					if(!(player.isUp()) && !(player.isDown())) {
						player.jump();
					}
					break;
				case KeyEvent.VK_DOWN:
					System.out.println("down");
					if(!(player.isDown())) {
						player.down();
					}
					break;

				default:
					break;
				}
				repaint();
			}
		});
	}

	private class BgPanel extends JPanel {
		BufferedImage bgImage;
		Player player;

		public BgPanel(Player player) {
			this.player = player;
			try {
				bgImage = ImageIO.read(new File("images/backgroundMap.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		protected void paintComponent(Graphics g) {
			g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), null);
			g.drawImage(player.getPlayer(), player.getX(), player.getY(), null);
		}
	}

	public static void main(String[] args) {
		new MainF();
	}

}
