package ch04;

public class MainTest1 {

	public static void main(String[] args) {
		Televison televison = new Televison();
		Refrigerator refrigerator = new Refrigerator();
		ToyRobot toyRobot = new ToyRobot();
		
		televison.turnOn();
		refrigerator.turnOn();
		toyRobot.turnOn();
		System.out.println("--------------------------------");
		televison.turnOff();
		refrigerator.turnOff();
		toyRobot.turnOff();
		
		RemoteController[] remoteControllers = new RemoteController[3];
		remoteControllers[0] = televison;
		remoteControllers[1] = refrigerator;
		remoteControllers[2] = toyRobot;
		
		for (int i = 0;  i< remoteControllers.length; i++) {
			remoteControllers[0].turnOn();
		}
		for (int i = 0; i < remoteControllers.length; i++) {
			remoteControllers[0].turnOff();
		}

	}

}
