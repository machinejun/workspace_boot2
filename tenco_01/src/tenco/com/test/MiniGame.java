package tenco.com.test;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MiniGame extends JFrame implements ActionListener {

	private BufferedImage bgImage;
	private BufferedImage playerImage;
	private BufferedImage playerImageL;
	private BufferedImage playerImageR;

	private BufferedImage enemyImage;
	private BufferedImage enemyImageL;
	private BufferedImage enemyImageR;

	private JButton startbutton;
	private JButton endbutton;

	private boolean isThread = true;
	private int playerX;
	private int playerY;

	private int enemyX;
	private int enemyY;

	private CustomJpanel customJpanel;
	private JPanel buttomPanel;

	public MiniGame() {
		initData();
		setInitLayout();
		addEventListener();

		new Thread(customJpanel).start();;

	}

	private void initData() {
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startbutton = new JButton("Start");
		endbutton = new JButton("End");

		// 파일 초기화
		try {
			bgImage = ImageIO.read(new File("images/backgroundMap.png"));
			playerImageR = ImageIO.read(new File("images/playerR.png"));
			playerImageL = ImageIO.read(new File("images/playerL.png"));
			playerImage = playerImageR;

			enemyImageR = ImageIO.read(new File("images/enemyR.png"));
			enemyImageL = ImageIO.read(new File("images/enemyL.png"));
			enemyImage = enemyImageR;

		} catch (IOException e) {
			System.out.println("파일이 없습니다 ....");
		}

		// 내부 클래스 초기화.
		customJpanel = new CustomJpanel();
		enemyX = 100;
		enemyY = 390;
		
		buttomPanel = new JPanel(new FlowLayout());

	}

	private void setInitLayout() {
		setVisible(true);
		buttomPanel.add(startbutton);
		buttomPanel.add(endbutton);
		add(customJpanel, BorderLayout.CENTER);
		add(buttomPanel, BorderLayout.SOUTH);
		this.requestFocusInWindow();
		

		
	}

	private void addEventListener() {
		startbutton.addActionListener(this);
		endbutton.addActionListener(this);
		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();

				switch (keyCode) {
				case KeyEvent.VK_UP:
					playerY -= 10;
					break;
				case KeyEvent.VK_DOWN:
					playerY += 10;
					break;
				case KeyEvent.VK_RIGHT:
					playerX += 10;
					playerImage = playerImageR;
					break;
				case KeyEvent.VK_LEFT:
					playerX -= 10;
					playerImage = playerImageL;
				}
				repaint();
			}
		});
		this.requestFocusInWindow();
	} // end of addEventListener

	// 내부 클래스
	private class CustomJpanel extends JPanel implements Runnable {

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), null);
			g.drawImage(playerImage, playerX, playerY, 55, 55, null);
			g.drawImage(enemyImage, enemyX, enemyY, 50, 50, null);
		}

		@Override
		public void run() {
			boolean direction = true;
			while (true) {
				if (isThread) {
					if (direction) {
						enemyX += 10;
					} else {
						enemyX -= 10;
					}

					if (enemyX == 400) {
						direction = false;
						enemyImage = enemyImageL;
					}

					if (enemyX == 130) {
						direction = true;
						enemyImage = enemyImageR;
					}

					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				} // end of if - isThread
				repaint();
			}
		}

	}//

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton targetButton = (JButton)e.getSource();
		if(startbutton == targetButton) {
			System.out.println("d 1");
			isThread = true;
		}else {
			System.out.println("d 2");
			isThread = false;
		}
		this.requestFocusInWindow();
	}

	public static void main(String[] args) {
		new MiniGame();
	}

}
