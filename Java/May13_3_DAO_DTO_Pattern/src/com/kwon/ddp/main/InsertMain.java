package com.kwon.ddp.main;

import java.util.Scanner;

public class InsertMain {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("식당명 : ");
		String n = s.next();
		System.out.print("위치 : ");
		String a = s.next();
		
		Restaurant r = new Restaurant(n, a);
		DAO.getDao().regRestaurant(r);
	}
}
