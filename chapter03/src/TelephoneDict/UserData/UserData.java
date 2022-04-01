package TelephoneDict.UserData;

import java.util.ArrayList;


public class UserData {
	private static UserData instance;
	private ArrayList<User> users;
	
	public UserData(ArrayList<User> users) {
		this.users = users;
	}
	
	public static UserData getinstance(ArrayList<User> users) {
		if(instance == null) {
			instance = new UserData(users);	
		}
		return instance;	
	}
	
	public static UserData getinstance() {
		return instance;
	}
	
	
	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users.add(users);
	}

	public void showUsers() {
		for(int i =0; i < users.size(); i++) {
			if( users.get(i) == null) {
				continue;
			}
			System.out.println(users.get(i));
		}
	}
	
	
	
}
