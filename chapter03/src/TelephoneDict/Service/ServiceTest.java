package TelephoneDict.Service;

import java.util.ArrayList;
import TelephoneDict.UserData.TelephoneDict;
import TelephoneDict.UserData.User;
import TelephoneDict.UserData.UserData;

public class ServiceTest implements Service {
	private final UserData userdata;
	private ArrayList<TelephoneDict> telDicts;

	public ServiceTest() {
		this.userdata = UserData.getinstance(new ArrayList<User>());
		telDicts = new ArrayList<TelephoneDict>();
		inputTelphonNum("오니기리", "051-0000-0000");
		inputTelphonNum("051카페", "051-0000-0000");
		readTelDict();
	}

	@Override
	public void inputUser(String id, String password) {
		User user = new User(id, password);
		userdata.setUsers(user);
		System.out.println("유저가 등록되었습니다.");

	}

	@Override
	public void searchUser(String id) {
		for (User u : userdata.getUsers()) {
			if (u.getUserId().equals(id)) {
				System.out.println(u);
			}
		}

	}
	
	@Override
	public void deleteUser(String id) {
		for (int i = 0; i < userdata.getUsers().size(); i++) {
			if (userdata.getUsers().get(i).getUserId().equals(id)) {
				userdata.getUsers().remove(i);
				System.out.println("삭제 완료");
			}
		} 
		
	}


	@Override
	public void searchTelphonNum(String storeName) {
		for (TelephoneDict telephoneDict : telDicts) {
			if( telephoneDict.getStoreName().equals(storeName)) {
				System.out.println(telephoneDict);
				return;
			}
		}
		System.out.println("가게 이름을 찾을 수 없습니다.");
		
	}
	
	@Override
	public boolean login(String id, String pswd) {
		User newUser = new User(id, pswd);
		if(userdata.getUsers().contains(newUser)){
			for (User u : userdata.getUsers()) {
				if(u.equals(newUser)) {
					System.out.println("로그인 성공");
					return true;
				}
			}
		}else {
			System.out.println("회원정보(id, password)를 확인해 주세요");
		}
		return false;
	}
	
	@Override
	public void readTelDict() {
		FileRead fileRead = new FileRead();
		String sentence = "";
		sentence = fileRead.fileReadDict().replace("\r", "").replace("\n","");
		String[] arr = sentence.split("=|,");
		String s1 = "", s2 ="";
		for(int i = 0; i < arr.length;i++) {
			
			if( i%2 == 0 ) {
				s1 = arr[i];
			}else {
				s2 = arr[i];
			}
			if( i%2 == 1) {
				inputTelphonNum(s1,s2);
			}
		}
	}

	@Override
	public void inputTelphonNum(String storename, String telephonenum) {
		TelephoneDict t1 = new TelephoneDict(storename, telephonenum);
		telDicts.add(t1);

	}

}
