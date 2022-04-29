package ch03;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonPratice {
	
	public static void main(String[] args) {
		JsonArray answer1 = new JsonArray();
		
		JsonObject object1 = new JsonObject();
		object1.addProperty("name", "홍길동");
		object1.addProperty("age", 20);
		object1.addProperty("address", "부산");
		
		JsonObject object2 = new JsonObject();
		object2.addProperty("name", "이순신");
		object2.addProperty("age", 33);
		object2.addProperty("address", "서울");
		
		JsonObject object3 = new JsonObject();
		object3.addProperty("name", "세종대왕");
		object3.addProperty("age", 59);
		object3.addProperty("address", "세종시");
		
		answer1.add(object1);
		answer1.add(object2);
		answer1.add(object3);
		
		JsonObject answer2 = new JsonObject();
		JsonArray arr1 = new JsonArray();
		answer2.add("todoList", arr1);
		
		JsonObject object4 = new JsonObject();
		object4.addProperty("id", 1);
		object4.addProperty("title", "청소");
		object4.addProperty("complete", false);
		
		JsonObject object5 = new JsonObject();
		object4.addProperty("id", 2);
		object4.addProperty("title", "영어공부");
		object4.addProperty("complete", true);
		
		arr1.add(object4);
		arr1.add(object5);
		answer2.addProperty("server_name", "server_1");
		
		System.out.println(answer1);
		System.out.println(answer2);
		Gson gson = new Gson();
		Server server = gson.fromJson(answer2, Server.class);
		System.out.println(server);
		
	}
}
