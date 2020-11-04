package com.bridgelabz.hotelreservationsystem;

public class Hotel {
	
	public String hotelName;
	public String typeOfCustomer;
	public int weekdayRate;
	public int weekendRate;


	public Hotel(String hotelName, String typeOfCustomer, int weekdayRate, int weekendRate) {
        this.hotelName = hotelName;
        this.typeOfCustomer = typeOfCustomer;
        this.weekdayRate = weekdayRate;
        this.weekendRate = weekendRate;
    }
}