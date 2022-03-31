package ch12;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MyException {
	String fileName;
	public MyException(String fileName) {
		this.fileName = fileName;
	}
	
	/*
	 * throws : 던지기 ( 사용하는 사람, 개발자가 직접 예외 처리를 해라고 지시 함)
	 * 
	 */
	public String readFile() throws IOException{  //  IOException의 예외를 던짐 > 사용자에게 책임을 떠넘김
		
		FileInputStream fis = new FileInputStream(this.fileName);
		Properties properties = new Properties();
		properties.load(fis);
		
		String dbType = properties.getProperty("DBTYPE");
		
		return dbType;
	}
	
	public static void main(String[] args) {
		String dbType = null;
		MyException my = new MyException("a.txt");
		
		try {
			dbType = my.readFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("결과값 : " + dbType );
		
	}// end of main
}
