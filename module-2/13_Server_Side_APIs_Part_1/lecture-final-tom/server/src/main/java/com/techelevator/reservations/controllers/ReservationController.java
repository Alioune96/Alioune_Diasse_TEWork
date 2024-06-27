package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.MemoryHotelDao;
import com.techelevator.reservations.dao.MemoryReservationDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.model.Reservation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReservationController {

    private ReservationDao rezDao;

    public ReservationController() {
        HotelDao hDao = new MemoryHotelDao();
        this.rezDao = new MemoryReservationDao(hDao);
    }


    // Create a new reservation!
    @ResponseStatus(HttpStatus.CREATED)  // 201 CREATED
    @RequestMapping(path = "/reservations", method = RequestMethod.POST)
    public Reservation addReservation(@RequestBody Reservation newReservation) {
        return rezDao.createReservation(newReservation);
    }


}
