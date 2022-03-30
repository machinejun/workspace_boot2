package ch06;

import java.util.Objects;

public class Book {
	private int bookId;
	private String title;
	public Book(int bookId, String title) {
		super();
		this.bookId = bookId;
		this.title = title;
	}
	
	public boolean inSameBook(Book book) {
		if(book.title.equals(this.title)) {
			return true;
		}else {
			return false;
		}
	}
	
	
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(bookId, title);
	}
	
	// 북이라는 클래스에 타이틀이 같은 녀석이면 같은 객체다 라고 재정의 했음 
	@Override
	public boolean equals(Object obj) {
		if ( obj instanceof Book) {
			Book tempBook = (Book)obj;
			String title  = tempBook.title;
			if(this.title == title) {
				return true;
			}else {
				return false;
			}
		}
		return false;

	}
}
