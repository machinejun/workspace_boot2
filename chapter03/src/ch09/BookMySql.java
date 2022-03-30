package ch09;

import java.util.ArrayList;

public class BookMySql implements BookDao{
	ArrayList<BookInfo> books;
	
	public BookMySql() {
		books = new ArrayList<BookInfo>();
	}
	
	
	@Override
	public void insertInfo(BookInfo book) {
		if( book != null) {
			System.out.println("책 정보 추가 완료");
			books.add(book);
		}else {
			System.out.println("error");
		}
	}

	@Override
	public void showInfo() {
		if(books.isEmpty()) {
			System.out.println("목록이 비어있습니다.");
		}else {
			for(BookInfo book : books) {
				System.out.println("[전체 책 목록]");
				System.out.println(book);
			}
		}
	}

	@Override
	public void deleteInfo(String bookname) {	
		if(books.isEmpty()) {
			System.out.println("목록이 비어있습니다.");
		}else {
			for (int i = 0; i <books.size(); i++) {
				if(books.get(i).getBookName().equals(bookname)) {
					books.remove(i);
					System.out.println("책 정보 삭제 완료");
				}else {
					System.out.println("책 정보를 찾을 수 없습니다.");
				}
			}	
		}
	}

	@Override
	public void searchInfo(String bookname) {		
		if(books.isEmpty()) {
			System.out.println("목록이 비어있습니다.");
		}else {
			for (BookInfo book : books) {
				if(book.getBookName().equals(bookname)) {
					System.out.println("[책 정보]");
					System.out.println(book);
					return;
				}else {
					System.out.println("책 정보를 찾을 수 없습니다.");
				}
			}	
		}
	}
	
	@Override
	public void updateInfo(String name, BookInfo book) {
		if(books.isEmpty()) {
			System.out.println("목록이 비어있습니다.");
		}else {	
			for(int i = 0; i < books.size() ;i++) {
				if(books.get(i).getBookName().equals(name)) {
					books.set(i, book);
					System.out.println("수정 완료");
				}else {
					System.out.println("책 정보를 찾을 수 없습니다.");
				}
			}
		} 
	}
		
		
}
	
	

