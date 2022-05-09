package db_connect.ch03;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserAmountUsed {
	String userName;
	int totalCost;
	int count;

}
