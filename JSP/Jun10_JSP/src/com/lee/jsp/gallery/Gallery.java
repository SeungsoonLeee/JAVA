package com.lee.jsp.gallery;

public class Gallery {
	private int no;
	private String title;
	private String id;
	private String file;
	private String date;

	public Gallery() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gallery(int no, String title, String id, String file, String date) {
		super();
		this.no = no;
		this.title = title;
		this.id = id;
		this.file = file;
		this.date = date;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

}
