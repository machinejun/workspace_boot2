package ch08;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainTest {

	public static void main(String[] args) {
		
		Book book1 = new Book(1, "흐르는 강물처럼", "파울로코엘료");
		Book book2 = new Book(2, "플러터 UI 실전", "김근호");
		Book book3 = new Book(3, "무궁화 꽃이 피었습니다", "김진명");
		Book book4 = new Book(4, "리딩으로 리드하라", "이지성");
		Book book5 = new Book(5, "사피엔스", "유발하라리");
		
		// how, why ?
		// <> 제네릭 : 어떠한 데이터 타입을 담을 지 미리 지정해 준다. > add() 메서드 사용
		ArrayList<Book> books = new ArrayList<Book>();
		books.add(book1);
		books.add(book2);
		books.add(book3);
		books.add(book4);
		
		// 데이터를 꺼내는 방법 > get() 매서드 사용
		System.out.println(books.get(0));
		System.out.println(books.get(1));
		System.out.println(books.get(2));
		System.out.println(books.get(3));
		System.out.println("------------------------------");
		for (Book book : books) {
			System.out.println(book);
		}
		
		// 데이터를 삭제하는 방법
		
		books.remove(0);
		books.remove(book2);
		System.out.println(books);
		System.out.println(books.size());
		
		// 수정하기 set()
		books.set(0, book5);
		System.out.println(books.size());
		System.out.println(books.isEmpty());
		System.out.println(books.get(0));

		for (Book book : books) {
			System.out.println(book);
		}
		
		// 전부 삭제하고 싶다면 removerAll()
		books.removeAll(books);
		System.out.println(books.isEmpty());
		
		// C R U D
		
	}

}
