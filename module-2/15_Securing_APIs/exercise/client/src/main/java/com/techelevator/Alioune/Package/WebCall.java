package com.techelevator.Alioune.Package;

import com.sun.net.httpserver.Headers;
import com.sun.tools.javac.Main;
import com.techelevator.auctions.model.Auction;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class WebCall {
    private  RestTemplate restTemplate;

    public static void main(String[] args) {

    }



    public Auction[] forDisplay(){
        Auction[]returnOne = restTemplate.getForObject("http://localhost:3000/hotels", Auction[].class);
        return returnOne;
    }

    public void AddAuction(String pathToAdd, Auction newAction){
        HttpHeaders newHeadOne = new HttpHeaders();
        newHeadOne.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Auction> addThis = new HttpEntity<>(newAction, newHeadOne);


        restTemplate.exchange("http://localhost:3000/hotels"+pathToAdd, HttpMethod.POST,addThis,Auction.class).getBody();

    }



}
