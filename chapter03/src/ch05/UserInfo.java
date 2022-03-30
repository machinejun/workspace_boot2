package ch05;

public class UserInfo {
	
	private String userId;
	private String passWord;
	private String userName;
	
	//get,set
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", passWord=" + passWord + ", userName=" + userName + "]";
	}
	
	
	

}
