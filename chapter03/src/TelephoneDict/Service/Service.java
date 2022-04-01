package TelephoneDict.Service;

import TelephoneDict.UserData.TelephoneDict;

public interface Service {
	
	public void inputUser(String id, String password);
	public void searchUser(String id);
	public void deleteUser(String id);
	public boolean login(String id, String pswd);
	public void inputTelphonNum(String storeName, String telephoneNum);
	public void searchTelphonNum(String storeName);
	void readTelDict();

}
