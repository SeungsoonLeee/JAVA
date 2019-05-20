package com.kwon.sd.student;

public class Student {
	private int s_no; // 번호
	private String s_name; // 이름
	private int s_age; // 나이
	private String s_gender; // 성별
	private String s_address; // 주소
	private String s_l_name; // 강의실명

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int s_no, String s_name, int s_age, String s_gender, String s_address, String s_l_name) {
		super();
		this.s_no = s_no;
		this.s_name = s_name;
		this.s_age = s_age;
		this.s_gender = s_gender;
		this.s_address = s_address;
		this.s_l_name = s_l_name;
	}

	public int getS_no() {
		return s_no;
	}

	public void setS_no(int s_no) {
		this.s_no = s_no;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public int getS_age() {
		return s_age;
	}

	public void setS_age(int s_age) {
		this.s_age = s_age;
	}

	public String getS_gender() {
		return s_gender;
	}

	public void setS_gender(String s_gender) {
		this.s_gender = s_gender;
	}

	public String getS_address() {
		return s_address;
	}

	public void setS_address(String s_address) {
		this.s_address = s_address;
	}

	public String getS_l_name() {
		return s_l_name;
	}

	public void setS_l_name(String s_l_name) {
		this.s_l_name = s_l_name;
	}

	public void print() {
		System.out.println(s_no);
		System.out.println(s_name);
		System.out.println(s_age);
		System.out.println(s_gender);
		System.out.println(s_address);
		System.out.println(s_l_name);
		System.out.println("-----");
	}
}
