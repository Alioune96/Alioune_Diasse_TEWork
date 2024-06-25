package com.techelevator.hotels.services;

import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Reservation;
import com.techelevator.util.BasicLogger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;


public class HotelService {

    private static final String API_BASE_URL = "http://localhost:3000";
    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * Create a new reservation in the hotel reservation system
     */
    public Reservation addReservation(Reservation newReservation) {
        String url = API_BASE_URL + "/reservations";   // get the URL ready


        // Make the headers! (This code won't change)
        HttpHeaders headers = new HttpHeaders();             // make new Headers object
        headers.setContentType(MediaType.APPLICATION_JSON);  // Content-Type: application/json


        //  Pack the suitcase!
        //  <data type that's in the body>
        //            \/                                    data first
        HttpEntity<Reservation> request = new HttpEntity<>(newReservation, headers); // create the request entity (headers + body)

        Reservation returnedReservation = null;

        try {
            returnedReservation = restTemplate.postForObject(url, request, Reservation.class); // SEND IT!
        } catch (RestClientResponseException e) {
            // 4xx or 5xx error response code
        } catch (ResourceAccessException e) {
            // System is down!
        }

        return returnedReservation;
    }

    /**
     * Updates an existing reservation by replacing the old one with a new
     * reservation
     */
    //                                           New Source of Truth!
    public boolean updateReservation(Reservation updatedReservation) {

        String url = API_BASE_URL + "/reservations/" + updatedReservation.getId();

        HttpHeaders h = new HttpHeaders();
        h.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Reservation> putRequest = new HttpEntity<>(updatedReservation, h);

        try {
            restTemplate.put(url, putRequest);
            return true;
        } catch (ResourceAccessException e) {
            // Server unresponsive
        } catch (RestClientResponseException e) {
            // Server or Client error
        }

        return false;
    }

    /**
     * Delete an existing reservation
     */
    public boolean deleteReservation(int id) {
        String url = API_BASE_URL + "/reservations/" + id;
        boolean success;

        try {
            restTemplate.delete(url);
            success = true;
        } catch (RestClientResponseException e) {
            // 4xx or 5xx
            success = false;
        } catch (ResourceAccessException e) {
            // Server is down
            success = false;
        }

        return success;
    }

    /* DON'T MODIFY ANY METHODS BELOW */

    /**
     * List all hotels in the system
     */
    public Hotel[] listHotels() {
        Hotel[] hotels = null;
        try {
            hotels = restTemplate.getForObject(API_BASE_URL + "/hotels", Hotel[].class);
        } catch (RestClientResponseException e) {
            // handles exceptions thrown by rest template and contains status codes
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            // i/o error, ex: the server isn't running
            BasicLogger.log(e.getMessage());
        }
        return hotels;
    }

    /**
     * List all reservations in the hotel reservation system
     */
    public Reservation[] listReservations() {
        Reservation[] reservations = null;
        try {
            reservations = restTemplate.getForObject(API_BASE_URL + "/reservations", Reservation[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return reservations;
    }

    /**
     * List all reservations by hotel id.
     */
    public Reservation[] listReservationsByHotel(int hotelId) {
        Reservation[] reservations = null;
        try {
            reservations = restTemplate.getForObject(API_BASE_URL + "/hotels/" + hotelId + "/reservations", Reservation[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return reservations;
    }

    /**
     * Find a single reservation by the reservationId
     */
    public Reservation getReservation(int reservationId) {
        Reservation reservation = null;
        try {
            reservation = restTemplate.getForObject(API_BASE_URL + "/reservations/" + reservationId, Reservation.class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return reservation;
    }

}
