package file_io.ch01;

import java.io.IOException;

public class MainTest2 {
	
	public static void main(String[] args) {
		System.out.println("알파벳 여러개 쓰고 enter");
		int i;
		
		try {
//			i = System.in.read();
//			System.out.println(i);
			
			//A B \n(엔터) -> false = 반복문 종료
			while((i = System.in.read()) != '\n') {
				System.out.println("i: " + i + " " );
				System.out.println((char)i);
				System.out.println("\t");
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
