package com.bridgelabz.hotelreservationsystem;

import java.time.Duration;
import java.time.LocalDate;
import java.util.*;

public class HotelReservation {
	
	public Hotel addHotel(String name , String type , int weekdayRate , int weekendRate,int rating) { //add hotel

        return new Hotel(name , type , weekdayRate , weekendRate , rating);
    }


public void setCost(ArrayList<Hotel> hotelArray , String dateS , String dateE) {  //gets total cost for each hotel and returns cheapest and best rated hotel

    Integer cost;
    LocalDate dateStart = null , dateEnd = null;

    try {
        dateStart = LocalDate.parse(dateS);
    } catch (Exception e) {
        System.out.println("Please enter proper starting date");
    }
    try {
        dateEnd = LocalDate.parse(dateE);
    } catch (Exception e) {
        System.out.println("Please enter proper ending date");
    }
    long difference = Duration.between(dateStart.atStartOfDay() , dateEnd.atStartOfDay()).toDays();

    for(Hotel hotel : hotelArray) {
        cost = hotel.getTotalRate(dateStart, dateEnd, difference);
        hotel.setTotalCost(cost);
    }
}


public Output getCheapestHotel(ArrayList<Hotel> hotelArray , String dateS , String dateE){ //compares total costs of hotels

    this.setCost(hotelArray , dateS , dateE);
    Optional<Hotel> cheapestHotel = hotelArray.stream().min(Comparator.comparingInt(hotel -> hotel.getTotalCost()));
    Output result = new Output();
    result.setHotelName(cheapestHotel.get().getHotelName());
    result.setTotalCost(cheapestHotel.get().getTotalCost());
    return result;
}

public Output findCheapestBestRatedHotel(ArrayList<Hotel> hotelArray , String dateS ,String dateE) {  //finds cheapest and best rated hotel

    Output output;
    output = this.getCheapestHotel(hotelArray , dateS , dateE);
    Optional<Hotel> maxCostHotel = hotelArray.stream().max(Comparator.comparingInt(hotel -> hotel.getTotalCost()));
    Optional<Hotel> minRatingHotel = hotelArray.stream().min(Comparator.comparingInt(hotel -> hotel.getRating()));
    for (Hotel hotel : hotelArray) {
        if (hotel.getTotalCost() < maxCostHotel.get().getTotalCost() && hotel.getRating() > minRatingHotel.get().getRating()) {
            output.setRating(hotel.getRating());
            output.setHotelName(hotel.getHotelName());
            output.setTotalCost(hotel.getTotalCost());
        }
    }
    return output;
}

public Output findBestRatedHotel(ArrayList<Hotel> hotelArray , String dateS , String dateE) { //returns best rated hotel for a date range

    Output result = new Output();
    this.setCost(hotelArray , dateS , dateE);
    Optional<Hotel> maxRatingHotel = hotelArray.stream().max(Comparator.comparingInt(hotel -> hotel.getRating()));
    result.setHotelName(maxRatingHotel.get().getHotelName());
    result.setTotalCost(maxRatingHotel.get().getTotalCost());
    result.setRating(maxRatingHotel.get().getRating());
    return result;
}
}
