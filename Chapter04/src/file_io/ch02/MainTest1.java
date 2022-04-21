package file_io.ch02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 
 * @author ITPS
 * 입력 스트림
 * 1. 파일에서 한 바이트씩 데이터를 읽기
 * 
 */
public class MainTest1 {

	public static void main(String[] args) {
		FileInputStream fis = null;
		// 파일 전용 inputstream
		String str = "";
		try {
			fis = new FileInputStream("boot_a.txt");
		
			while(fis.read() != -1) {
				str += (char)fis.read();
			}
			System.out.println(str);
		} catch (FileNotFoundException e) {
			System.out.println("not found file");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("in/output error");
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		

	}

}
