package tenco.com.test_01.ch01;

public class MainTest2 {

	public static void main(String[] args) {
		
		Powder powder = new Powder();
		Plastic plastic = new Plastic();
		
		ThreeDPrinter1 dPrinter1 = new ThreeDPrinter1();
		// 재료 세팅
		dPrinter1.setMaterial(plastic);
		
		ThreeDPrinter2 dPrinter2 = new ThreeDPrinter2();
		dPrinter2.setMaterial(powder);
		
		ThreeDPrinter3 dPrinter3 = new ThreeDPrinter3();
		dPrinter3.setMaterial(powder);
		dPrinter3.setMaterial(plastic);
		
		// dp1 재료 꺼내기
		Plastic getPlastic = dPrinter1.getMaterial();
		System.out.println(getPlastic);
		// dp2 재료 꺼내기
		Powder getPowder = dPrinter2.getMaterial();
		System.out.println(getPowder);
		// dp3 > 코드를 살펴보고 형변환을 해야하는 번거로움이 생김
		Plastic getPlastic2 = (Plastic) dPrinter3.getMaterial();
		System.out.println(getPlastic2);
	}

}
