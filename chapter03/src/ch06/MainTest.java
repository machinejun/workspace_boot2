package ch06;

public class MainTest {

	public static void main(String[] args) {
		Book book1 = new Book(1, "흥부전");
		Book book2 = new Book(2, "홍길동전");
		Book book3 = new Book(3, "흥부전");
		Book book4 = new Book(4, "호박전");
		Student student = new Student();
		
		/* Object --> equals
		 * 오버라이드(필요에 따라)
		 * 매개변수 참조값(주소)를 받아서 코딩한다.
		 * instanceof
		 * if else
		 */
		
		if(book1.inSameBook(book3)) {
			System.out.println("같은 책 입니다.");
		}else {
			System.out.println("다른 책 입니다.");
		}
		
		
//		System.out.println(book1);
//		
//		if(book1.equals(student)) {
//			System.out.println("같은 책입니다.");
//		}else {
//			System.out.println("다른책입니다.");
//		}
	}

}
