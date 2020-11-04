package com.bridgelabz.hotelreservationsystem;

public class HotelReservation {
	
	Hotel addHotel(String name , String type , int weekday , int weekend) {
        return new Hotel(name , type , weekday , weekend);
    }
}
