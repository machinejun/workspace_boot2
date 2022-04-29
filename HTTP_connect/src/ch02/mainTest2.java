package ch02;

import java.util.ArrayList;

import com.google.gson.Gson;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
class Student {
	String name;
	int age;
	String address;
}


public class mainTest2 {

	public static void main(String[] args) {
		Student student1 = new Student("홍길동", 20, "부산");
		Student student2 = new Student("이순신", 33, "서울");
		Student student3 = new Student("세종대왕", 59, "세종시");
		
		// object를 형식이 있는 문자열로 바꾼다.
		Gson gson = new Gson();
		String jsoString = gson.toJson(student1);
		System.out.println(jsoString);
		
		//ArrayList<Object> ---> jsonArray[object]
		ArrayList<Student> sList = new ArrayList<Student>();
		sList.add(student1);
		sList.add(student2);
		sList.add(student3);
		
		String jsonString1 = gson.toJson(sList);
		System.out.println(jsonString1);
	}

}
