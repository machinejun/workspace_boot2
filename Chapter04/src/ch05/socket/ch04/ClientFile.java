package ch05.socket.ch04;

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
	final String IP = "localhost";
	final int PORT = 10000;
	BufferedReader keybordBufferedReader; // 키보드에 연결할 스트림

	// 서버에서 보낸 메세지를 읽기 위해 buffer 장착
	// 새로운 스레드가 필요!!
	BufferedReader bufferedReader;

	public ClientFile() {

		try {
			System.out.println("1. client 소켓 시작");
			socket = new Socket(IP, PORT);

			System.out.println("2. 버퍼 연결");
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			System.out.println("3. 키보드 버퍼 연결");
			keybordBufferedReader = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("4. 키보드 입력 대기");

			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// 새로운 쓰레드 시작
			ReadThread readThread = new ReadThread();
			Thread thread = new Thread(readThread);
			thread.start();

			while (true) {
				String msg = keybordBufferedReader.readLine();

				bufferedWriter.write(msg + "\n");
				bufferedWriter.flush();
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				keybordBufferedReader.close();
				bufferedWriter.close();
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	// 내부 클래스 생성
	private class ReadThread implements Runnable {

		@Override
		public void run() {
			while (true) {
				String msg;
				try {
					msg = bufferedReader.readLine();
					if(msg == null) {
						continue;
					}else {
						System.out.println("서버로 부터 받은 메세지: " + msg);
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		}

	}

	public static void main(String[] args) {
		new ClientFile();
	}

}
