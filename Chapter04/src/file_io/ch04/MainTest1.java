package file_io.ch04;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author 문자단위 출력 스트림 파일에 문자 쓰기 -1
 */
public class MainTest1 {

	public static void main(String[] args) {

		try (FileWriter fw = new FileWriter("writer_1.txt")) {
			fw.write('A'); // 문자 하나 출력
			char[] buf = {'B', 'C', 'D', 'E', 'F', 'G'};
			fw.write(buf); // char
			fw.write("\t안녕하세요\n  ~  가나다라마"); //string
			fw.write(buf, 1,3);
			fw.write("65");
			fw.write(56);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
