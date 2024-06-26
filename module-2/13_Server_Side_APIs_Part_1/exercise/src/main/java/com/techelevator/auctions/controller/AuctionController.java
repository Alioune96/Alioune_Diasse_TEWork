package com.techelevator.auctions.controller;

import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.dao.MemoryAuctionDao;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

    private AuctionDao auctionDao;

    public AuctionController() {
        this.auctionDao = new MemoryAuctionDao();
    }
@RequestMapping(method = RequestMethod.GET)
    public List<Auction>listOne(@RequestParam (required = false)String title,@RequestParam(defaultValue = "0",required = false) double currentBid_lte){



        if(title==null&&currentBid_lte==0){

                return auctionDao.getAuctions();

        }
        if(title==null){
            if(currentBid_lte>=0) {
                List<Auction> listSeek = new ArrayList<>();
                List<Auction> justATry = auctionDao.getAuctions();
                for (int i = 0; i < justATry.size(); i++) {
                    if (justATry.get(i).getCurrentBid() <= currentBid_lte) {
                        listSeek.add(justATry.get(i));
                    }
                }
                return listSeek;

            }
        }
        if(title!=null){
            if(!title.isEmpty()){
                List<Auction>james = new ArrayList<>();
                List<Auction>kingPlace = auctionDao.getAuctions();
                for (int i = 0; i < kingPlace.size() ; i++) {
                    if(kingPlace.get(i).getTitle().toLowerCase().contains(title.toLowerCase())){
                        james.add(kingPlace.get(i));
                    }
                }return james;
            }
        }




    return null;

}



    @RequestMapping(path = "/{id}",method = RequestMethod.GET)
    public Auction get(@PathVariable int id){
        return auctionDao.getAuctionById(id);
    }


    @RequestMapping(method = RequestMethod.POST)
    public Auction create(@RequestBody Auction auction){
        if(auction!=null) {
            return auctionDao.createAuction(auction);
        }
        return null;
    }








}
