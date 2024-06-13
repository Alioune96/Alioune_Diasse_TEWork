package com.techelevator;

public class CityFORTEST {
    private int city_id;
    private String city_name;
    private String state_abbreviation;
    private int population;
    private double area;

    public CityFORTEST(int city_id, String city_name, String state_abbreviation, int population, double area) {
        this.city_id = city_id;
        this.city_name = city_name;
        this.state_abbreviation = state_abbreviation;
        this.population = population;
        this.area = area;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getState_abbreviation() {
        return state_abbreviation;
    }

    public void setState_abbreviation(String state_abbreviation) {
        this.state_abbreviation = state_abbreviation;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
