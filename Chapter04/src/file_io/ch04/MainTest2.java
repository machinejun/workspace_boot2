package file_io.ch04;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author ITPS
 * BufferedWriter를 이용한 파일에 문자 쓰기
 * 
 */
public class MainTest2 {
	public static void main(String[] args) {
		String text = "File Writer Test";
		String fileName = "result.txt";
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true)); // fileWriter에 덮어쓰기 값(불린값으로) 선언 할 수 있다.
			bw.write(text);
			bw.flush(); // 버퍼에 있던 모든 내용을 한꺼번에 가져온다.
			// 버퍼는 자기 공간이 다 채워지면 자동으로 전달 한다....
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
