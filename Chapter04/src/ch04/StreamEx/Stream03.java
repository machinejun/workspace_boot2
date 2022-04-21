package ch04.StreamEx;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Stream03 {
	
	public static void main(String[] args) {
		InputStream in = System.in;
		InputStreamReader ir = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(ir); // String 타입으로도 받을 수 있다.
		// 보조 스트림은 직접 읽고, 쓰는 기능이 없기 때문에 매개변수로 포함시켜서 사용한다.
		
		try {
			//"HEL" + "LLO"
			String data = br.readLine();
			System.out.println(data);
		} catch (Exception e) {
			System.out.println("예외 : " + e.getMessage());
		}
	}
}
