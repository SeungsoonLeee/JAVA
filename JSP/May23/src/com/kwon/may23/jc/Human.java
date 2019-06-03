package com.kwon.may23.jc;

public class Human {
	private String name;
	private int age;

	public Human() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Human(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
}
