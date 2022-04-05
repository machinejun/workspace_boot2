package ch08;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.EventListener;

import javax.imageio.ImageIO;
import javax.swing.*;

public class addressScreen extends JFrame implements ActionListener{
	
	JLabel label;
	JLabel label2;
	JButton button;
	JButton button2;
	ImagePanel panel;
	LoginPanel loginPanel;
	
	public addressScreen() {
		initData();
		setInitLayout();
		addEventListener();
	}
	
	private void initData() {
		setTitle("돌겠네 그냥");
		setSize(600, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label = new JLabel("★주소록★");
		label2 = new JLabel("환영합니다 ~ ~", JLabel.CENTER);
		button = new JButton("로그인");
		button2 = new JButton("회원가입");
		panel = new ImagePanel();
		loginPanel = new LoginPanel();
		add(panel);
		panel.add(label);
		panel.add(label2);
		panel.add(button);
		panel.add(button2);
		panel.add(loginPanel);
		
		
	}
	
	private void setInitLayout() {
		setVisible(true);
		setResizable(false);
		panel.setLayout(null);
		label.setLocation(220, 0);
		label.setSize(200, 50);
		label2.setLocation(100, 300);
		label2.setSize(400, 80);
		label.setFont(new Font("d2coding", 0,30));
		label2.setFont(new Font("d2coding", 0,60));
		button.setLocation(130, 600);
		button2.setLocation(330, 600);
		button.setSize(130, 50);
		button2.setSize(130, 50);
		loginPanel.setLocation(100, 200);
	
	}
	
	private void addEventListener() {
		button.addActionListener(this);
		button2.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton selectButton = (JButton)e.getSource();
		if(selectButton.getText().equalsIgnoreCase("로그인")){
			System.out.println("로그인");
			loginPanel.setVisible(true);
			button.setText("프로그램 종료");
			button2.setText("주소록 열기");
		}
		else if(selectButton.getText().equalsIgnoreCase("회원가입")) {
			System.out.println("회원가입");

		}
		else if(selectButton.getText().equalsIgnoreCase("프로그램 종료")) {
			System.out.println("종료");
		}
		else if(selectButton.getText().equalsIgnoreCase("주소록 열기")) {
			System.out.println("open");
		}
	}
	
	private class ImagePanel extends JPanel{
		BufferedImage backImage;
		
		public ImagePanel() {
			try {
				backImage = ImageIO.read(new File("background.png"));
			} catch (IOException e) {
				System.out.println("파일이 없습니다.");
			}
		}
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(backImage, 0, 0, getWidth(), getHeight(), null);
		}
		
	}
	
	public class loginPanel extends JPanel implements ActionListener, KeyListener{
		JLabel introlabel;
		JLabel idLabel;
		JLabel psLabel;
		
		JTextField idField;
		JPasswordField psField;
		
		JButton button;
		JButton button2;
			
		public loginPanel() {
			initData();
			setInitLayout();
			addEventListener();
		}
		
		private void initData() {
			introlabel = new JLabel(" 로 그 인 ");
			idLabel = new JLabel("ID :");
			psLabel = new JLabel("PS :");
			idField = new JTextField("id를 입력하세요");
			psField = new JPasswordField("비밀번호를 입력하세요");
			button = new JButton("submit");
			button2 = new JButton("back");
			add(introlabel);
			
		}
		private void setInitLayout() {
			setSize(200, 200);
			setBackground(Color.white);
		}
		
		private void addEventListener() {
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
		
	
	
	
	public static void main(String[] args) {
		new addressScreen();
	}

	
}
