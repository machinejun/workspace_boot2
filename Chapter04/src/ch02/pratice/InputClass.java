package ch02.pratice;

import java.util.Scanner;

public class InputClass {
	Scanner scanner;
	WriteClass writeClass;
	
	public InputClass(WriteClass writeClass) {
		this.writeClass = writeClass;
		scanner = new Scanner(System.in);
		write();
	}
	
	private void write() {
		String someThing = scanner.nextLine();
		writeClass.writeSomeThing(someThing);
	}
	

}
