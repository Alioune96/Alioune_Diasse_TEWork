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

import java.util.ArrayList;
import java.util.List;


public class HotelService {

    private static final String API_BASE_URL = "http://localhost:3000";
    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * Create a new reservation in the hotel reservation system
     */
    public Reservation addReservation(Reservation newReservation) {
//        Reservation newGuy = new Reservation();
//        newGuy.setId(newReservation.getId());
//        newGuy.setFullName(newReservation.getFullName());
//        newGuy.setHotelId(newReservation.getHotelId());
//        newGuy.setCheckinDate(newReservation.getCheckinDate());
//        newGuy.setCheckoutDate(newReservation.getCheckoutDate());
//        newGuy.setGuests(newReservation.getGuests());
        HttpHeaders twoTime = new HttpHeaders();
        twoTime.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Reservation> willDo = new HttpEntity<>(newReservation,twoTime);
        try {
           Reservation tryThis = restTemplate.postForObject(API_BASE_URL + "/reservations", willDo, Reservation.class);
            return tryThis;
        }catch (ResourceAccessException e){
            System.out.println("our fault "+e.getMessage());
        }catch (RestClientResponseException e){
            System.out.println("Your fault "+ e.getResponseHeaders());
        }

//        Reservation keepTHis = restTemplate.postForObject(API_BASE_URL+"?")

        // TODO: Implement method
        return null;
    }

    /**
     * Updates an existing reservation by replacing the old one with a new
     * reservation
     */
    public boolean updateReservation(Reservation updatedReservation) {
        Reservation jamess = new Reservation();
        jamess.setId(updatedReservation.getId());
        jamess.setHotelId(updatedReservation.getHotelId());
        jamess.setFullName(updatedReservation.getFullName());
        jamess.setCheckinDate(updatedReservation.getCheckinDate());
        jamess.setCheckoutDate(updatedReservation.getCheckoutDate());
        jamess.setGuests(updatedReservation.getGuests());



HttpHeaders hy = new HttpHeaders();
hy.setContentType(MediaType.APPLICATION_JSON);
HttpEntity<Reservation> kkep =new HttpEntity<>(updatedReservation,hy);
          restTemplate.put(API_BASE_URL+"/reservations/"+updatedReservation.getId(),kkep);
          if(jamess.getId()==updatedReservation.getId()){
              return true;
          }

        // TODO: Implement method
        return false;
    }

    /**
     * Delete an existing reservation
     */
    public boolean deleteReservation(int id) {

        restTemplate.delete(API_BASE_URL+"/newGuy/"+id);
        // TODO: Implement method
        return false;
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
