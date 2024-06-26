package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.MemoryHotelDao;
import com.techelevator.reservations.dao.MemoryReservationDao;
import com.techelevator.reservations.model.Reservation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReservationController {
    private HotelDao keep = new MemoryHotelDao();
    private MemoryReservationDao makere;
    public ReservationController(){

        this.makere= new MemoryReservationDao(keep);
    }


    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)

    @RequestMapping(path = "/reservations", method = RequestMethod.POST)
    public Reservation addreservation(@RequestBody Reservation reservation){
        return makere.createReservation(reservation);
    }


}
