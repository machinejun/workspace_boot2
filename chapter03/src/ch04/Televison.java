package ch04;

public class Televison extends HomeAppliances implements RemoteController{
	private String serialNumber;
	private static int countNumber = 0;
	
	public Televison() {
		countNumber++ ;
		this.serialNumber += Integer.toString(REMOTETYPE_NUMBER) + countNumber;
	}
	
	@Override
	public void turnOn() {
		System.out.println("TV ON");
		
	}

	@Override
	public void turnOff() {
		System.out.println("TV OFF");
	}
	

	
	

}
