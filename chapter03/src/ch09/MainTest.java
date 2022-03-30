package ch09;

public class MainTest {

	public static void main(String[] args) {
		BookClient bookPro = new BookClient(new BookMySql(), new InputInfo());
		bookPro.startPro();

	}

}
