package db_connect.ch01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * producttbl 자료 가지고 오기
 * @author ITPS
 *
 */
public class MainTest3 {
	private Connection conn;
	private static final String USERNAME = "root";
	private static final String PASSWORD = "asd123";
	private static final String URL = "jdbc:mysql://localhost:3306/shopdb?serverTimezone=Asia/Seoul&characterEncoding=UTF-8";
	
	private Statement statement;
	private ResultSet resultSet;
	
	public MainTest3() {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
