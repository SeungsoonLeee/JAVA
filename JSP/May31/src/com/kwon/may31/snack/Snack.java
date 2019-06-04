package com.kwon.may31.snack;

import java.util.Date;

public class Snack {
	private int no;
	private String name;
	private int price;
	private Date exp;
	private String desc;

	public Snack() {
		// TODO Auto-generated constructor stub
	}

	public Snack(int no, String name, int price, Date exp, String desc) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.exp = exp;
		this.desc = desc;
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

	public Date getExp() {
		return exp;
	}

	public void setExp(Date exp) {
		this.exp = exp;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
