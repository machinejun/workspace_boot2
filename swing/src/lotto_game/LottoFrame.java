package lotto_game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

import javax.swing.*;

public class LottoFrame extends JFrame implements ActionListener{
	private JButton startButton;
	private int[] lottoNumbers = new int[LottoSuffile.lottoCount];
	LottoSuffile lottosufiling = new LottoSuffile();
	
	public LottoFrame() {
		setTitle("lotto program");
		setSize(600 , 400);
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		startButton = new JButton("suffiling");
		add(startButton, BorderLayout.NORTH);
		startButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		lottoNumbers = lottosufiling.getLotto();
		// 그림을 다시 그려라
		repaint();
		
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.black);
		Font font = new Font("궁서체", Font.BOLD, 20);
		g.setFont(font);
		if(lottoNumbers[0] == 0 ) {
			g.drawString("로또 버튼을 클릭하세요", 50, 100);
			return;
		}
		Graphics2D g2d = (Graphics2D)g;
		// lottoNumber의 값이 있다면(6개 번호를 생성한 후)
		// 여기서 번호를 그려봅시다.
		for(int i = 0; i < lottoNumbers.length; i++) {
			g.drawString(Integer.toString(lottoNumbers[i]), 50 + (i*100), 200);
			g2d.drawOval(35 + (i * 100), 167, 50, 50);
		}
	}
	
	public static void main(String[] args) {
		new LottoFrame();
	}
	
	

}
