package ch05.socket.ch02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFile {
	
	ServerSocket serverSocket;
	Socket socket;
	BufferedReader bufferedReader;// 받는 친구
	BufferedReader bufferedReader2;// 받는 친구
	
	/////////////////////////////////////////////////
	
	BufferedWriter bufferedWriter;// 입력하는 친구(클라이언트 쪽으로 Data를 보내는 친구)
	BufferedReader keyboradReader;
	
	public ServerFile() {
		System.out.println("1. >>> 서버 소켓 시작");
		try {
			serverSocket = new ServerSocket(10000);
			System.out.println("2. 서버 소켓 생성 완료");
			
			socket = serverSocket.accept(); 
			System.out.println("3. client 연결 완료");
			
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			keyboradReader = new BufferedReader(new InputStreamReader(System.in));
			//클라이언트에게 보낼 스트림 연결(outputStream)
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			// 쓰레드 처리
		
			new Thread(new WriteThread()).start();

			
			while(true) {
				String msg = bufferedReader.readLine();
				System.out.println("클라이언트1로 부터 받은 메세지: " + msg);
			}
			
		} catch (IOException e) {
			System.out.println("예외 발생");
			e.printStackTrace();
		}finally {
			try {
				bufferedReader.close();
				keyboradReader.close();
				bufferedWriter.close();
				socket.close();
				serverSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}
	
	//내부 클래스
	private class WriteThread implements Runnable{

		@Override
		public void run() {
			//키보드에서 데이터를 읽음
			while(true) {
				try {
					String msg = keyboradReader.readLine();
					// 클라이언트로 데이터 보내기 --> 소켓
					
					bufferedWriter.write(msg + "\n");
					bufferedWriter.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			
		}
		
	}
	
	public static void main(String[] args) {
		new ServerFile();
	}
}
