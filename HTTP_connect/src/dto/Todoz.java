package dto;

import lombok.ToString;

@ToString
public class Todoz {
	int userId;
	int id;
	String title;
	boolean completed;
}
