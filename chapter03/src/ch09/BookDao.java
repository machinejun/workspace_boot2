package ch09;

public interface BookDao {
	
	abstract void insertInfo(BookInfo book);
	abstract void showInfo();
	abstract void deleteInfo(String bookname);
	abstract void updateInfo(String name, BookInfo book);
	abstract void searchInfo(String bookname);
	
	

}
