package com.techelevator.reservations.model;

import org.apache.tomcat.jni.Local;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

public class Reservation {


    private int id;

    @Min(value = 1, message = "HotelId is required!")
    private int hotelId;

    @NotBlank(message = "You must provide your name!")
    private String fullName;

    @NotBlank(message = "Check-In Date is required!")
    private String checkinDate;

    @NotBlank(message = "Check-Out Date is required!")
    private String checkoutDate;

    @Min(value = 1, message = "Can't have 0 (or negative) people!")
    @Max(value = 5, message = "No Parties!")
    private int guests;

//    @FutureOrPresent
//    private LocalDate chickenDate;
//    @FutureOrPresent
//    private LocalDate chickenOutDate;
//
//    @Valid
//    public boolean isValidDateRange() {
//        return chickenDate.isBefore(chickenOutDate);
//    }

    public Reservation(int id, int hotelId, String fullName, String checkinDate, String checkoutDate, int guests) {
        this.id = id;
        this.hotelId = hotelId;
        this.fullName = fullName;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.guests = guests;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(String checkinDate) {
        this.checkinDate = checkinDate;
    }

    public String getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        this.guests = guests;
    }

    @Override
    public String toString() {
        return "\n--------------------------------------------" + "\n Reservation Details"
                + "\n--------------------------------------------" + "\n Id: " + id + "\n Hotel Id: " + hotelId
                + "\n Full Name: " + fullName + "\n Checkin Date: " + checkinDate + "\n Checkout Date: " + checkoutDate
                + "\n Guests: " + guests;
    }
}
