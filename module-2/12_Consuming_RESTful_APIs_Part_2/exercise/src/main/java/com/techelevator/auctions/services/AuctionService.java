package com.techelevator.auctions.services;

import com.techelevator.util.BasicLogger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.techelevator.auctions.model.Auction;

public class AuctionService {

    public static String API_BASE_URL = "http://localhost:3000/auctions";
    private RestTemplate restTemplate = new RestTemplate();


    public Auction add(Auction newAuction) {
        HttpHeaders listenUp = new HttpHeaders();
        listenUp.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Auction>couldyouTell = new HttpEntity<>(newAuction,listenUp);
        try{
            return restTemplate.postForObject(API_BASE_URL,couldyouTell, Auction.class);
        }catch (RestClientResponseException e){
            System.out.println("Your fault "+ e.getMessage());

        }catch (ResourceAccessException e){
            System.out.println("Server fault "+e.getMessage());
        }

        // place code here
        return null;
    }

    public boolean update(Auction updatedAuction) {
        HttpHeaders forLaugh = new HttpHeaders();
        forLaugh.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Auction>chessmelted = new HttpEntity<>(updatedAuction,forLaugh);
        String updated = API_BASE_URL+"/"+updatedAuction.getId();
        try{
            restTemplate.put(API_BASE_URL+"/"+updatedAuction.getId(),chessmelted);
            return true;
        }catch (RestClientResponseException e){
            System.out.println("Your fault "+ e.getMessage());

        }catch (ResourceAccessException e){
            System.out.println("Server fault "+e.getMessage());
        }
        // place code here
        return false;
    }

    public boolean delete(int auctionId) {

        try{
            restTemplate.delete(API_BASE_URL+"/"+auctionId);
            return true;

        }catch (RestClientResponseException e){
            System.out.println("Your fault");

        }catch (ResourceAccessException e){
            System.out.println("Server Fault");
        }

        // place code here
        return false;
    }

    public Auction[] getAllAuctions() {
        Auction[] auctions = null;
        try {
            auctions = restTemplate.getForObject(API_BASE_URL, Auction[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auctions;
    }

    public Auction getAuction(int id) {
        Auction auction = null;
        try {
            auction = restTemplate.getForObject(API_BASE_URL + "/" + id, Auction.class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auction;
    }

    public Auction[] getAuctionsMatchingTitle(String title) {
        Auction[] auctions = null;
        try {
            auctions = restTemplate.getForObject(API_BASE_URL + "?title_like=" + title, Auction[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auctions;
    }

    public Auction[] getAuctionsAtOrBelowPrice(double price) {
        Auction[] auctions = null;
        try {
            auctions = restTemplate.getForObject(API_BASE_URL + "?currentBid_lte=" + price, Auction[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auctions;
    }

    private HttpEntity<Auction> makeEntity(Auction auction) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(auction, headers);
    }

}
