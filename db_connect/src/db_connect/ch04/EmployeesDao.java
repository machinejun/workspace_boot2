package db_connect.ch04;

public interface EmployeesDao {
	
	
	void runService();
	
	void checkEmployeeInfo(String employeesid);
	
	void searchHigherSalary(String departCode);
	
	void countDepartStaff(String departCode);
	
	void searchStaffPositon(String employeesid);
	
	void checkYearsOfStaff(int year);

}
