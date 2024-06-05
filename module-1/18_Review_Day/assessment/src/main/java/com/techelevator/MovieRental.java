package com.techelevator;

public class MovieRental {
    private String title;
    private String format;
    private boolean ispremiummovie;
    private int rentalPrice;


    public MovieRental(String title, String format, boolean ispremiummovie) {
        this.title = title;
        this.format = format;
        this.ispremiummovie = ispremiummovie;

    }

    @Override
    public String toString(){
        return "Movie: "+ getTitle()+ " - "+" Format: "+getFormat()+ " - "+ " Price: "+ getRentalPrice();
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

    public int getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(int rentalPrice) {
        this.rentalPrice = rentalPrice;
    }
}
