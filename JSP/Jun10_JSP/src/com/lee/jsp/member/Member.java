package com.lee.jsp.member;

public class Member {
	private String id;
	private String pw;
	private String name;
	private String comment;
	private String photo;

	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String id, String pw, String name, String comment, String photo) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.comment = comment;
		this.photo = photo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
