package ch01;

import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
/**
 * 서버 기능
 * 1. 포트 번호를 받아서 서비스 포트를 생성한다.  || 서버 중지 기능
 * 2. 사용자의 접속 확인 || 클라이언트 연결 X -> 메세지 뿌리기
 * 3. 유저인포 (???): 유저의 소켓정보, 닉네임, 방이름을 가진 객체를 이며 클라이언트로 부터
 *                    메세지를 받는 쓰레드 이다. 
 * 4. 유저인포 기능:
 * >> 생성될 때 클라이언트로부터 입력받은 닉네임을 읽어서 기타등등 클라이언트들에게 메세지를 뿌려준다.
 * >> 쓰레드를 통해서 클라이언트로부터 메세지를 받는다.
 * >> 받은 메세지는 inmassage를 통해서 처리한다.
 * >> 프로토콜/ 값을 읽어서 각자의 동작을 한다.  
 * >> Note: vc에서 같은 이름을 찾아서 "/" 뒤에 있는 이름을 읽고 "@" 뒤에 내용을 읽어서 해당하는 이름을 가진 클라이언트에게 전달
 * >> CreateRoom: vc_room에서 방 이름 찾아서 체크 한 후 true 이면 생성한후 방생성(roomimformation을 생성 후 vc_room에 집어넣음) 
 *       클라이언트에게 방생성됬다는 메세지를 뿌려준다. + 모두에게 새방이 생겼다라는 메세지를 뿌려준다.           
 * >> chatting : / 뒤에있는 문자열(방이름) 받아서 방을 찾은뒤 방에 있는 room-user-vc에 있는 유저 인포들에게만 메세지를 뿌려준다.
 * >> joinroom : joinroom/방이름 이라는 걸 받았으니깐 방이름만 가지고 와서 방을 찾은뒤에 그방의 유저들에게 메세지를 뿌려준다.
 *            
 * -- room내부 클래스 : 생성자 >> 방이름, 유저 인포를 받고 유저 인포를 멤버변수(room-user-vc)에다가 집어넣는다.
 *                      메서드 >> addUser : 유저 인포 객체를 room-user-vc에다가 넣는다.
 *                                removeroom: room-user-vc에서 매개변수로 받은 유저인포를 삭제한후
 *                                            방이 비었다면은 vc-room에서 이름이 같은 방을 방을 삭제한후 모든 유저에게 메세지
 */

public class Server extends JFrame implements ActionListener {

	// GUI 자원
	private JPanel contentPane;
	private JTextField tfPort;
	private JTextArea textArea;
	private JLabel lblPortNum;
	private JButton btnServerStart;
	private JButton btnServerStop;

	// Network 자원
	private ServerSocket server_socket; // 거대한 소켓생성 공장  >> 자기는 한개이다
	private Socket socket;
	private int port;

	// 그외 자원들
	private Vector<UserInfomation> vc = new Vector<UserInfomation>();
	private Vector<RoomInfomation> vc_room = new Vector<RoomInfomation>();
	/*
	 * Vector : 객체에 대한 참조값을 저장하는 배열, 다양한 객체들이 하나의 벡터에 저장될 수 있다.
	 *        : 정수 인덱스를 통해서 배열에 접근 할 수 있따.
	 *        : 동기화(순서대로 작업): 한 번에 하나의 스레드만 벡터의 메서드를 호출 할 수 있다. 즉 클래스의 참조 주소를 벡터에 저장하고 
	 *          스레드가 해당 클래스의 메서드를 사용하면 벡터의 다른 인덱스에는 접근 할 수 없다.
	 */

	public Server() {  // 생성자
		init();  // 객체 생성 & 프레임에 붙이기 & 레이아웃 설정
		addListener(); // 이벤트 리스너 등록
		tfPort.requestFocus(); // 키이벤트를 받을 객체라는 것을 설정
	}

	// GUI 초기화
	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ScrollPane scrollPane = new ScrollPane(); // scrollpane = 스크롤이 있는 컨테이너
		scrollPane.setBounds(10, 10, 309, 229);
		textArea = new JTextArea();
		textArea.setBounds(12, 11, 310, 230);
		scrollPane.add(textArea); // 스크롤 컨테이너에다가 텍스트 공간 지정
		contentPane.add(scrollPane); // 추가
		textArea.setEditable(false); // setEditable : 이벤트만 통해서 textarea 수정이 이루어지게 에디트를 막음

		lblPortNum = new JLabel("포트번호 :");
		lblPortNum.setBounds(12, 273, 82, 15);
		contentPane.add(lblPortNum);

		tfPort = new JTextField();
		tfPort.setBounds(98, 270, 224, 21);
		contentPane.add(tfPort);
		tfPort.setColumns(10); // 최대 글자 지정인거 같은데??? 10개 이상 쳐진다. 읽을때 10개만 읽는가 ?

		btnServerStart = new JButton("서버실행");
		btnServerStart.setBounds(12, 315, 154, 23);
		contentPane.add(btnServerStart);

