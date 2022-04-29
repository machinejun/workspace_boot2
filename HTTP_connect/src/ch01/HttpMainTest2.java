package ch01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeMap;

import dto.Post;

public class HttpMainTest2 {
	
	
	public static void main(String[] args) {
		URL url;
		try {
			url = new URL("https://jsonplaceholder.typicode.com/posts/20");
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.setRequestMethod("GET"); // REST API 설정
			connection.connect();
			//
			//connection.setRequestProperty("content-type", "application/json"); >> 형식을 지정해줄 수 있음
			int statusCode = connection.getResponseCode();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			// 문자열 단위와 바이트 단위를 구분해야 한다
			StringBuffer buffer = new StringBuffer();
			String line = null;
			if(statusCode == 200) {
				while((line = reader.readLine()) != null) {
					buffer.append(line);
				}
			}else if(statusCode == 404) {
				System.out.println("네트워크 연결이 불안정 합니다.");
			}
			String str = buffer.toString();
			System.out.println(str);
			System.out.println("--------------------");
			Post post = new Post();
			// 문자열을 파싱하여 post객체에 값을 담아보세요
			
			ArrayList<String> index = new ArrayList<String>();
			String st = str.replace("{", "");
			String s1 = st.replaceAll("\\\"", "");
			String s = s1.replace(" ", "");
			for(int i = 0; i < s.split(",").length ; i++) {
				index.add(s.split(",")[i]);
			}
			
			TreeMap<String, String> build = new TreeMap<String, String>();
			for (String string : index) {
				StringTokenizer keyAndValue = new StringTokenizer(": ");
				String key = keyAndValue.nextToken();
				String value = keyAndValue.nextToken();
				build.put(key, value);
			}
			System.out.println(build.get("userId"));
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
