package com.lee.jsp.sns;

public class SNS {
	private int no;
	private String id;
	private String msg;
	private String date;
	
	public SNS() {
		// TODO Auto-generated constructor stub
	}
	
	public SNS(int no, String id, String msg, String date) {
		super();
		this.no = no;
		this.id = id;
		this.msg = msg;
		this.date = date;
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	
	
}
