package com.kwon.aop.main;

// AOP(Aspect Oriented Programming)
//		관점지향프로그래밍
//		OOP를 다른관점에서 봐서, 공통적인거 따로 정리
public class Human {
	public void ready() {
		System.out.println("씻기");
		System.out.println("옷입기");
		System.out.println("신발신기");
	}

	public void goSchool() {
		ready();
		System.out.println("버스정류장");
		System.out.println("버스타고 학교로");
	}

	public void goPark() {
		ready();
		System.out.println("주차장");
		System.out.println("차 끌고 공원으로");
	}

	public void goMart() {
		ready();
		System.out.println("걸어서 마트로");
	}
}
