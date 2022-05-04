package db_connect.ch02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MemberInfoDao implements IMemberInfoDao {

	// DBClient를 통해서 DB접속 처리를 하자
	private DBClient dbClient;
	private Connection conn;

	private static final String TABLE_NAME = "memberTBL";


	public MemberInfoDao() {
		dbClient = DBClient.getinstance();
		conn = dbClient.getConnection();
	}

	@Override
	public ArrayList<MemberDto> select() {
		
		ArrayList<MemberDto> memberList = new ArrayList<MemberDto>();
		String sqlFormat;
		String sql;

		sqlFormat = "SELECT * FROM %s";
		sql = String.format(sqlFormat, TABLE_NAME);

		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				MemberDto dto = new MemberDto();
				dto.setMemberid(rs.getString("memberid"));
				dto.setMemberName(rs.getString("memberName"));
				dto.setMemberAddress(rs.getString("memberAddress"));
				memberList.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return memberList;
		
		
	}

	@Override
	public int insert(MemberDto dto) {
		String sqlFormat = "INSERT INTO %s VALUES('%s', '%s', '%s')";
		String sql = String.format(sqlFormat, TABLE_NAME ,dto.getMemberid(), dto.getMemberName(), dto.getMemberAddress());
		
		Statement stmt = null;
		int result = 0;
		
		try {
			stmt = conn.createStatement();
			//result = stmt.executeUpdate(sql);
			stmt.executeQuery(sql);
			System.out.println("result(row 갯수) :" + result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		return result;

	}
	@Override
	public int update(MemberDto dto) {
		// 해당 레코드 존재 여부를 검사가 필요하다.
		
		String sqlFormat = "UPDATE %s SET memberName = '%s' WHERE memberId = '%s'";
		String sql = String.format(sqlFormat, TABLE_NAME, dto.getMemberName(), dto.getMemberid());
		int result = 0;
		
		try(Statement stmt = conn.createStatement()){
			result = stmt.executeUpdate(sql);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;

	}
	
	@Override
	public int delete(String memberId) {
		String sqlFormat = "DELETE FROM %s WHERE memberId = '%s' ";
		String sql = String.format(sqlFormat, TABLE_NAME ,memberId );
		int result = 0;
		
		try(Statement stmt = conn.createStatement()){
			result = stmt.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	

}
