package TelephoneDict.controller;

import java.util.Scanner;

import TelephoneDict.Service.Service;


public class ControllerTest implements Controller{
	private Service service;
	Scanner scanner;
	boolean flag = true;
	boolean flag2 = true;
	String[] idAndPs = new String[2]; 

	public ControllerTest(Service service) {
		this.service = service;
		scanner = new Scanner(System.in);
		service.inputUser("ABCD", "1234");
	}


	@Override
	public void runUser() {
		
		while(flag) {
			idAndPs[0] = "";
			idAndPs[1] = "";
			index();
			char select = scanner.next().charAt(0);
			if(select == '1') {
				idAndPs = inputIdAndPs();
				System.out.println(idAndPs[0]);
				System.out.println(idAndPs[1]);
				if(service.login(idAndPs[0], idAndPs[1])) {
					runTel();
				}
			}else if(select == '2') {
				idAndPs = inputIdAndPs();
				service.inputUser(idAndPs[0], idAndPs[1]);
			}else if(select == 'q') {
				flag = false;
			}else {
				System.out.println("잘못입력하셨습니다.");
			}
		}	
	}
	
	@Override
	public void runTel() {
		service.readTelDict();
		while(flag2) {
			dictIndex();
			char selectT = scanner.next().charAt(0);
			if(selectT == '1') {
				System.out.println("가게 이름을 입력하세요: ");
				String store = scanner.next();
				service.searchTelphonNum(store);
			}else if(selectT == 'b') {
				System.out.print("로그인 화면으로 돌아가는 중");
				for(int i = 0; i < 5 ; i ++) {
					System.out.print(" . ");
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(" . ");
				flag2 = false;
			}
		}
	}


	@Override
	public void index() {
		System.out.println("----------[로그인 화면]--------");
		System.out.println("로그인 테스트용 id: ABCD, ps: 1234");
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("q. 프로그램 종료");
		System.out.println("-------------------------------------");
		System.out.print("입력 : ");

	}
	
	@Override
	public void dictIndex() {
		System.out.println("----------[전화번호부]--------");
		System.out.println("가게 테스트용: 오니기리 , 051카페");
		System.out.println("1. 가게 전화번호 찾기");
		System.out.println("b. 로그인화면으로 돌아가기");
		System.out.println("-------------------------------------");
		System.out.print("입력 : ");

		
	}


	private String removeBlank(String str) {
		String result1 = str.trim();
		String result2 = result1.replace(" ", "");
		return result2;
		
	}
	private String[] inputIdAndPs() {
		String[] info = new String[2]; 
		System.out.print("아이디를 입력하세요 :");
		scanner.nextLine();
		info[0]= removeBlank(scanner.nextLine());
		System.out.print("비밀번호를 입력하세요 :");
		info[1] = removeBlank(scanner.nextLine());
		return info;
	}


	


	
	

}
