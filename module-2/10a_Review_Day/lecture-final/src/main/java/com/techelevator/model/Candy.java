package com.techelevator.model;

// DOMAIN OBJECT (step one of DAO Pattern)
// Needs: getters/setters/constructors
// Nice to have: toString()
public class Candy {

    private int candyId;
    private String competitorName;
    private boolean chocolate;
    private boolean fruity;
    private boolean caramel;
    private boolean peanutyAlmondy;
    private boolean nougat;
    private boolean crispedRiceWafer;
    private boolean hard;
    private boolean bar;
    private boolean pluribus;
    private double sugarPercent;
    private double pricePercent;
    private double winPercent;


    @Override
    public String toString() {
        return "Candy {" +
                "candyId=" + candyId +
                ", competitorName='" + competitorName + '\'' +
                ", chocolate=" + chocolate +
                ", fruity=" + fruity +
                ", caramel=" + caramel +
                ", peanutyAlmondy=" + peanutyAlmondy +
                ", nougat=" + nougat +
                ", crispedRiceWafer=" + crispedRiceWafer +
                ", hard=" + hard +
                ", bar=" + bar +
                ", pluribus=" + pluribus +
                ", sugarPercent=" + sugarPercent +
                ", pricePercent=" + pricePercent +
                ", winPercent=" + winPercent +
                '}';
    }

    public Candy() { }

    public Candy(int candyId, String competitorName, boolean chocolate, boolean fruity, boolean caramel,
                 boolean peanutyAlmondy, boolean nougat, boolean crispedRiceWafer, boolean hard, boolean bar,
                 boolean pluribus, double sugarPercent, double pricePercent, double winPercent) {

        this.candyId = candyId;
        this.competitorName = competitorName;
        this.chocolate = chocolate;
        this.fruity = fruity;
        this.caramel = caramel;
        this.peanutyAlmondy = peanutyAlmondy;
        this.nougat = nougat;
        this.crispedRiceWafer = crispedRiceWafer;
        this.hard = hard;
        this.bar = bar;
        this.pluribus = pluribus;
        this.sugarPercent = sugarPercent;
        this.pricePercent = pricePercent;
        this.winPercent = winPercent;
    }

    public int getCandyId() {
        return candyId;
    }

    public void setCandyId(int candyId) {
        this.candyId = candyId;
    }

    public String getCompetitorName() {
        return competitorName;
    }

    public void setCompetitorName(String competitorName) {
        this.competitorName = competitorName;
    }

    public boolean isChocolate() {
        return chocolate;
    }

    public void setChocolate(boolean chocolate) {
        this.chocolate = chocolate;
    }

    public boolean isFruity() {
        return fruity;
    }

    public void setFruity(boolean fruity) {
        this.fruity = fruity;
    }

    public boolean isCaramel() {
        return caramel;
    }

    public void setCaramel(boolean caramel) {
        this.caramel = caramel;
    }

    public boolean isPeanutyAlmondy() {
        return peanutyAlmondy;
    }

    public void setPeanutyAlmondy(boolean peanutyAlmondy) {
        this.peanutyAlmondy = peanutyAlmondy;
    }

    public boolean isNougat() {
        return nougat;
    }

    public void setNougat(boolean nougat) {
        this.nougat = nougat;
    }

    public boolean isCrispedRiceWafer() {
        return crispedRiceWafer;
    }

    public void setCrispedRiceWafer(boolean crispedRiceWafer) {
        this.crispedRiceWafer = crispedRiceWafer;
    }

    public boolean isHard() {
        return hard;
    }

    public void setHard(boolean hard) {
        this.hard = hard;
    }

    public boolean isBar() {
        return bar;
    }

    public void setBar(boolean bar) {
        this.bar = bar;
    }

    public boolean isPluribus() {
        return pluribus;
    }

    public void setPluribus(boolean pluribus) {
        this.pluribus = pluribus;
    }

    public double getSugarPercent() {
        return sugarPercent;
    }

    public void setSugarPercent(double sugarPercent) {
        this.sugarPercent = sugarPercent;
    }

    public double getPricePercent() {
        return pricePercent;
    }

    public void setPricePercent(double pricePercent) {
        this.pricePercent = pricePercent;
    }

    public double getWinPercent() {
        return winPercent;
    }

    public void setWinPercent(double winPercent) {
        this.winPercent = winPercent;
    }
}
