package com.techelevator.auctions.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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
        Auction rett = restTemplate.getForObject(API_BASE_URL+"/"+id,Auction.class);

        Auction[]man = getAllAuctions();
        for (int i = 0; i < man.length ; i++) {
            if(id==man[i].getId()){
                return man[i];
            }

            HttpHeaders newOne = new HttpHeaders();
            newOne.setContentType(MediaType.APPLICATION_JSON);


        }



        // call api here
        return rett ;
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
        Auction[]juss = restTemplate.getForObject(API_BASE_URL+"/?title_like="+title,Auction[].class);
        listenUp= hope.toArray(listenUp);
        // call api here
        return juss;
    }

    public Auction[] getAuctionsAtOrBelowPrice(double price) {
        Auction[]returnKIng= new Auction[]{};
        List<Auction>keepThem = new ArrayList<>();
        Auction[] weKnew = getAllAuctions();
        for (int i = 0; i < weKnew.length ; i++) {
            if(weKnew[i].getCurrentBid()==price||weKnew[i].getCurrentBid()<=price){
                keepThem.add(weKnew[i]);
            }
        }
        returnKIng=keepThem.toArray(returnKIng);
        Auction[]myTime = restTemplate.getForObject(API_BASE_URL+"/?currentBid_lte=&<"+price,Auction[].class);
        return myTime;




    }

}
