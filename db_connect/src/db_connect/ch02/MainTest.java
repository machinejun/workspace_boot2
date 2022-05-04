package db_connect.ch02;

import java.util.ArrayList;

public class MainTest {
	public static void main(String[] args) {
		MemberInfoDao dao = new MemberInfoDao();
		ArrayList<MemberDto> data = dao.select();
		System.out.println(data);
		dao.insert(new MemberDto("ABC", "애뷔씨", "에이비쒸 나라"));
		dao.update(new MemberDto("ABC", "강감찬", "서울시 동작구"));
		int returnRow = dao.delete("ABC");
		System.out.println(returnRow);
		
		
	}

}
