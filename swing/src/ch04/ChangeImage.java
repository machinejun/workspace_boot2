package ch04;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ChangeImage extends JFrame implements ActionListener{

	JPanel panel, topPanel;
	Card card;
	JLabel label;
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	
	public ChangeImage() {
		initData();
		setInitLayout();
		AddActionListener();
	}
	
	public void initData() {
		setTitle("이미지바꾸기");
		setSize(400, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label = new JLabel("자 바꿔봅시다.");
		panel = new JPanel();
		card = new Card();
		topPanel = new JPanel();
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		button4 = new JButton();
		button5 = new JButton("이미지 바꾸기");
		card.add(label);
		add(card, "Center");
		add(panel, "South");
		add(topPanel, "Nouth");
		add(panel, "South");
		
		topPanel.add(button5);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
	}
	
	public void setInitLayout() {
		setVisible(true);
		panel.setLayout(new GridLayout(0,4));
		topPanel.setLayout(new GridLayout(0,1));
		
		
	}
	
	public void AddActionListener() {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	class Card extends JPanel{
		CardLayout layout;
		
		public Card() {
			layout = new CardLayout();
			setLayout(layout);
		}
		
		@Override
		public void paintComponents(Graphics g) {
			super.paintComponents(g);
			Image img = new ImageIcon("image1").getImage();
			g.drawImage(img, 0, 0, null);
		}
		
	}
	
	public static void main(String[] args) {
		new ChangeImage();
	}

	
}


