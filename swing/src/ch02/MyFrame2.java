package ch02;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame2 extends JFrame {
	private BorderLayout borderLayout;
	private ArrayList<JButton> buttons = new ArrayList<JButton>(5); // 어레이리스트는 처음 사이즈가 없기 때문에
	private List<String> arr_titles = new ArrayList<String>();
	private List<String> arr_directions = new ArrayList<String>();
	private String[] titles = { "북", "센터", "남", "동", "서" };
	private String[] driections = { 
			BorderLayout.NORTH, 
			BorderLayout.CENTER, 
			BorderLayout.SOUTH, 
			BorderLayout.EAST,
			BorderLayout.WEST };
	
	public MyFrame2() {
		initData();
		setInitLayout();
	}
	
	private void initData() {
		setTitle("BorderLayout Test");
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		borderLayout = new BorderLayout();
		arr_titles = Arrays.asList(titles);
		arr_directions = Arrays.asList(driections);
		for (int i = 0; i < arr_titles.size(); i++) {
			buttons.add(new JButton(titles[i]));
		}
	}
	
	private void setInitLayout() {
		setLayout(borderLayout);
		for (int i = 0; i < buttons.size(); i++) {
			buttons.get(i).setSize(50, 50);
			add(buttons.get(i), arr_directions.get(i));
		}

	}
	
	public static void main(String[] args) {
		new MyFrame2();
	}
}

