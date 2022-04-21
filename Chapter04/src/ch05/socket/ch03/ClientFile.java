package ch05.socket.ch03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientFile {
	Socket socket;
	BufferedWriter bufferedWriter;  
	final String IP = "192.168.4.101";
	//
	final int PORT = 10000;
	BufferedReader keybordBufferedReader; 
	
	public ClientFile() {
		
		try {
			System.out.println("1. client 소켓 시작");
			socket = new Socket(IP, PORT);
			
			System.out.println("2. 버퍼 연결");
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			System.out.println("3. 키보드 버퍼 연결");
			keybordBufferedReader = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("4. 키보드 입력 대기");
			
			while(true) {
				String msg = keybordBufferedReader.readLine(); 
				
				bufferedWriter.write(msg + "\n"); 
				bufferedWriter.flush();
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ClientFile();
	}

}
