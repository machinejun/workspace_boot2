package ch05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import ch03.MovieData;

public class mainTest3 {
	public static void main(String[] args) {
		try {
			URL url = new URL("https://yts.mx/api/v2/list_movies.json");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();

			int statusCode = connection.getResponseCode();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuffer sBuffer = new StringBuffer();
			String line = null;
			Gson gson = new Gson();
			
			if (statusCode == 200) {
				while ((line = reader.readLine()) != null) {
					sBuffer.append(line + "\n");

				}

			}
			String reciveData = sBuffer.toString();

			Yts yts = gson.fromJson(reciveData, Yts.class);
			System.out.println(yts);
			System.out.println(yts.getData().getMovieCount());
			
			
			//System.out.println(movieDatas);

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 서버 측에 데이터를 보낼 때 서버가 이해할 수 있는 문자열(json)
		// 서버에서 Json을 던져 준다면 자바에서 사용하기 위해서 class로 변환 해야한다.
		// Dto(data transfer object) 개념을 배웠음
	}

}
