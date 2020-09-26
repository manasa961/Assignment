package com.test.cms.model;

import java.util.Date;

public class Car 
{
	private String company;
	private String model;
	private String color;
	private Date dateOfPurchase;
	private Double price;
	private String engineCapacity;
	private String plateNumber;
	private int seatingCapacity;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(String company, String model, String color, Date dateOfPurchase, Double price, String engineCapacity,
			String plateNumber, int seatingCapacity) {
		this.company = company;
		this.model = model;
		this.color = color;
		this.dateOfPurchase = dateOfPurchase;
		this.price = price;
		this.engineCapacity = engineCapacity;
		this.plateNumber = plateNumber;
		this.seatingCapacity = seatingCapacity;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getEngineCapacity() {
		return engineCapacity;
	}

	public void setEngineCapacity(String engineCapacity) {
		this.engineCapacity = engineCapacity;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public int getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	@Override
	public String toString() {
		return "Car [company=" + company + ", model=" + model + ", color=" + color + ", dateOfPurchase="
				+ dateOfPurchase + ", price=" + price + ", engineCapacity=" + engineCapacity + ", plateNumber="
				+ plateNumber + ", seatingCapacity=" + seatingCapacity + "]";
	}
	
	
}
