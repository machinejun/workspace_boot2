package db_connect.ch02;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
	@NonNull
	private String memberid;
	@NonNull
	private String memberName;
	private String memberAddress;

}
