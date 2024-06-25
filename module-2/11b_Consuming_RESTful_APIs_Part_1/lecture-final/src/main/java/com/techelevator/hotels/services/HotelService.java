package com.techelevator.hotels.services;

import com.techelevator.hotels.model.Forecast;
import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Review;
import org.springframework.web.client.RestTemplate;

public class HotelService {

    private static final String API_BASE_URL = "http://localhost:3000";
    private final RestTemplate restTemplate = new RestTemplate();

    public Hotel[] listHotels() {
        // .getForObject(String url, );
        //          http://localhost:3000/hotels
        String fullURL = API_BASE_URL + "/hotels";

        Hotel[] results = restTemplate.getForObject(fullURL, Hotel[].class);

        return results;
    }

    public Review[] listReviews() {
        String fullURL = API_BASE_URL + "/reviews";    // "http://localhost:3000/reviews"

        Review[] results = restTemplate.getForObject(fullURL, Review[].class);

        return results;
    }

    public Hotel getHotelById(int id) {  // http://localhost:3000/hotels/x
        return restTemplate.getForObject(API_BASE_URL + "/hotels/" + id, Hotel.class);
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
