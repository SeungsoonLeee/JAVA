package subwayApp;

public class Station {
	private String lineNum;
	private String subStaNm;
	private int ridePasgrNum;
	private int alightPasgrNum;
	
	public Station() {
		// TODO Auto-generated constructor stub
	}

	public Station(String lineNum, String subStaNm, int ridePasgrNum, int alightPasgrNum) {
		super();
		this.lineNum = lineNum;
		this.subStaNm = subStaNm;
		this.ridePasgrNum = ridePasgrNum;
		this.alightPasgrNum = alightPasgrNum;
	}

	public String getLineNum() {
		return lineNum;
	}

	public void setLineNum(String lineNum) {
		this.lineNum = lineNum;
	}

	public String getSubStaNm() {
		return subStaNm;
	}

	public void setSubStaNm(String subStaNm) {
		this.subStaNm = subStaNm;
	}

	public int getRidePasgrNum() {
		return ridePasgrNum;
	}

	public void setRidePasgrNum(int ridePasgrNum) {
		this.ridePasgrNum = ridePasgrNum;
	}

	public int getAlightPasgrNum() {
		return alightPasgrNum;
	}

	public void setAlightPasgrNum(int alightPasgrNum) {
		this.alightPasgrNum = alightPasgrNum;
	}
	
	public void print() {
		System.out.println(lineNum);
		System.out.println(subStaNm);
		System.out.println(ridePasgrNum);
		System.out.println(alightPasgrNum);
	}
}
