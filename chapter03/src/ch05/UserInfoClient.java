package ch05;

import java.util.Scanner;

public class UserInfoClient {
	
	public static final String MYSQL = "mysql";
	public static final String ORACLE = "oracle";
	
	public static void main(String[] args) {
		// 사용자한테 userInfo라는 정보를 받는다.
		Scanner sc = new Scanner(System.in);
		UserInfo info = new UserInfo();
		
		System.out.print("id : ");
		info.setUserId(sc.next());
		System.out.print("ps : ");
		info.setPassWord(sc.next());
		System.out.print("name : ");
		info.setUserName(sc.next());
		sc.close();
		
		String str = "oracle";
		UserInfoDao userInfoDao = null;
		
		// 중복한 부분 최대한 없애기
		if(str.equals(MYSQL)) {
			userInfoDao = new UserInfoMySqlDao();	
		}else if(str.equals(ORACLE)) {
			userInfoDao = new UserInfoOracleDao();
		}else {
			System.out.println("너는 누군데?");
		}
		
		if( userInfoDao != null) {
			userInfoDao.insertUserInfo(info);
		}  // 방어적 코드 기억하기
		
		/* 인터페이스를 활용
		 * 1. A 회사 mySql 사용
		 * 2. B 회사 oracle 사용
		 */
//		UserInfoMySqlDao mySqulDao = new UserInfoMySqlDao();
//		mySqulDao.insertUserInfo(info);
//		UserInfoOracleDao oracleDao = new UserInfoOracleDao();
//		oracleDao.insertUserInfo(info);
		
		// 문자열을 비교할 때는 equals라는 것을 사용한다.
//		String str = new String("mysql");
//		if("mysql".equals(MYSQL)) {
//			System.out.println("문자열이 같습니다.");
//		}else {
//			System.out.println("문자열이 다릅니다.");
//		}
		
		// 1번 . mysql이라는 문자열이면 > myuserInfoMysql	
	}

}
