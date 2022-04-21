package ch03.pratice;

public class MainTest {

	public static void main(String[] args) {
		Activity1 activity1 = new Activity1("요청자");
		Activity2 activity2 = new Activity2("응답자");
		
		activity1.setCallbackCheck(activity2.check);

	}

}
