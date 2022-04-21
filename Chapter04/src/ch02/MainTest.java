package ch02;

public class MainTest {

	public static void main(String[] args) {
		// 해커 뉴스 객체 생성
		HackerNews hackerNews = new HackerNews();
		
		// 기사 작성
		MyArticle myArticle = new MyArticle("오늘 날씨가 좋음 !!!" , hackerNews);
		myArticle.complete();

	}

}
