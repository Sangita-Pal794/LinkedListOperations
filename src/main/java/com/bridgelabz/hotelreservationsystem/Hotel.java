package com.bridgelabz.hotelreservationsystem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Stream;

public class Hotel {
	
	public String hotelName;
	public String typeOfCustomer;
	public Integer weekdayRate;
	public Integer weekendRate;
	public Integer totalCost;
	public Integer rating;


	public Hotel(String hotelName, String typeOfCustomer, Integer weekdayRate, Integer weekendRate, Integer rating) {
        this.hotelName = hotelName;
        this.typeOfCustomer = typeOfCustomer;
        this.weekdayRate = weekdayRate;
        this.weekendRate = weekendRate;
        this.rating = rating;
    }
	
	public String getHotelName() {
        return hotelName;
    }

    public String getTypeOfCustomer() {
        return typeOfCustomer;
    }

    public Integer getWeekdayRate() {
        return weekdayRate;
    }

    public Integer getWeekendRate() {
        return weekendRate;
    }

    public Integer getTotalCost(){
        return totalCost;
    }

    public void setTotalCost(Integer totalCost){
        this.totalCost = totalCost;
    }

    public Integer getRating() {
        return rating;
    }

    public Integer getTotalRate(LocalDate dateStart , LocalDate dateEnd , long difference) { //calculates total cost for hotel
        Optional<Integer> totalCost = Stream.iterate(dateStart , date -> date.plusDays(difference)).limit(dateEnd.getDayOfMonth() - dateStart.getDayOfMonth() + 1 ).map(date -> { if(date.getDayOfWeek().equals(DayOfWeek.SATURDAY) || date.getDayOfWeek().equals(DayOfWeek.SUNDAY)) return this.getWeekendRate();return this.getWeekdayRate();}).reduce((total , next) -> total+next);
        return totalCost.get();
    }
}