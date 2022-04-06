package Thread_ex;

public class ThreadTest1 {
	public static void main(String[] args) {
		for( int i = 0; i < 50; i++) {
			System.out.println(i + "\t");
			try {
				Thread.sleep(200);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
