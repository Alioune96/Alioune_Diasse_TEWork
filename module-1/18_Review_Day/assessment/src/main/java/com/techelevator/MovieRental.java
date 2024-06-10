package com.techelevator;

public class MovieRental {

    private String title;
    private String format;
    private boolean isPremiumMovie;
    private double rentalPrice;

    public MovieRental(String title, String format, boolean isPremiumMovie) {
        this.title = title;
        this.format = format;
        this.isPremiumMovie = isPremiumMovie;
    }


    public double getRentalPrice(){
        double storeTotal = 0;
        if(getFormat()=="VHS"){
            storeTotal+=.99;
        }
        else if(format.contains("Blu-Ray")){
            storeTotal+=2.99;
        }
        else if (format.contains("DVD")) {
            storeTotal+=1.99;

        }
        if(isPremiumMovie==true){
            storeTotal+=1;
        }

        return storeTotal;
    }


    public double MovieLateFee(int daysLate){
        if(daysLate==0){
            return 0;
        } else if (daysLate==1) {
            return 1.99;
        } else if (daysLate==2) {
            return 3.99;
        }else {
            return 19.99;
        }

    }







@Override
public String toString(){
        return "Movie: "+getTitle() + " - "+ "Format: "+ getFormat()+ " - "+ "Price: "+ getRentalPrice();
}

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setPremiumMovie(boolean premiumMovie) {
        isPremiumMovie = premiumMovie;
    }

    public String getTitle() {
        return title;
    }

    public String getFormat() {
        return format;
    }

    public boolean isPremiumMovie() {
        return isPremiumMovie;
    }
}
