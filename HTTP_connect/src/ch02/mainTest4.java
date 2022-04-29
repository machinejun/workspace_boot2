package ch02;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
class Student {
	String name;
	int age;
	String address;
}


public class mainTest4 {

	public static void main(String[] args) {
		Student[] students = new Student[3];
		Gson gson = new Gson();
		
		
 		Student student1 = new Student("홍길동", 20, "부산");
		Student student2 = new Student("이순신", 33, "서울");
		Student student3 = new Student("세종대왕", 59, "세종시");
		
		String jsoString = gson.toJson(student1);
		students[0] = student1;
		students[1] = student2;
		students[2] = student3;
		
		String studentArr = gson.toJson(students); 
		System.out.println(studentArr);
//		
//		String jsonStrArr = gson.toJson(stu);
		
//		
//		System.out.println("-----------------------------");
//		Student[] objA = gson.fromJson(studentArr, Student[].class);
//		System.out.println(objA);
//		for (Student student : objA) {
//			System.out.println(student);
//		}
		
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(student1);
		list.add(student2);
		list.add(student3);
		
		String jsonArrayStr= gson.toJson(list);
		System.out.println(jsonArrayStr);
		
		
		// 타입을 명시함
		Type studentType = new TypeToken<ArrayList<Student>>(){}.getType();
		ArrayList<Student> arrayList = gson.fromJson(jsonArrayStr, studentType);
		
		for (Student student : arrayList) {
			System.out.println(student);
		}
		
		/*
		 *  파싱하는 방법 3가지
		 *  
		 *  1. object
		 *  2. Array
		 *  3. ArrayList
		 */
		
		

//		
//		String jsonString1 = gson.toJson(sList);
//		System.out.println(jsonString1);
	}

}
