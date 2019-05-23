package com.kwon.jm2.main;

public class Human {
	private String name;
	private String bYear;
	private String bMonth;
	private String bDay;
	private int age;
	
	public Human() {
		// TODO Auto-generated constructor stub
	}

	public Human(String name, String bYear, String bMonth, String bDay, int age) {
		super();
		this.name = name;
		this.bYear = bYear;
		this.bMonth = bMonth;
		this.bDay = bDay;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getbYear() {
		return bYear;
	}

	public void setbYear(String bYear) {
		this.bYear = bYear;
	}

	public String getbMonth() {
		return bMonth;
	}

	public void setbMonth(String bMonth) {
		this.bMonth = bMonth;
	}

	public String getbDay() {
		return bDay;
	}

	public void setbDay(String bDay) {
		this.bDay = bDay;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
