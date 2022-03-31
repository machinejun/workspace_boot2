package ch11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileRead {
	
	public String fileReadTxt() {
		String str = "";
		File file = new File("a.txt");
		try {
			FileReader fileread1 = new FileReader(file);
			int i = 0;
			while((i = fileread1.read()) != -1) {
				str += (char)i;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			
		}
		return str;
	}
}
