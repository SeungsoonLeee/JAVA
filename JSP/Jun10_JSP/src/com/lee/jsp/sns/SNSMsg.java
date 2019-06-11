package com.lee.jsp.sns;

//자바빈, DTO : SNSMsg하나를 온전히 표현
public class SNSMsg {
	private int no;
	private String msg;
	private String date;
	private String id;
	private String name;
	private String photo;

	public SNSMsg() {
	}

	public SNSMsg(int no, String msg, String date, String id, String name, String photo) {
		super();
		this.no = no;
		this.msg = msg;
		this.date = date;
		this.id = id;
		this.name = name;
		this.photo = photo;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
