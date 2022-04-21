package file_io.ch01;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class MainTest1 {
	public static PrintStream out;
	public static InputStream in;
	
	public static void main(String[] args) {
		//표준출력 스트림
		
		System.out.println("모니터 출력 스트림"); // >> 표준 스트림
		
		//표준입력 스트림
		try {
			int k = System.in.read();
			System.out.println("k: " + (char)k);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
				
		
	}
}
