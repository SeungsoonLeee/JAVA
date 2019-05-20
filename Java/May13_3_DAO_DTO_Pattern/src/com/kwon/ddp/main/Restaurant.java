package com.kwon.ddp.main;
// DTO(Data Temp/Transfer Object)
//		입력한 내용
//		그 작업 결과
public class Restaurant {
	private String rName;
	private String rAddr;

	public Restaurant() {
		// TODO Auto-generated constructor stub
	}

	public Restaurant(String rName, String rAddr) {
		super();
		this.rName = rName;
		this.rAddr = rAddr;
	}

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}

	public String getrAddr() {
		return rAddr;
	}

	public void setrAddr(String rAddr) {
		this.rAddr = rAddr;
	}

	public void print() {
		System.out.println(rName);
		System.out.println(rAddr);
	}
}
