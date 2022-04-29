package dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Test {

	private String name;
	private int age;
	private String job;
	private String hobby;
	private boolean married;
	
	// 필요 없는 값이면 만들지 않아도 된다.
}
