package ch09;

import java.util.Objects;

public class BookInfo {
	private String bookName;
	private String publisher;
	private String author;
	
	public BookInfo(String bookName, String publisher, String author) {
		this.bookName = bookName;
		this.publisher = publisher;
		this.author = author;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookCode() {
		return publisher;
	}

	public void setBookCode(String bookCode) {
		this.publisher = bookCode;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(author, bookName, publisher);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookInfo other = (BookInfo) obj;
		return Objects.equals(author, other.author) && Objects.equals(bookName, other.bookName)
				&& Objects.equals(publisher, other.publisher);
	}

	@Override
	public String toString() {
		return "BookInfo [bookName=" + bookName + ", bookCode=" + publisher + ", author=" + author + "]";
	}
	
	
	

}
