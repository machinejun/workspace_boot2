package file_io.ch03;

import java.io.FileOutputStream;

/**
 * @author ITPS
 * 바이트 단위 출력
 * 파일에 한 바이트씩 쓰기 -1
 */
public class MainTest1 {
	public static void main(String[] args) {
		// fileoutputStream은 파일이 없다면 파일을 자동으로 생성 해줌 
		try(FileOutputStream fos = new FileOutputStream("output_a.txt",true)){
			/* 1
			 * 2
			 * 3
			 * 4
			 * 5
			 */
			fos.write(65);
			fos.write(66);
			fos.write(67);
			fos.write('C');
			fos.write('D');
			fos.write('E');
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("출력 처리 끝");
	}

}
