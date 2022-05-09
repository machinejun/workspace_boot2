package db_connect.ch03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db_connect.ch02.DBClient;

public class mainTest1 {
	
	public static void main(String[] args) {
		// Object는 메인메서드에서 new하기 떄문에 언제 테어나서 언제 죽을수 있는것을 말하고
		// static 만들어진 녀석들은 프로그램 시작과 끝으로만 처리된다.
		//DBclient.getInstance() (new)
		DBClient client = DBClient.getinstance();
		Connection connection = client.getConnection();
		ResultSet resultSet = null;
		
		// 데이터 한건 조회
		//Statement stmt = connection.createStatement();
		
		
		try {
			String selectQuery1 = "SELECT * FROM memberTBL WHERE memberId = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery1);
			preparedStatement.setString(1, "jsa");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println(resultSet.getString("memberId"));
				System.out.println(resultSet.getString("memberName"));
				System.out.println(resultSet.getString("memberAddress"));
			}
			
			System.out.println("-------------------------------------");
			String selectQuery2 = "SELECT * FROM memberTBL WHERE memberId IN(?, ?)";
			preparedStatement = connection.prepareStatement(selectQuery2);
			preparedStatement.setString(1, "jsa");
			preparedStatement.setString(2, "Han");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println(resultSet.getString("memberId"));
				System.out.println(resultSet.getString("memberName"));
				System.out.println(resultSet.getString("memberAddress"));
				System.out.println("--------------------------------------");
			}
			
			// 데이터 등록
			
//			String insertQuery = "INSERT INTO memberTBL values(?, ?, ?)";
//			preparedStatement = connection.prepareStatement(insertQuery);
//			preparedStatement.setString(1, "boot1");
//			preparedStatement.setString(2, "개발자");
//			preparedStatement.setString(3, "서울 판교");
//			int resultCount = 0;
//			resultCount = preparedStatement.executeUpdate();
//			if(resultCount >= 1) {
//				System.out.println("정상 등록되었습니다.");
//			}else {
//				System.out.println("동일한 아이디가 존재하거나 잘못된 입력입니다.");
//			}
			
			//데이터 수정
			
			String updateQuery = "UPDATE memberTBL SET memberName = ? WHERE memberId = ?";
			preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1,"이름변경1");
			preparedStatement.setString(2,"boot1");
			
			int updateCount = preparedStatement.executeUpdate();
			System.out.println("updateCount : " + updateCount);
			
			//데이터 삭제
			String deleteQuery = "DELETE FROM memberTBL WHERE memberID = ?";
			preparedStatement = connection.prepareStatement(deleteQuery);
			preparedStatement.setString(1, "boot1");
			
			int deleteCount = preparedStatement.executeUpdate();
			System.out.println(deleteCount);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
