package com.kwon.jm2.main;

public class Human {
	private String name;
	private double height;
	private double weight;
	private double stdWeight;
	private double bimando;
	private String fileName;
	private String result;

	public Human() {
		// TODO Auto-generated constructor stub
	}

	public Human(String name, double height, double weight, double stdWeight, double bimando, String fileName,
			String result) {
		super();
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.stdWeight = stdWeight;
		this.bimando = bimando;
		this.fileName = fileName;
		this.result = result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getStdWeight() {
		return stdWeight;
	}

	public void setStdWeight(double stdWeight) {
		this.stdWeight = stdWeight;
	}

	public double getBimando() {
		return bimando;
	}

	public void setBimando(double bimando) {
		this.bimando = bimando;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
