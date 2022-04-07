package StopWatch;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.lang.model.util.SimpleAnnotationValueVisitor6;
import javax.swing.JButton;
import javax.swing.JFrame;

public class StopWatch extends JFrame implements ActionListener, Runnable {
	JButton button1 = new JButton("시작");
	JButton button2 = new JButton("일시정지");
	JButton button3 = new JButton("초기화");
	
	boolean flag = true;
	long start;
	long end;

	SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.sss");

	public StopWatch() {
		setTitle("StopWatch");
		setBounds(800, 100, 300, 400);
		GridLayout grid = new GridLayout(3, 1);
		setLayout(grid);
		add(button1);
		add(button2);
		add(button3);

		button2.setEnabled(false); // 작동 안하게 함
		button3.setEnabled(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
	}

	@Override
	public void run() {
		start = System.currentTimeMillis();
		end = start;
		while (true) {

			if (!flag) {
				break;
			}

			long time = (end++) - start;
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			System.out.println(time);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("dd");
		Thread thread = new Thread(this);
		switch (e.getActionCommand()) {
		case "시작":
			System.out.println("시작");
			thread.start();
			flag = true;
			button1.setEnabled(false);
			button2.setEnabled(true);
			button3.setEnabled(false);
			break;
		case "일시정지":
			flag = false;
			button1.setEnabled(true);
			button2.setEnabled(false);
			button3.setEnabled(true);
			button1.setText("재시작");
			break;
		case "초기화":
			button1.setEnabled(true);
			button2.setEnabled(false);
			button3.setEnabled(false);
			break;
		case "재시작":
			thread.start();
			flag = true;
			button1.setEnabled(false);
			button2.setEnabled(true);
			button3.setEnabled(false);
			break;
		default:

		}

	}
	public static void main(String[] args) {
		new StopWatch();
	}
}
