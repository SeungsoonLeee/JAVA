package com.lee.jsp.sns;

public class SNSReply {
	private int no;
	private int snsNo;
	private String id;
	private String photo;
	private String reply;
	private String date;

	public SNSReply() {}
	
	public SNSReply(int no, int snsNo, String id, String photo, String reply, String date) {
		super();
		this.no = no;
		this.snsNo = snsNo;
		this.id = id;
		this.photo = photo;
		this.reply = reply;
		this.date = date;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getSnsNo() {
		return snsNo;
	}

	public void setSnsNo(int snsNo) {
		this.snsNo = snsNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
