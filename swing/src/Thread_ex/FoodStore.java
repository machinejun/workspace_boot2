package Thread_ex;

class BookingCustom extends Thread{
	Order order;
	
	public BookingCustom(Order order) {
		this.order = order;
	}
	
	@Override
	public void run() {
		
		if(order.isChefState() == true) {
			order.book();
		}else {
			System.out.println("세프 일하는중이라서 주문을 받을 수 없습니다.");
			return;
		}
		
	}
}

class VistingCustom extends Thread {
	Order order;
	
	public VistingCustom(Order order) {
		this.order = order;
	}
	
	@Override
	public void run() {
		if(order.isChefState() == true) {
			order.visit();
		}else {
			System.out.println("세프 일하는중이라서 주문을 받을 수 없습니다.");
			return;
		}
		

	}
}

class Order {
	static int number = 0;
	boolean chefState = true;
	

	public boolean isChefState() {
		return chefState;
	}

	public void setChefState(boolean chefState) {
		this.chefState = chefState;
	}

	public synchronized void visit() {
		System.out.println("손님이 가게에 들어왔습니다.");
		number += 1;
		System.out.println("주문번호: " + number);
		System.out.println("cooking");
		chefState = false;
		for(int i = 0; i < 3; i++) {
			try {
				System.out.print(" . ");
				Thread.sleep(500);
			} catch (Exception e) {
				e.setStackTrace(null);
			}
		}
		System.out.println(".");
		chefState = true;
		System.out.println("방문 손님의 음식이 완료 되었습니다.");
		System.out.println("------------------------------");
	}
	
	public synchronized void book() {
		System.out.println("손님이 예약을 했습니다.");
		number += 1;
		System.out.println("주문번호: " + number);
		System.out.print("cooking");
		chefState = false;
		for(int i = 0; i < 5; i++) {
			try {
				System.out.print(" . ");
				Thread.sleep(500);
			} catch (Exception e) {
				e.setStackTrace(null);
			}
		}
		System.out.println(".");
		chefState = true;
		System.out.println("예약 손님의 음식이 완료 되었습니다.");
		System.out.println("------------------------------");
	}
}


public class FoodStore {
	public static void main(String[] args) {
		System.out.println("쉐프는 한사람이여서 한개의 음식만 만들수 있습니다.");
		Order order = new Order();
		VistingCustom vistingCustom = new VistingCustom(order);
		BookingCustom bookingCustom = new BookingCustom(order);
		System.out.println(">>>> 예약 주문");
		bookingCustom.start();
		System.out.println(">>>> 손님 들어옴");
		vistingCustom.start();
	}
	


}
