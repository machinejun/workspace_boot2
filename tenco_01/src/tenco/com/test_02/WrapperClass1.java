package tenco.com.test_02;

public class WrapperClass1 {
	
	public static void main(String[] args) {
		Integer num = new Integer(100);
		Number  n1 = 10;
		int n = num.intValue();
		System.out.println(n);
		System.out.println("===================");
		Integer num1 = 200; // 자동 박싱
		int num10 = num1; // 자동 언 박싱
		
	}

}
