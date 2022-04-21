package ch02;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalenderMainTest {
	
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getTimeInMillis());
		// 1650416859556 현재시간 (1000분에 1초를 나타내는 것) -> 영어권,아시아,유럽 날짜 포맷은 다르다
		// 보여주는 방식은 각자 알아서 구현해 >> 보기 불편한 형식을 편하게 변환해서 사용하는 방법을 알아보자
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		String date = format.format(calendar.getTimeInMillis());
		System.out.println(date);
		
	}
}
