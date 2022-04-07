package Thread_ex;

class BankAccount {
	private int money = 100_000;

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	// deposit 기능
	public synchronized void deposit(int money) {
		// synchronized : 키워드를 붙이게 되면 이 메서드가 먼저 공유자원에 접근하면 뒤에
		// 				  접근하는 객체를 대기 상태로 만든다.
		// 기본값 10만원
		int currentMoney = getMoney();
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setMoney(currentMoney + money);
		System.out.println("입금 후 계좌상에 " + getMoney() +"가 있습니다.");
	}
	// withdraw
	public void withdraw(int money) {
		synchronized (this) { // synchronized 블럭 처리
			int currentMoney = getMoney();
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			setMoney(currentMoney - money);
			System.out.println("입금 후 계좌상에 " + getMoney() +"가 있습니다.");
		}
	}
}

// 아버지는 세종시에서 일을 하고 입금을 합니다. > 네트워크가 느려서 시간이 조금 걸림
class Father extends Thread {
	BankAccount bankAccount;
	
	public Father(BankAccount bankAccount) {
		this.bankAccount  = bankAccount;
	}
	
	@Override
	public void run() {
		bankAccount.deposit(10_000);
	}
}

class Mother extends Thread {
	BankAccount bankAccount;
	
	public Mother(BankAccount bankAccount) {
		this.bankAccount  = bankAccount;
	}
	
	@Override
	public void run() {
		bankAccount.withdraw(5_000);
	}
}


public class SheraedResorce {
	public static void main(String[] args) {
		/*
		 *  계좌(공유 계좌)
		 *  class 아빠(입금) , 엄마(출금)
		 *  > 현재 100000원이 예금 되어 있음
		 */
		BankAccount bankAccount = new BankAccount();
		Father father = new Father(bankAccount);
		Mother mother = new Mother(bankAccount);
		
		// 아버지가 입금합니다.
		father.start();
		// 어머니가 출금합니다.
		mother.start();
		// 정상처리 금액 > 잔액 = 105_000원\
		// 멀티 쓰레드 상태( 공유된 자원 사용 ) 일 때 의도치 않은 결과를 생성할 수 있다.
		// 따라서, 공유화를 사용해 주어야 한다.
		// Java 에서는 1. synchronized 메서드 or 2. synchronized 블럭 (부분 부분에 사용할 수 있다.)
	}

}
