package com.kwon.mvc.main;

import java.util.Scanner;

// V(View) : 디자이너
//		사용자가 실제로 보는 영역
//		입력받기, 결과 보여주기
public class V {
	public static void print(int sum) {
		System.out.println("합은 " + sum);
	}
	
	public static int[] getNum() {
		Scanner s = new Scanner(System.in);
		System.out.print("x : ");
		int x = s.nextInt();
		System.out.print("y : ");
		int y = s.nextInt();
		s.close();
		return new int[] {x, y};
	}
	
}




