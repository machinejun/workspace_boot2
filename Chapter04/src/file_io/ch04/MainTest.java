package file_io.ch04;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MainTest extends JFrame {
	
	private textArea textArea;
	private ImagePanel background;
	private JButton submitButton;

	public MainTest() {
		initData();
		setinitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("메모장");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		background = new ImagePanel();
		textArea = new textArea();
		submitButton = new JButton("submit");
		submitButton.setSize(100, 50);

		add(submitButton);
		add(textArea);
		add(background);
	}

	private void setinitLayout() {
		setLayout(null);
		setVisible(true);
		submitButton.setVisible(true);
		submitButton.setLocation(200, 350);
		submitButton.setBackground(Color.ORANGE);
	}

	private void addEventListener() {
		submitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String s = textArea.getText().toString();
					textArea.bw.write(s);
					textArea.bw.flush();
					textArea.bw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
	}

	private class ImagePanel extends JPanel {
		private BufferedImage backImage;

		public ImagePanel() {
			setSize(600, 700);
			try {
				backImage = ImageIO.read(new File("background.png"));
			} catch (IOException e) {
				System.out.println("파일이 없습니다.");
			}
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(backImage, 0, 0, 500, 500, null);
		}

	}

	private class textArea extends JTextArea {
		private File file;
		private BufferedWriter bw;

		public textArea() {
			setSize(400, 200);
			setLocation(45, 50);
			setBackground(Color.white);
			setVisible(true);
			setFont(new Font("Kristen ITC", 0, 20));
			file = new File("memo.txt");
			try {
				bw = new BufferedWriter(new FileWriter(file));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new MainTest();
	}
}
