package naverApp;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;
import javax.net.ssl.HttpsURLConnection;

public class NMain {
	public static void main(String[] args) {
		String str = null;
		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("주제 : ");
			str = sc.next();
			str = URLEncoder.encode(str, "utf-8");

			String url = "https://openapi.naver.com/v1/search/news.xml";
			url += "?query=" + str + "&display=30";

			URL u = new URL(url);
			HttpsURLConnection hsuc = (HttpsURLConnection) u.openConnection();
			hsuc.setRequestProperty("X-Naver-Client-Id", "kkkkkkkkkkkkkk");
			hsuc.setRequestProperty("X-Naver-Client-Secret", "kkkkkkkkk");
			
			InputStream is = hsuc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
//			while(true) {
				System.out.println(br.readLine());
//			}`

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
