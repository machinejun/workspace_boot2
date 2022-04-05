package V2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LottoFrame2 extends JFrame{
	
	private JButton startbutton;
	private int[] lotto = new int[LottoNumber.LOTTO_NUM_SIZE];
	private LottoNumber lottoNumber;
	private LottoPanel panel;
	
	
	public LottoFrame2() {
		initData();
		setInitLayout();
		addEventListener();
	}
	
	private void initData() {
		setTitle("로또 번호 만들기");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startbutton = new JButton(">>로또 번호 생성하기<<");
		panel = new LottoPanel();
		lottoNumber = new LottoNumber();
		
	}
	
	private void setInitLayout() {
		setVisible(true);
		setBackground(Color.LIGHT_GRAY);
		add(startbutton, "North");
		add(panel, "Center");
	}
	
	private void addEventListener() {
		startbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lotto = lottoNumber.getLottoNumber();
				repaint();
			}
		});
	}
	
	private class LottoPanel extends JPanel{
		private JPanel panel;
		
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.setColor(Color.black);
			g.setFont(new Font("d2coding", Font.BOLD, 20));
			if(lotto[0] == 0) {
				g.drawString("로또 번호를 클릭하세요", 200, 200);
				return;
			}
			
			int xPosition = 50;
			Graphics2D g2d = (Graphics2D)g;
			// grahics2d : grahics를 상속받은 클래스이며 좀 더 정교한 표현이 가능하게 만든 클래스이며 기하적 그림, 좌표 이동, 생상관리 등이 가능하다.
			for(int i = 0; i < lotto.length; i++) {
				g.drawString(Integer.toString(lotto[i]), xPosition, 200);
				xPosition += 100;
				g2d.drawOval(35 + (i * 100), 167, 50, 50);
			}
			
		}
		
	}
}
