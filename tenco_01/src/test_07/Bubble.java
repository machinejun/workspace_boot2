package test_07;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bubble extends JLabel{
	private ImageIcon bubble;
	private Player player;

	
	public Bubble(Player player) {
		this.player = player;
		bubble = new ImageIcon("images/bubble.png");
		setSize(50, 50);
		setLocation(100, 300);
		setIcon(bubble);
	}
	
	public void shotBubbleL() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("shot");
				for(int i = 0; i < 50; i++) {
					int l = player.getX() + 1;
					setLocation(l, player.getY());
					System.out.println(player.getX() + "/" + player.getY());
				}
				try {
					Thread.sleep(5);
				} catch (Exception e) {
				}
			}
		}).start();
	}

}
