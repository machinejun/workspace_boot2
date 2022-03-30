package ch05;

import java.util.Scanner;

public class UserInfoClient {
	
	public static final String MYSQL = "mysql";
	public static final String ORACLE = "oracle";
	
	public static void main(String[] args) {
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
		}  
	}

}
