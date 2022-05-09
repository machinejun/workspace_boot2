package db_connect.ch03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db_connect.ch02.DBClient;

public class EmployeesDao implements IEmployeesDao{
	private DBClient db ;
	private Connection connection;
	ResultSet result;
	private ArrayList<ParchaseInfo> listEmployee = new ArrayList<ParchaseInfo>(); 
	
	public EmployeesDao() {
		db = DBClient.getinstance();
		connection = db.getConnection();
	}
	
	//userTbl, buyTbl 결과 *
	@Override
	public void innerJoin1(String userName) {
		
		try {
			result = null;
			String innerJoinQuery = " select * from userTBL as A "
										+ " inner join buyTBL as B "
										+ " on A.userName = B.userName"
										+ " where A.userName = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(innerJoinQuery);
			preparedStatement.setString(1, userName);
			result = preparedStatement.executeQuery();
			
			
			while(result.next()) {
				ParchaseInfo Info = new ParchaseInfo();
				Info.setUserName(result.getString("userName"));
				Info.setBirthYear(result.getString("birthYear"));
				Info.setAddresss(result.getString("addresss"));
				Info.setMobileNum(result.getString("mobileNum"));
				Info.setProdName(result.getString("prodName"));
				Info.setPrice(result.getInt("price"));
				Info.setAmount(result.getInt("amount"));
				listEmployee.add(Info);
				
			}
			
			for (ParchaseInfo employeeDto : listEmployee) {
				System.out.println(employeeDto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void leftJoin1(String userName) {
		try {
			result = null;
			String leftJoinQuery = "select A.username, sum(price * amount) as 'totalCost', count(B.username) as 'Count'\r\n"
					+ "from usertbl as A\r\n"
					+ "left join buytbl as B \r\n"
					+ "on A.userName = B.userName\r\n"
					+ "where a.userName = ?\r\n"
					+ "group by A.username";
			PreparedStatement preparedStatement = connection.prepareStatement(leftJoinQuery);
			preparedStatement.setString(1, userName);
			result = preparedStatement.executeQuery();
			
			while(result.next()) {
				UserAmountUsed info = new UserAmountUsed();
				info.setUserName(result.getString("userName"));
				info.setTotalCost(result.getInt("totalCost"));  
				info.setCount(result.getInt("Count"));
				System.out.println(info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void leftJoin2(String address) {
		
		try {
			result = null;
			String leftJoinQuery2 = "select addresss, prodName, max(amount)\r\n"
					+ "from usertbl as A\r\n"
					+ "left join buytbl as B \r\n"
					+ "on A.userName = B.userName\r\n"
					+ "where A.addresss = ?\r\n"
					+ "group by addresss";
			PreparedStatement preparedStatement;
			preparedStatement = connection.prepareStatement(leftJoinQuery2);
			preparedStatement.setString(1, address);
			result = preparedStatement.executeQuery();
			
			while (result.next()) {
				System.out.println("지역: " + result.getString("addresss"));
				System.out.println("가장 잘팔린 제품: " + result.getString("prodName"));
				System.out.println("개수: " + result.getString("max(amount)"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
