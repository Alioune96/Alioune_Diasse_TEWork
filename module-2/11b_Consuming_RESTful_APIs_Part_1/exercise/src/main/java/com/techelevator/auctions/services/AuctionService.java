package com.techelevator.auctions.services;

import org.springframework.web.client.RestTemplate;

import com.techelevator.auctions.model.Auction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AuctionService {

    public static String API_BASE_URL = "http://localhost:3000/auctions";
    private RestTemplate restTemplate = new RestTemplate();


    public Auction[] getAllAuctions() {
        Auction[]returnFun = restTemplate.getForObject(API_BASE_URL, Auction[].class);


        // call api here
        return returnFun;
    }

    public Auction getAuction(int id) {

        Auction[]man = getAllAuctions();
        for (int i = 0; i < man.length ; i++) {
            if(id==man[i].getId()){
                return man[i];
            }

        }



        // call api here
        return null ;
    }

    public Auction[] getAuctionsMatchingTitle(String title) {
        List<Auction>hope = new ArrayList<>();
        Auction[]listenUp = new Auction[]{};
        Auction[]man = getAllAuctions();
        for (int i = 0; i < man.length; i++) {
            if(man[i].getTitle().equals(title)){
                hope.add(man[i]);
            }
        }

        listenUp= hope.toArray(listenUp);

        // call api here
        return listenUp;
    }

    public Auction[] getAuctionsAtOrBelowPrice(double price) {
        Auction[]returnKIng= new Auction[]{};
        List<Auction>keepThem = new ArrayList<>();
        Auction[] weKnew = getAllAuctions();
        for (int i = 0; i < weKnew.length ; i++) {
            if(weKnew[i].getCurrentBid()==price||weKnew[i].getCurrentBid()<price){
                keepThem.add(weKnew[i]);
            }
        }
        returnKIng=keepThem.toArray(returnKIng);
        return returnKIng;
    }

}
