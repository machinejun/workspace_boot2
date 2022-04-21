package ch04.StreamEx;

import java.io.InputStream;
import java.io.InputStreamReader;

public class Stream02 {
	
	public static void main(String[] args) {
		InputStream in = System.in;
		InputStreamReader ir = new InputStreamReader(in); 
		// 데코레이터 패턴   65  -> A 자동
		// 추가적인 기능 추가적인 문자를 받을 수 있다.
		
		// 단점 : 
		try {
			//int date = in.read(); // 1byte(8bit)
			char[] data = new char[3];
			//char[1000] > A 만 받을 경우-> 999 공간 낭비 || 1001글자 입력 받지 못함
			//잘 사용하지 않음 (특히 통신) --> 해결 방안 buffer
			
			
			ir.read(data);
			System.out.println(data);
		} catch (Exception e) {
			System.out.println("예외 : " + e.getMessage());
		}
	}
}
