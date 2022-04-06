package Thread_ex;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyMiniGame extends JFrame{
	BufferedImage image1;
	BufferedImage image2;
	BufferedImage image3;
	CustomJpanel jpanel = new CustomJpanel();
	JButton button = new JButton("멈춤");
	int[] position = {200, 200};
	int moveXposition = 0;
	boolean stop = true;
	
	
	
	public int getMoveXposition() {
		return moveXposition;
	}

	public void setMoveXposition(int moveXposition) {
		this.moveXposition = moveXposition;
	}

	public MyMiniGame() {
		initData();
		setInitLayout();
		addEventListener();
		Thread thread = new Thread(jpanel);
		thread.start();
	}
	
	private void initData() {
		setTitle("스레드 사용");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			image1 = ImageIO.read(new File("background1.png"));
			image2 = ImageIO.read(new File("ticon2.png"));
			image3 = ImageIO.read(new File("icon3.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 파일 가져오기 todo
		// 생성자에서 스레드 start()
		
	}
	
	private void setInitLayout() {
		setVisible(true);
		add(jpanel);
		jpanel.add(button);
		requestFocusInWindow();
		
		
	}
	
	private void addEventListener() {
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				stop = false;
				requestFocusInWindow();
				JButton selectButton = (JButton)e.getSource();
				if(selectButton.getText().equalsIgnoreCase("동작")){
		
				}
				
			}
		});
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) {
				case KeyEvent.VK_UP :
					System.out.println("hello");
					position[1] -= 10;
					break;
					
				case KeyEvent.VK_DOWN:
					position[1] += 10;
					break;
					
				case KeyEvent.VK_RIGHT:
					position[0] += 10;
					break;
					
				case KeyEvent.VK_LEFT:
					position[0] -= 10;
					break;
				default:
					JOptionPane.showMessageDialog(null, "잘못 눌렀습니다.");
				}
				repaint();
			}
		});
	}

	private class CustomJpanel extends JPanel implements Runnable{
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			// 이미지를 그려주세요 3 개 todo
			g.drawImage(image1, 0, 0, getWidth(), getHeight(), null);
			g.drawImage(image2, position[0], position[1], 100, 100, null);
			g.drawImage(image3, moveXposition, 300, 100, 100, null);
		}

		@Override
		public void run() {
			boolean direction = true;
			while(true) {		
				if(stop) {
					if(direction) {
						moveXposition += 5;
					} else {
						moveXposition -= 5;
					}
					if( moveXposition == 50) {
						direction = true;
					}else if( moveXposition == 400) {
						direction = false;
					}
				}		
				repaint();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
	public static void main(String[] args) {
		new MyMiniGame();
	}

	
}
