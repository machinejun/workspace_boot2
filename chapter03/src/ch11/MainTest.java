package ch11;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {
		FileRead fileRead = new FileRead();
		System.out.println(fileRead.fileReadTxt());
	}
//		BookClient bookClient = new BookClient();
//		BookService bookArrayList = new BookArray();
//		Scanner scanner = new Scanner(System.in);
//
//		// do while 문
//		String selectedMenu = "";
//		do {
//			System.out.println("-------------------------");
//			System.out.println("1. 책 생성");
//			System.out.println("2. 책 조회");
//			System.out.println("3. 책 삭제");
//			System.out.println("4. 책 전체 조회");
//			System.out.println("5. 책 수정");
//			System.out.println("0. 프로그램 종료");
//			System.out.println("--------------------------");
//			selectedMenu = scanner.nextLine();
//			if (selectedMenu.equals("0")) {
//				System.out.println("프로그램을 종료합니다.");
//				scanner.close();
//			} else if (selectedMenu.equals("1")) {
//				System.out.println("책 제목을 입력합니다.");
//				// 북 객체 생성하는 코드
//				String title = scanner.nextLine();
//				System.out.println("작가에 이름을 입력 하세요");
//				String author = scanner.nextLine();
//				Book book = bookClient.createBook(title, author);
//				bookArrayList.addBook(book);
//
//			} else if (selectedMenu.equals("2")) {
//				System.out.println("책 제목을 입력해 주세요 -> 책 정보를 조회 합니다.");
//				String title = scanner.nextLine();
//				bookArrayList.selectedByTitleBook(title);
//				
//			} else if (selectedMenu.equals("3")) {
//				System.out.println("삭제 하려는 책 제목을 입력해 주세요");
//				String title = scanner.nextLine();
//				bookArrayList.deleteBook(title);
//
//			} else if (selectedMenu.equals("4")) {
//				System.out.println("저장 되어 있는 책 목록 조회");
//				bookArrayList.showAllBook();
//			} else if (selectedMenu.equals("5")) {
//				System.out.println("수정하려는 책 제목을 입력해 주세요");
//				String savedTitle = scanner.nextLine();
//				System.out.println("새로운 책 제목을 입력하세요");
//				String title = scanner.nextLine();
//				System.out.println("새로운 작가 이름을 입력하세요");
//				String author = scanner.nextLine();
//				Book book = bookClient.createBook(title, author);
//				bookArrayList.updateBook(savedTitle, book);
//			} else {
//				System.out.println("잘못된 입력입니다.");
//			}
//		} while (!(selectedMenu.equals("0")));
//
//	}
//	 
//	public static String removeBlankString(String str) {
//		String result1 = str.trim();
//		String result2 = result1.replace(" ", "");
//		return result2;
//	}
//	
//	public static String checkbookType() throws IOException{
//
//	}
//	
//	

}
