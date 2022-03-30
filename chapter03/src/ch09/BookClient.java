package ch09;

import java.util.Scanner;

public class BookClient {
	BookDao bookDao;
	InputBookInfo inputBookInfo;
	
	public BookClient(BookDao bookDao, InputBookInfo inputBookInfo) {
		this.bookDao = bookDao;
		this.inputBookInfo = inputBookInfo;
		startPro();
	}
	
	public void startPro() {
		Index index = new Index();
		while(true) {
			index.showIndex();
			Scanner sc = new Scanner(System.in);
			System.out.print("입력: ");
			char select = sc.next().charAt(0);
			
			if(select == '1') {
				bookDao.insertInfo(inputBookInfo.insertBookInfo());
			}else if(select == '2') {
				bookDao.showInfo();
			}else if(select == '3') {
				bookDao.deleteInfo(inputBookInfo.insertbookName());
			}else if(select == '4') {
				bookDao.searchInfo(inputBookInfo.insertbookName());
			}else if(select == '5'){
				System.out.println("수정하실 책이름과 책정보를 입력해 주세요");
				bookDao.updateInfo(inputBookInfo.insertbookName(), inputBookInfo.updateBookInfo());
			}else if(select == 'q') {
				break;
			}else {
				System.out.println("잘못 입력하셨습니다.");
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}		
		}
	}

}
