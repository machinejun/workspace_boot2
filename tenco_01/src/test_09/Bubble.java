package test_09;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bubble extends JLabel{
	private ImageIcon bubble;
	private boolean shotFlag = false;

	
	public Bubble() {
		bubble = new ImageIcon("images/bubble.png");
		setSize(50, 50);
		setLocation(100, 300);
		setIcon(bubble);
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
				for(int i = 0; i < 150; i++) {
					x += 2;
					setLocation(x, y);
					System.out.println(player.getX() + "/" + player.getY());
					try {
						Thread.sleep(5);
					} catch (Exception e) {
					}
				}
				setVisible(false);
				//shotFlag = false;
			}
		}).start();
	}

}
