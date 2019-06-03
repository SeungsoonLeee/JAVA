package com.kwon.what.loc;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class LocManager {
	public static void search(HttpServletRequest request, HttpServletResponse response) {
		HttpsURLConnection huc = null;
		try {
			request.setCharacterEncoding("euc-kr");
			String search = request.getParameter("search");
			search = URLEncoder.encode(search, "utf-8");

			String url = "https://dapi.kakao.com/v2/local/search/keyword.json";
			url += "?query=" + search;
			url += "&x=127.023680&y=37.502418&radius=10000";
			url += "&sort=distance";

			URL u = new URL(url);
			huc = (HttpsURLConnection) u.openConnection();
			huc.addRequestProperty("Authorization", "KakaoAK 498bf7bdf84b891b4a55f1eb2ba6362f");

			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			JSONParser jp = new JSONParser();
			JSONObject locData = (JSONObject) jp.parse(isr);
			JSONArray documents = (JSONArray) locData.get("documents");
			JSONObject loc = null;
			ArrayList<Loc> locations = new ArrayList<Loc>();
			Loc l = null;
			for (int i = 0; i < documents.size(); i++) {
				loc = (JSONObject) documents.get(i);
				l = new Loc();
				l.setName(loc.get("place_name").toString());
				l.setAddress(loc.get("address_name").toString());
				l.setPhone(loc.get("phone").toString());
				l.setDistance(loc.get("distance").toString());
				locations.add(l);
			}
			request.setAttribute("locations", locations);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			huc.disconnect();
		}
	}
}
