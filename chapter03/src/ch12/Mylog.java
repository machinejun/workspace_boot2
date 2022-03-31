package ch12;

import java.util.logging.Logger;

class Student {
	String name;
	int grade;
}


public class Mylog {
	
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("MyLog");
		Student student = null;
		
		try {
			student.name = "홍길동";
		} catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("-----------------------------------");
			logger.warning("오류 확인 : " + e.toString()); // 날짜 시간까지 확인 할 수 있다.
		}
		System.out.println("여기 코드 실행 확인 !!!!!");
		
	}
	// 로그 남겨보기
	
}
