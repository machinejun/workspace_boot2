package ch04;

public class ToyRobot implements RemoteController, SoundEffect{
	String name;
	
	public ToyRobot() {
		this.name = "조종 로봇";
	}

	@Override
	public void turnOn() {
		System.out.println("로봇 ON");
		
	}

	@Override
	public void turnOff() {
		System.out.println("로봇 Off");
		
	}
	
	@Override
	public void notification() {
		System.out.println("뚜루루루루룽");
		
	}
	
	
}	

