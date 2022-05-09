package db_connect.ch03;

import java.util.Scanner;

public class mainTest {
	public static void main(String[] args) {
		IEmployeesDao dao = new EmployeesDao();

		Scanner sc = new Scanner(System.in);

		System.out.println("------------------------------");
		System.out.println("1. 구매목록 조회");
		System.out.println("2. 회원 구매 금액");
		System.out.println("3. 지역별 베스트 품목");
		System.out.println("4. 종료");
		System.out.println("-------------------------------");
		System.out.print("입력: ");
		int i = sc.nextInt();

		if (i == 1) {
			System.out.println("-------------------------");
			System.out.print("구매목록 조회");
			System.out.print("유저 이름 입력: ");
			String name = sc.next();
			dao.innerJoin1(name);
		} else if (i == 2) {
			System.out.println("-------------------------");
			System.out.print("회원 구매 금액 조회");
			System.out.print("입력: ");
			String name = sc.next();
			dao.leftJoin1(name);
		} else if (i == 3) {
			System.out.println("-------------------------");
			System.out.print("지역별 베스트 물품 조회");
			System.out.print("입력: ");
			String name = sc.next();
			dao.leftJoin2(name);
		}

	}
}
