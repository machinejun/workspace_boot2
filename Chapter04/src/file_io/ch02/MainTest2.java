package file_io.ch02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 
 * @author ITPS
 * 입력 스트림
 * 1. 파일에서 한 바이트씩 데이터를 읽기
 * try - with - resource : try(...) 오토 클로즈 제공
 */
public class MainTest2 {
	

	public static void main(String[] args) {
		System.out.println("start");
		System.out.println("파일에서 데이터를 읽어서 화면에 출력해 주세요");
		//FileInputStream fis = null;
		StringBuffer str = new StringBuffer();
		int c = 0;
		
		try(FileInputStream fis = new FileInputStream("boot_a.txt")) {
			do{
				c = fis.read();
				str.append((char)c);
			}while(c != -1);
			System.out.println(str);
			
		} catch (FileNotFoundException e) {
			System.out.println("not found file");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("in/output error");
			e.printStackTrace();
		}
			
			
//		try {
//			fis = new FileInputStream("boot_a.txt");
//		
//			do{
//				c = fis.read();
//				str.append((char)c);
//			}while(c != -1);
//			
//			System.out.println(str);
//			
//		} catch (FileNotFoundException e) {
//			System.out.println("not found file");
//			e.printStackTrace();
//		} catch (IOException e) {
//			System.out.println("in/output error");
//			e.printStackTrace();
//		}finally {
//			try {
//				fis.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		
		System.out.println("end");
	}

}
