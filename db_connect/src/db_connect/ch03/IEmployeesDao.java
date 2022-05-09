package db_connect.ch03;

public interface IEmployeesDao {
	
	//userTbl, buyTbl 결과 *
	void innerJoin1(String userName);
	
	//userTbl, buyTbl null 제거, 결과 *
	void leftJoin1(String userName);
	
	void leftJoin2(String address);
}
