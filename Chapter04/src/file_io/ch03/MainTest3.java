package file_io.ch03;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * 
 * 문제  output c라는 텍스트에 D ~~ x 까지만 파일에 쓰기
 *
 */
public class MainTest3 {
	public static void main(String[] args) throws FileNotFoundException {
		FileOutputStream fos = new FileOutputStream("output_a.txt");
		try(fos){ // outoclose 역할
			byte[] bs = new byte[26];
			byte data = 65;
			//배열 A ~ Z까지 데이터를 담는다.
			for(int i = 0; i < bs.length; i++) {
				bs[i] = data;
				data++;
			}
			
			// 배열에 담겨 있는 데이터를 한꺼번에 출력
			fos.write(bs, 3, 22);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("출력 처리 끝");
	}

}
