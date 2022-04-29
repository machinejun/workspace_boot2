package ch03;

import java.util.ArrayList;
import java.util.List;

import lombok.ToString;
@ToString
class Todo{
	int id;
	String title;
	boolean complete;
}

@ToString
public class Server {

	private String server_name;
	private List<Todo> todoList = new ArrayList<Todo>();
	
	
	public List<Todo> getTodoList() {
		return this.todoList;
	}
	public void setTodoList(List<Todo> todoList) {
		this.todoList = todoList;
	}
	
	
	
}

