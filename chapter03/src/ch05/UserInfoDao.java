package ch05;

public interface UserInfoDao {
	
	void insertUserInfo(UserInfo userinfo);
	void updateUserInfo(UserInfo userinfo);
	void deleteUserInfo(String userId);
	
}
