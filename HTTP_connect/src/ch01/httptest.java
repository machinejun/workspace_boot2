package ch01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class httptest {
	public static void main(String[] args) {
		sendGetJson();
		//sendGetJson();
	}
	
	public static void sendPostJson() {
		try {
			URL url = new URL("https://webhook.site/77e0f9fd-797a-4b46-94dc-9c1ae3bc9209");
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json;utf-8");
			conn.setRequestProperty("Accept", "application/json");
			conn.setDoOutput(true);
			
			String jsonInput = "{id:faker,game:lolls}";
			
			conn.setDoInput(true);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			bw.write(jsonInput);
			bw.flush();
			bw.close();
			
			try(BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"))){
				StringBuilder response = new StringBuilder();
				String responseLine = null;
				while((responseLine = br.readLine()) != null) {
					response.append(responseLine.trim());
				}
				System.out.println(response.toString());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void sendGetJson() {
		try {
			URL url = new URL("https://webhook.site/77e0f9fd-797a-4b46-94dc-9c1ae3bc9209");
			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json;utf-8");
			connection.setRequestProperty("Accept", "application/json");
			
			connection.setRequestProperty("id", "faker");
			connection.setRequestProperty("game", "lol");
			
			try(BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"))){
				StringBuilder response = new StringBuilder();
				String responseLine = null;
				while((responseLine = br.readLine()) != null) {
					response.append(responseLine.trim());
				}
				System.out.println(response.toString());
			}
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
