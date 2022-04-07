package tenco.com.test_01.ch01;

public class MainTest3 {

	public static void main(String[] args) {
		// 재료
		Powder powder = new Powder();
		Plastic plastic = new Plastic();
		
		// 제네릭은 사용하는 시점에 지정된 자료형으로 컴파일 됩니다. 즉, 컴파일 되자 않았다가 사용 시점에 컴파일 됩니다.
		GenericPrinter<Powder> printer = new GenericPrinter<>();
		printer.setMaterial(powder);
		System.out.println(printer.getMaterial());
		GenericPrinter<Plastic> printer2 = new GenericPrinter<>();
		printer2.setMaterial(plastic);
		System.out.println(printer2.getMaterial());
		GenericPrinter<Water> printer3 = new GenericPrinter<>();
		System.out.println(printer3.getMaterial());
		GenericPrinter<Powder> g2 = new GenericPrinter<>();
		g2.setMaterial(powder);
		System.out.println(g2);
		
		// < T extends 클래스 > 사용하기
		// T 자료형의 범위를 제한하지 않으면 아무 클래스나 올 수 있다.
		
	}

}
