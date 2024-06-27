package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.MemoryHotelDao;
import com.techelevator.reservations.dao.MemoryReservationDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.model.Hotel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelController {

    private HotelDao hotelDao;
    private ReservationDao reservationDao;

    // Spring Boot magically instantiates this!
    public HotelController() {
        this.hotelDao = new MemoryHotelDao();
        this.reservationDao = new MemoryReservationDao(hotelDao);
    }

    /**
     * Return All Hotels
     *
     * @return a list of all hotels in the system
     */

    // GET /hotels
    // GET /hotels?city=x&state=y
    @ResponseStatus(HttpStatus.OK) // 200 OK
    @RequestMapping(path = "/hotels", method = RequestMethod.GET)
    public List<Hotel> list(@RequestParam(defaultValue = "") String city, @RequestParam(defaultValue = "") String state) {
        return hotelDao.getHotelsByStateAndCity(state, city);
    }

    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    @ResponseStatus(HttpStatus.OK) // 200 OK
    @RequestMapping(path = "/hotels/{hotelId}", method = RequestMethod.GET)
    public Hotel get(@PathVariable(name = "hotelId") int id) {
        return hotelDao.getHotelById(id);
    }

}
