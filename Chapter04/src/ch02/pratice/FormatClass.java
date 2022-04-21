package ch02.pratice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FormatClass implements WriteClass{
	private String string;
	
	@Override
	public void writeSomeThing(String string) {
		 this.string = string;
		 show();
	}
	
	private String date() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		return dateFormat.format(Calendar.getInstance().getTime());
	}
	
	private void show() {
		System.out.println("-----* 메모장 *------");
		System.out.println();
		System.out.println(string);
		System.out.println();
		System.out.println("작성일: " + date());
		System.out.println("---------------------");
		
	}
	
	

}
