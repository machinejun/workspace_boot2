package ch11;

public interface BookService {
	// 북객체를 저장하는 기능
	void addBook(Book book);
	// 북객체를 수정하는 기능( ArrayList 인덱스에 접근해서 객체를 교체)
	// String title로 책 찾기
	void updateBook(String title, Book book);
	
	// 북객체를 삭제하는 기능
	void deleteBook(String title);
	
	// 책 한권의 정보를 출력하는 기능
	void selectedByTitleBook(String title);
	
	// ArrayList에 저장 되어 있는 책 정보를 전부 출력하는 기능
	void showAllBook();
	
	
	

}
