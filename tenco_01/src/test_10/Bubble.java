package test_10;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bubble extends JLabel{
	private ImageIcon bubble;


	public Bubble() {
		bubble = new ImageIcon("images/bubble.png");
		setSize(50, 50);
		setIcon(bubble);
		setLocation(-50,200);
		setVisible(true);
	}
	
	public void shotBubbleL(Player player) {
		new Thread(new Runnable() {
			@Override
			public void run() {

				int x = player.getX();
				int y = player.getY();
				System.out.println("shot");
				//shotFlag = true;
				if(player.isSightR() == true) {
					System.out.println("오른쪽 sht");
					for(int i = 0; i < 150; i++) {
						x += 2;
						setLocation(x, y);
						try {
							Thread.sleep(5);
						} catch (Exception e) {
						}
					}
					setVisible(false);
					
				}else if(player.isSightR() == false) {
					System.out.println("오른쪽 sht");
					for(int i = 0; i < 150; i++) {
						x -= 2;
						setLocation(x, y);

						try {
							Thread.sleep(5);
						} catch (Exception e) {
						}
					}
					setVisible(false);
				}

			}
		}).start();
	}

}
