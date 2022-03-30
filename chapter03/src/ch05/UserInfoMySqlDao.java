package ch05;

public class UserInfoMySqlDao implements UserInfoDao{

	@Override
	public void insertUserInfo(UserInfo userinfo) {
		System.out.println("MySql : 저장하기 id " + userinfo.getUserId());
		System.out.println("MySql : 저장하기 ps " + userinfo.getPassWord());
		System.out.println("MySql : 저장하기 name " + userinfo.getUserName());
		
	}

	@Override
	public void updateUserInfo(UserInfo userinfo) {
		System.out.println("MySql : 수정하기 id " + userinfo.getUserId());
		System.out.println("MySql : 수정하기 ps " + userinfo.getPassWord());
		System.out.println("MySql : 수정하기 name " + userinfo.getUserName());
		
	}

	@Override
	public void deleteUserInfo(String userId) {
		System.out.println("delete from dbName userId =  ' " + userId + " ' ");
		
	}
	// MYsql
}
