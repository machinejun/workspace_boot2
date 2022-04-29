package ch02;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import dto.Test;

public class mainTest {
	// JSON을 받는 것을 확인 ( 응답 )
	// JSON 형식으로 보낼수도 있다.
	// 자바 문법에서 json형식을 만드는 방법	
	
	public static void main(String[] args) {
		JsonObject jsonObject1 = new JsonObject();
		jsonObject1.addProperty("name", "홍길동");
		jsonObject1.addProperty("age", 24);
		jsonObject1.addProperty("job", "CEO");
		jsonObject1.addProperty("hobby", "노래");
		jsonObject1.addProperty("married", false);
		
		System.out.println(jsonObject1);
		System.out.println(jsonObject1.get("name"));
		System.out.println(jsonObject1.get("age"));
		System.out.println(jsonObject1.get("job"));
		System.out.println(jsonObject1.get("hobby"));
		System.out.println(jsonObject1.get("married"));
		System.out.println("----------------------------");
		// 깊은 복사와 얕은 복사 개념 이해해 보기
		
		JsonObject b = jsonObject1; // jsonObject1은 래퍼런스 주소값이 b에 담긴다. = 얕은 복사
		
		b.addProperty("hi", "hello");
		System.out.println(jsonObject1);
		System.out.println("----------------------------");
		
		JsonObject c = jsonObject1.deepCopy(); // 깊은 복사 서로 다른 래퍼런스를 가지지만 가지고 있는 오브젝트만 복사
		c.addProperty("test", 1234);
		System.out.println(jsonObject1);
		System.out.println("----------------------------------");
		//
		JsonArray array1 = new JsonArray();
		array1.add(b);
		array1.add(c);
		System.out.println(array1);
		
		System.out.println(array1.get(0));
		System.out.println(array1.get(1));
		System.out.println(array1.get(1));
		
		// 모델링 >> 하나의 오브젝트로 만들기
		Gson gson = new Gson();
		Test test = gson.fromJson(array1.get(0), Test.class);
		
		
		System.out.println(test.getName());
		System.out.println(test);
		
		// { arr : [ {}, {}, ... ] }
		
		JsonObject j1 = new JsonObject();
		JsonArray a1 = new JsonArray();
		j1.add("arr", a1);   // json객체를 넣을 때는 add를 넣어야한다.
		
		// 두개의 오브젝트가 필요함
		JsonObject t1 = new JsonObject();
		JsonObject t2 = new JsonObject();
		t1.addProperty("name", "손흥민");
		t1.addProperty("age", 26);
		// { "name" : "손흥민", "age" : 26 }
		t2.addProperty("name", "이순신");
		t2.addProperty("age", 30);
		a1.add(t1);
		a1.add(t2);
		// j1 = {"arr":[{"name":"손흥민","age":26},{"name":"이순신","age":30}]}
		
		System.out.println(j1);
		
	}
		
		
	

}
