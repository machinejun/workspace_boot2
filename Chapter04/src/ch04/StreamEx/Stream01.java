package ch04.StreamEx;

import java.io.InputStream;

public class Stream01 {
	
	public static void main(String[] args) {
		InputStream in = System.in; // 키보드에 연결
		//1. 키보드에 A를 인코딩해서 01000001로 컴퓨터에게 전송
		//2. byte Stream으로 흘러 들어간(Input)
		//3. read() 메서드로 01000001 --> 65로 디코딩한다.
		//4. 부호화 65 -> 문자 A로 변환
		//단점 : 1byte로 통신을 하기 떄문에 1 byte 만 받는다. ex ABC > A
		// 한글은 깨져서 나온다.
		
		
		try {
			int date = in.read(); // 1byte(8bit)
			System.out.println((char)date);
		} catch (Exception e) {
			System.out.println("예외 : " + e.getMessage());
		}
	}
}
