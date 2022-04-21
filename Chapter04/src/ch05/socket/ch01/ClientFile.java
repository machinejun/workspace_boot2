package ch05.socket.ch01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientFile {
	Socket socket;
	BufferedWriter bufferedWriter;  // 소켓에다가 연결할 outputStream
	final String IP = "192.168.4.101"; // 자기 자신을 나타내는 주소 = 127.0.0.1
	final int PORT = 10000;
	BufferedReader keybordBufferedReader; // 키보드에 연결할 스크림
	
	public ClientFile() {
		
		try {
			System.out.println("1. client 소켓 시작");
			socket = new Socket(IP, PORT);
			
			System.out.println("2. 버퍼 연결");
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			System.out.println("3. 키보드 버퍼 연결");
			keybordBufferedReader = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("4. 키보드 입력 대기");
			String msg = keybordBufferedReader.readLine(); // 입력 대기중.......
			
			// 사용자 문자열을 받았으면 보내야 한다 --> socket 이용하여
			bufferedWriter.write(msg + "\n"); // 중요 : 메세지 끝을 알려주어야 한다. \n
			bufferedWriter.flush();
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ClientFile();
	}

}
