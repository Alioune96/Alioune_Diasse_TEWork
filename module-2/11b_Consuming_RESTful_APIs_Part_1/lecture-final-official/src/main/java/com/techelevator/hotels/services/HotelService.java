package com.techelevator.hotels.services;

import com.techelevator.hotels.model.Forecast;
import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Review;
import org.springframework.web.client.RestTemplate;

public class HotelService {

    private static final String API_BASE_URL = "http://localhost:3000";
    private final RestTemplate restTemplate = new RestTemplate();

    public Hotel[] listHotels() {
        return restTemplate.getForObject(API_BASE_URL + "/hotels", Hotel[].class);
    }

    public Review[] listReviews() {
        return restTemplate.getForObject(API_BASE_URL + "/reviews", Review[].class);
    }

    public Hotel getHotelById(int id) {
        return restTemplate.getForObject(API_BASE_URL + "/hotels/" + id, Hotel.class);
    }

    public Review[] getReviewsByHotelId(int hotelId) {
        return restTemplate.getForObject(API_BASE_URL + "/hotels/" + hotelId + "/reviews", Review[].class);
    }

    public Hotel[] getHotelsByStarRating(int stars) {
        return restTemplate.getForObject(API_BASE_URL + "/hotels?stars=" + stars, Hotel[].class);
    }

    public Forecast getWithCustomQuery(){
        return restTemplate.getForObject("https://teapi.netlify.app/api/weather/geo/41.5194,-81.6421/forecast", Forecast.class);
    }

}
