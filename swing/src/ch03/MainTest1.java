package ch03;

import java.util.Scanner;

public class MainTest1 {

	public static void main(String[] args) {
		/*
		 *  1. MyCom .. 을 화면에 띄우세요
		 *  2. textField 안녕하세요 라는 글자를 코드로 셋팅해 주세요
		 *  
		 */
		MyComponent com = new MyComponent();
		Scanner scanner = new Scanner(System.in);
		System.out.print("글자를 입력하세요: ");
		String userInput= scanner.nextLine();
		com.jTextField.setText(userInput);
		
		

	}

}