		btnServerStop = new JButton("서버중지");
		btnServerStop.setBounds(168, 315, 154, 23);
		contentPane.add(btnServerStop);
		btnServerStop.setEnabled(false);

		setVisible(true);
	}

	// 이벤트 리스너
	private void addListener() {

		tfPort.addActionListener(this);
		btnServerStart.addActionListener(this);
		btnServerStop.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnServerStart) {  // 서버 실행 버튼을 누르면 이벤트 실행
			if (tfPort.getText().length() == 0) { // 텍스트창에서 가져온 값을 확인
				System.out.println("  값을 입력 하세요 ");
			} else if (tfPort.getText().length() != 0) { // 텍스트창에서 0이 아니면 실행

				// 값을 가져와서 port변수에 저장시키기
				port = Integer.parseInt(tfPort.getText()); // 스티링값 정수로 변환
				startNetwork();
				tfPort.setEditable(false);
				btnServerStart.setEnabled(false);
				btnServerStop.setEnabled(true);
			}

		} else if (e.getSource() == btnServerStop) {
			try {
				server_socket.close();
				vc.removeAllElements();
				vc_room.removeAllElements();
				tfPort.setEditable(true);
				btnServerStart.setEnabled(true);
				btnServerStop.setEnabled(false);
			} catch (IOException e1) {

			}
		}
	}

	private void startNetwork() {
		try {
			server_socket = new ServerSocket(port); // 서버 소켓의 포트를 지정해주고 활성화
			textArea.append("서버를 시작 하겠습니다.\n");
			connect(); 
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "이미 사용중인 포트입니다.", "알림",
					JOptionPane.ERROR_MESSAGE);
			btnServerStart.setEnabled(true);
			btnServerStop.setEnabled(false);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "잘못입력하였습니다.", "알림",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void connect() { // 소켓 생성 쓰레드 돌리기
		Thread th = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						textArea.append("사용자의 접속을 기다립니다.\n");
						socket = server_socket.accept(); // 서버 소켓에다가 소켓을 연결
						                                 // 얘는 소켓이 연결될때 가지 대기중 연결되면 종료 된다.

						UserInfomation useInfo = new UserInfomation(socket); // 유저인포의 멤버 변수에 소캣을 넣어준다.
						// 각각의 스레드를 등록시켜준다.
						useInfo.start(); 
					} catch (IOException e) {
						textArea.append("서버가 중지됨! 다시 스타트 버튼을 눌러주세요\n");
						break;
					}
				}
			}
		});
		th.start();
	}

	// 전체 사용자에게 메세지를 보내는 부분
	public void broadCast(String str) {
		for (int i = 0; i < vc.size(); i++) {
			UserInfomation uinf = vc.elementAt(i); // vec터의 인덱스에 접근하여서 userinfo 주소를 가지고 온다.
			// 여기서 프로토콜의 개념을 사용
			uinf.sendmessage(str);
		}
	}

	// 내부클래스
	class UserInfomation extends Thread { // 컨트롤 쓰레드
		private InputStream is;
		private OutputStream os;
		private DataInputStream dis;  // 기본입력 스트림으로 부터 독립적인 방식으로 데이터 유형을 읽는다.
		private DataOutputStream dos; // 기본입력 스트림으로 부터 독립적인 방식으로 데이터 유형을 보낸다.
		String nickName;
		String myCurrentRoomName;
		private Socket user_socket;

		private boolean roomCheck = true;

		public UserInfomation(Socket soc) {
			this.user_socket = soc;
			network();
		}

		private void network() {
			try {
				is = user_socket.getInputStream(); // 소켓에서 입력한 입력스트림을 반환해준다.
				dis = new DataInputStream(is); // 소켓에서 입력한 스트림을 데이터를 읽는다.
				
				
				// 접속했다 라는 메세지를 유저들에게 보내주기 위해서 생성
				os = user_socket.getOutputStream(); // 소켓에서 출력 한 스트림을 반환
				dos = new DataOutputStream(os); // os를 읽는다.

				// 처음 접속시 유저의 id를 입력받는다.
				nickName = dis.readUTF(); // 한글을 받기 위해서 사용하는 놈>> utf-8을 이용하여 유니코드 번역
				textArea.append("[[" + nickName + "]] 입장\n");

				// 기존사용자들에게 신규 유저의 접속을 알린다.
				broadCast("NewUser/" + nickName);

				// 자신에게 기존 사용자들을 알린다.
				for (int i = 0; i < vc.size(); i++) {
					UserInfomation uinf = vc.elementAt(i);
					sendmessage("OldUser/" + uinf.nickName);
				}
				for (int i = 0; i < vc_room.size(); i++) {
					RoomInfomation room = vc_room.elementAt(i);
					sendmessage("OldRoom/" + room.roomName);
				}

				// 사용자에게 자신을 알린후 벡터에 자신을 추가한다.
				vc.add(this);

			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Stream설정에러!", "알림",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		// 브로드캐스트
		@Override
		public void run() {
			while (true) {
				try {
					String msg = dis.readUTF(); // 각자 소캣으로 부터 받은 메세지 번역
					textArea.append("[["+ nickName + "]]" + msg + "\n");
					inmessage(msg);
				} catch (IOException e) {
					try {
						textArea.append(nickName + " : 사용자접속끊어짐\n");
						dos.close();
						dis.close();
						user_socket.close();
						vc.remove(this);
						vc_room.remove(this);
						broadCast("UserOut/" + nickName);
						broadCast("ErrorOutRoom/"+myCurrentRoomName);
						broadCast("UserData_Updata/ok");
						break;
					} catch (IOException e1) {
						break;
					}
				}
			}
		}

		private void inmessage(String str) {
			StringTokenizer st = new StringTokenizer(str, "/"); // 문자열을 / 단위로 쪼갬 
			String protocol = st.nextToken();
			String message = st.nextToken();

			System.out.println("protocol : " + protocol); // 규약을 읽기 위해서
			System.out.println("message : " + message);

			if (protocol.equals("Note")) {
				System.out.println(message);
				st = new StringTokenizer(message, "@"); // 메세지를 @ 단위로 쪼갬
				String user = st.nextToken();
				String note = st.nextToken();
				// 백터에서 해당 사용자를 찾아서 쪽지를 전송한다.
				for (int i = 0; i < vc.size(); i++) {
					UserInfomation u = vc.elementAt(i);
					// 쪽지는 반드시 찾은 사용자에게 메세지를 보내줘어야 한다.
					if (u.nickName.equals(user)) {
						u.sendmessage("Note/" + nickName + "@" + note);
					}
				}
			} else if (protocol.equals("CreateRoom")) {
				// 1.현재같은방이 존재하는지 확인한다.
				for (int i = 0; i < vc_room.size(); i++) {
					RoomInfomation room = vc_room.elementAt(i);
					if (room.roomName.equals(message)) { // 만들고자하는방이름을 확인한다
						sendmessage("CreateRoomFail/ok");
						roomCheck = false;
						break;
					} else {
						roomCheck = true;
					}
				} // end for
				if (roomCheck == true) {
					// 1.방을 생성한다.
					RoomInfomation new_room = new RoomInfomation(message, this);
					// 2. 전체 방 벡터에 생성된 방을 저장한다.
					vc_room.add(new_room);
					// 3.사용자들에게 방과 방이름을 생성되었다고 알려준다.
					sendmessage("CreateRoom/" + message); // 자신에게 방 성공 메세지를 보낸다.
					broadCast("new_Room/" + message);
				}
			} else if (protocol.equals("Chatting")) {
				String msg = st.nextToken();
				for (int i = 0; i < vc_room.size(); i++) {
					RoomInfomation r = vc_room.elementAt(i);
					if (r.roomName.equals(message)) {
						r.roomBroadcast("Chatting/" + nickName + "/" + msg);
					}
				}
			} else if (protocol.equals("JoinRoom")) {
				for (int i = 0; i < vc_room.size(); i++) {
					RoomInfomation r = vc_room.elementAt(i);
					if (r.roomName.equals(message)) {
						// 신규접속자를 알린다.
						r.roomBroadcast("Chatting/[[알림]]/(((" + nickName
								+ " 입장))) ");
						r.addUser(this); // 해당 룸 객체에 자신을 추가시킨다.
						sendmessage("JoinRoom/" + message);
					}
				}
			} else if (protocol.equals("OutRoom")) {
				for (int i = 0; i < vc_room.size(); i++) {
					RoomInfomation r = vc_room.elementAt(i);
					if (r.roomName.equals(message)) {
						r.removeRoom(this);
						sendmessage("OutRoom/ok");
						break;
					}
				}
			}
		}

		private void sendmessage(String msg) {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	// 내부클래스
	class RoomInfomation {

		String roomName;
		Vector<UserInfomation> room_user_vc = new Vector<UserInfomation>();

		public RoomInfomation(String roomName, UserInfomation u) {
			this.roomName = roomName;
			this.room_user_vc.add(u);
			//와우 대박. ㅋㅋ
			u.myCurrentRoomName = roomName;
		}

		private void roomBroadcast(String str) { // 현재방의 모든 사람들에게 알린다.
			for (int i = 0; i < room_user_vc.size(); i++) {
				UserInfomation u = room_user_vc.elementAt(i);
				u.sendmessage(str);
			}
		}

		private void addUser(UserInfomation u) {
			room_user_vc.add(u);
		}
		@Override
		public String toString() {
			return roomName;
		}

		private void removeRoom(UserInfomation u) {
			room_user_vc.remove(u);
			boolean empty = room_user_vc.isEmpty();
			if (empty) {
				for (int i = 0; i < vc_room.size(); i++) {
					RoomInfomation r = vc_room.elementAt(i);
					if (r.roomName.equals(roomName)) {
						vc_room.remove(this);
						broadCast("EmptyRoom/"+roomName);
						broadCast("UserData_Updata/ok");
						break;
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		new Server();
	}
}

