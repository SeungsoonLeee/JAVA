package com.kwon.may22.converter;

public class Result {
	private int n;
	private String result;
	private String from;
	private String to;

	public Result() {
		// TODO Auto-generated constructor stub
	}

	public Result(int n, String result, String from, String to) {
		super();
		this.n = n;
		this.result = result;
		this.from = from;
		this.to = to;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

}
