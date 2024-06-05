package com.techelevator;

public class MovieRental {
    private String title;
    private String format;
    private boolean ispremiummovie;
    private double rentalPrice;


    public MovieRental(String title, String format, boolean ispremiummovie) {
        this.title = title;
        this.format = format;
        this.ispremiummovie = ispremiummovie;

    }

    public MovieRental() {
    }

    @Override
    public String toString(){
        return "Movie: "+ getTitle()+ " - "+" Format: "+getFormat()+ " - "+ " Price: "+ getRentalPrice();
    }

    public double lateCharge(int daysLate){
        if(daysLate==0){
            return 0;
        }
        if(daysLate==1){
            return 1.99;
        }
        if(daysLate==2){
            return 3.99;
        }else{
            return 19.99;
        }

    }





    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public boolean isIspremiummovie() {
        return ispremiummovie;
    }

    public void setIspremiummovie(boolean ispremiummovie) {
        this.ispremiummovie = ispremiummovie;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(String format) {
        if (format.contains("VHS")) {
            this.rentalPrice = .99;
        }
        if (format.contains("DVD")) {
            this.rentalPrice = 1.99;
        }
        if (format.contains("BluRay")) {
            this.rentalPrice = 2.99;
        }
    }
}
