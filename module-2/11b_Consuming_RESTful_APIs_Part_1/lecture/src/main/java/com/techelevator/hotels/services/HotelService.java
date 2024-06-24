package com.techelevator.hotels.services;

import com.techelevator.hotels.model.Forecast;
import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Review;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class HotelService {

    private static final String API_BASE_URL = "http://localhost:3000";

//    private static final String secondOne = "http://localhost:3000/"
    private final RestTemplate restTemplate = new RestTemplate();

    public Hotel[] listHotels() {
        Hotel[] keepThem = restTemplate.getForObject(API_BASE_URL, Hotel[].class);


        return keepThem;
    }

    public Review[] listReviews() {
        return null;
    }

    public Hotel getHotelById(int id) {
        return null;
    }

    public Review[] getReviewsByHotelId(int hotelId) {
        return null;
    }

    public Hotel[] getHotelsByStarRating(int stars) {
        return null;
    }

    public Forecast getWithCustomQuery(){
        return null;
    }

}
