package ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import dto.Post;

public class HttpMainTest1 {

	public static void main(String[] args) {
		// host : 외부에서 내컴퓨터로 접근하게 만들 수 있는 컴퓨터
		// http >>
		// TCP >> http로 요청을 하면 반드시 응답이 온다.
		// UDP >> 요청을 했을 때 요청이 올수도 안 올수도 있다.

		// http 통신을 위한 준비물 1
		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/posts/"); // http 통신을 위한 주소값
			// 준비물 2

			// 100 , 200(성공) ,300, 400, 500
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			
			int stausCod = connection.getResponseCode();
			System.out.println("stausCode:" + stausCod);
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String line = null;
			
			if(stausCod == 200) {
				while((line = reader.readLine()) != null ){
					sb.append(line + "\n" );
				}
			}
			String str = sb.toString();
			//System.out.println(str);
			Gson gson = new Gson();
			Type postType = new TypeToken<ArrayList<Post>>() {}.getType();
			ArrayList<Post> posts = gson.fromJson(str, postType);
			System.out.println(posts);
			
//			System.out.println(str);
//			System.out.println("--------------------");
//			System.out.println(str.substring(5 , 11));
//			System.out.println(str.substring(14 , 15));
			// 부가적인 정보를 추가해서 보내기
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
