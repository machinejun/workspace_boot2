package db_connect.ch03;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Getter
@Setter
public class ParchaseInfo {
	String userName;
	String birthYear;
	String addresss;
	String mobileNum;
	String prodName;
	int price;
	int amount;

}
