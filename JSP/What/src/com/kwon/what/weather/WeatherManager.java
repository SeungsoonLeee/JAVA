package com.kwon.what.weather;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class WeatherManager {
	public static void getWeather(HttpServletRequest request, HttpServletResponse response) {
		try {
			String url = "http://www.kma.go.kr/wid/queryDFS.jsp?gridx=61&gridy=120";
			URL u = new URL(url);
			HttpURLConnection huc = (HttpURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			//////////////////////////
			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();
			xpp.setInput(isr);
			int type = xpp.getEventType();
			String tagName = null;
			ArrayList<Weather> weathers = new ArrayList<Weather>();
			Weather w = null;
			while (type != XmlPullParser.END_DOCUMENT) {
				if (type == XmlPullParser.START_TAG) {
					tagName = xpp.getName();
					if (tagName.equals("data")) {
						w = new Weather();
					}
				} else if (type == XmlPullParser.TEXT) {
					if (tagName.equals("hour")) {
						w.setHour(xpp.getText() + "½Ã±îÁö");
					} else if (tagName.equals("temp")) {
						w.setTemp(xpp.getText() + "¡É");
					} else if (tagName.equals("wfKor")) {
						w.setWfKor(xpp.getText());
					} 
				} else if (type == XmlPullParser.END_TAG) {
					tagName = "hg f";
					if (xpp.getName().equals("data")) {
						if(w.getWfKor().contains("¸¼À½")) {
							w.setImg("img/sun.gif");
						}else if(w.getWfKor().contains("±¸¸§") || w.getWfKor().contains("Èå¸²")) {
							w.setImg("img/cloud.png");
						}else if(w.getWfKor().contains("ºñ") || w.getWfKor().contains("¿ì")) {
							w.setImg("img/rain.png");
						}else if(w.getWfKor().contains("´«")) {
							w.setImg("img/snow.png");
						}
						weathers.add(w);
					}
				}
				xpp.next();
				type = xpp.getEventType();
			}
			request.setAttribute("weathers", weathers);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
