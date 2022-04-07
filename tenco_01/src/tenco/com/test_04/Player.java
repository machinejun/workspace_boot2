package tenco.com.test_04;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import tenco.com.test_05.Moveable;

public class Player extends JLabel implements Moveable{
	private int X;
	private int Y;
	
	private ImageIcon playerR;
	private ImageIcon playerL;
	
	public Player() {
		initObject();
		initSetting();
	}
	
	private void initObject() {
		playerR = new ImageIcon("imges/playerR.png");
		playerL = new ImageIcon("imges/playerL.png");
	}
	
	private void initSetting() {
		X = 80;
		Y = 300;
		setIcon(playerR);
		setSize(50, 50);
		setLocation(X, Y);
		
	}

	@Override
	public void left() {
		setIcon(playerL);
		X = X - 10;
		setLocation(X, Y);
		
	}

	@Override
	public void right() {
		setIcon(playerR);
		X = X + 10;
		setLocation(X, Y);
		
	}

	@Override
	public void down() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void up() {
		// TODO Auto-generated method stub
		
	}
	

}
