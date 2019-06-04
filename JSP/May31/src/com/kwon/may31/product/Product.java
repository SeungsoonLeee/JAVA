package com.kwon.may31.product;

public class Product {
	private int no;
	private String name;
	private int price;
	private String desc;
	private String photo;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int no, String name, int price, String desc, String photo) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.desc = desc;
		this.photo = photo;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
