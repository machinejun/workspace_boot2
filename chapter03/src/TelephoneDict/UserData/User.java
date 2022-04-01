package TelephoneDict.UserData;

import java.util.Objects;

public class User {
	private String userId;
	private String passWord;
	
	public User(String userId, String passWord) {
		super();
		this.userId = userId;
		this.passWord = passWord;

	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", passWord=" + passWord + "]";
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(passWord, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(passWord, other.passWord) && Objects.equals(userId, other.userId);
	}
	
	
	
	
	
	
	

}
