package com.kwon.may23.join;

import java.util.Date;

public class Member {
	private String name;
	private Date birthday;
	private int age;
	private String gender;
	private String[] vehicle;
	private String introduce;
	private double height;
	private double weight;
	private double bimando;
	private String photo;

	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String name, Date birthday, int age, String gender, String[] vehicle, String introduce, double height,
			double weight, double bimando, String photo) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.age = age;
		this.gender = gender;
		this.vehicle = vehicle;
		this.introduce = introduce;
		this.height = height;
		this.weight = weight;
		this.bimando = bimando;
		this.photo = photo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String[] getVehicle() {
		return vehicle;
	}

	public void setVehicle(String[] vehicle) {
		this.vehicle = vehicle;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getBimando() {
		return bimando;
	}

	public void setBimando(double bimando) {
		this.bimando = bimando;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
