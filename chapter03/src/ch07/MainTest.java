package ch07;

public class MainTest {

	public static void main(String[] args) {
		Car car1 = new Car("포니", 1011);
		Car car2 = new Car("포니", 1011);
		Car car3 = new Car("티볼리", 1021);
		
		if(car1.hashCode() == car2.hashCode()) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}
		
		
		
	}

}
