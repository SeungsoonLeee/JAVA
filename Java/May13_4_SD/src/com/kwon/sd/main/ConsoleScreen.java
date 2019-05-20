package com.kwon.sd.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.kwon.sd.student.Student;

// V
public class ConsoleScreen {
	public static void printResult(String result) {
		System.out.println(result);
	}

	public static void printResult2(ArrayList<Student> result) {
		for (Student student : result) {
			student.print();
		}
	}

	public static Student showSearchStudentMenu() {
		System.out.print("이름 : ");
		String n = new Scanner(System.in).next();
		return new Student(0, n, 0, null, null, null);
	}

	public static Student showRegStudentMenu() {
		Scanner s = new Scanner(System.in);
		System.out.print("이름 : ");
		String n = s.next();
		System.out.print("나이 : ");
		int a = s.nextInt();
		System.out.print("성별 : ");
		String g = s.next();
		System.out.print("주소 : ");
		String addr = s.next();
		System.out.print("강의실명 : ");
		String l = s.next();
		return new Student(0, n, a, g, addr, l);
	}

	public static Student showDelStudentMenu() {
		System.out.print("번호 : ");
		int n = new Scanner(System.in).nextInt();
		return new Student(n, null, 0, null, null, null);
	}

	public static Student showUpdateStudentMenu() {
		Scanner s = new Scanner(System.in);
		System.out.print("번호 : ");
		int n = s.nextInt();
		System.out.print("나이 : ");
		int a = s.nextInt();
		return new Student(n, null, a, null, null, null);
	}

	public static int showMainMenu() {
		System.out.println("학원관리");
		System.out.println("-----");
		System.out.println("1. 학생등록");
		System.out.println("2. 학생삭제");
		System.out.println("3. 학생수정");
		System.out.println("4. 학생전체조회");
		System.out.println("9. 종료");
		System.out.println("-----");
		System.out.print("뭐 : ");
		return new Scanner(System.in).nextInt();
	}
}
