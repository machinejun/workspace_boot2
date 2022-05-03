package db_connect.ch01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DB 서버와 연결하기 위한 준비물
 */
public class MainTest {
	private Connection conn; // db 커넥션 연결 객체
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "asd123";
	private static final String URL = "jdbc:mysql://localhost:3306/shopdb?serverTimezone=Asia/Seoul&characterEncoding=UTF-8";

	private Statement stmt; // String --> 쿼리구문으로 변경해주는 친구
	private ResultSet rs; // 쿼리 연산 결과값을 받아주는 친구

	public MainTest() {
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");  // reflect 기법 : 컴파일 시점 문자열 --> 런타입 시점에 실제 클래스가 존재하는지 확인, 메모리( heap ) 영역에 올라 간다.
				conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
				stmt = conn.createStatement(); // sql문을 데이터베이스로 보내기위해 만드는 친구

				String sql1 = "select * from membertbl";
				rs = stmt.executeQuery(sql1); // 주어진 sql문을 실행시키는 친구
				
				while(rs.next()) {
					String memberId = rs.getString("memberId"); // 속성 memberId의 value 값을 가지고 온다.
					String memberName = rs.getString("memberName"); // 속성 memberName의 value 값을 가지고 온다.
					System.out.println("id: " + memberId + " , " + "name: " + memberName);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
//			try {
//				conn.close(); // 여기다 쓰는것 보단 finally에 쓰게 되면 한번만 써도 됨 
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
			
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 에러 발생했을 경우 닫아준다.
		}
	}


	public static void main(String[] args) {
		new MainTest();
	} 

} 
