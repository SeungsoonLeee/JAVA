package com.kwon.mvc.main;

// MVC패턴
// 		유지보수, 협업에 유리한 형태
//		클래스를 나눠서 작업
//		어떤 클래스 하나는 M,V,C중에 하나의 역할만

// C(Controller) : 개발자(리더급)
//		교통정리
//		지금 M이 필요하면 M부르고, V가 필요하면 V부르고
public class C {
	public static void main(String[] args) {
		int[] xy = V.getNum();
		int sum = M.calculate(xy);
		V.print(sum);
	}
}


