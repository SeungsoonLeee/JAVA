package com.kwon.may23.jc;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DataMaker {
	public static void make(HttpServletRequest request, HttpServletResponse response) {
		int a = new Random().nextInt(101);
		request.setAttribute("a", a);
		
		String b = "¤»";
		request.setAttribute("b", b);
		
		request.setAttribute("c", null);
		
		String[] ar = {"a", "b", "c"};
		request.setAttribute("ar", ar);
		
		ArrayList<String> al = new ArrayList<String>();
		al.add("z"); 
		al.add("x"); 
		al.add("c");
		request.setAttribute("al", al);
		
		ArrayList<Human> humans = new ArrayList<Human>();
		humans.add(new Human("È«", 10));
		humans.add(new Human("±è", 20));
		humans.add(new Human("ÀÌ", 30));
		request.setAttribute("humans", humans);
	}
}





