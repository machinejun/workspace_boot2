package ch09;

import java.util.Scanner;

public class InputInfo implements InputBookInfo{
	BookInfo book;
	Scanner sc;
	
	public InputInfo() {
		sc = new Scanner(System.in);
	}
	
	@Override
	public BookInfo insertBookInfo() {
		String name = null, publisher = null, author = null;
		
		System.out.println("----------------------------");
		System.out.println("책 정보를 입력하세요");
		System.out.print(" 책 이름 : ");
		name = sc.next();
		System.out.print(" 출판사 : ");
		publisher = sc.next();
		System.out.print(" 저자 : ");
		author = sc.next();
		System.out.println("------------------------------");
		book = new BookInfo(name, publisher, author);
		return book;
		
	}

	@Override
	public String insertbookName() {
		String name = null;
		System.out.println("------------------------");
		System.out.print("책 제목 : ");
		name = sc.next();
		return name;
	}
	
	@Override
	public BookInfo updateBookInfo() {
		String name = null, publisher = null, author = null;
		
		System.out.println("----------------------------");
		System.out.println("수정하실 책 정보를 입력하세요");
		System.out.print(" 책 이름 : ");
		name = sc.next();
		System.out.print(" 출판사 : ");
		publisher = sc.next();
		System.out.print(" 저자 : ");
		author = sc.next();
		System.out.println("------------------------------");
		book = new BookInfo(name, publisher, author);
		return book;
	}
	

}
