package ch11;

import java.util.ArrayList;
import java.util.Arrays;

public class BookArray implements BookService{
	Book[] books = new Book[10];

	@Override
	public void addBook(Book book) {
		for (int i = 0; i < books.length; i++) {
			if(books[i] == null) {
				books[i] = book;
				showAllBook();
				return;
			}
		}
		System.out.println("저장할 공간이 부족합니다.");	
	}

	@Override
	public void updateBook(String title, Book book) {
		for (int i = 0; i < books.length; i++) {
			if(books[i] == null) {
				continue;
			}else if(books[i].getTitle().equals(title)) {
				books[i] = book;
				showAllBook();
				return;
			}
		}
		System.out.println( title + " 책의 이름이 존재하지 않습니다.");
	}

	@Override
	public void deleteBook(String title) {
		ArrayList<Book> tempbooks = new ArrayList<Book>(Arrays.asList(books));
		for (int i = 0; i < tempbooks.size(); i++) {
			if(tempbooks.get(i).getTitle().equals(title)) {
				tempbooks.remove(i);
			}	
		}
		for (Book book : tempbooks) {
			addBook(book);
		}
		System.out.println( title + " 책의 정보를 삭제하였습니다.");
	}

	@Override
	public void selectedByTitleBook(String title) {
		for (int i = 0; i < books.length; i++) {
			if(books[i] == null) {
				continue;	
			}else if(books[i].getTitle().equals(title)){
				System.out.println(books[i]);
				return;
			}
		}
		System.out.println( title + " 책의 이름이 존재하지 않습니다.");
	}

	@Override
	public void showAllBook() {
		for (int i = 0; i < books.length; i++) {
			if(books[i] == null) {
				continue;
			}else {
				System.out.println(books[i]);
			}
		}
	}
	
}
