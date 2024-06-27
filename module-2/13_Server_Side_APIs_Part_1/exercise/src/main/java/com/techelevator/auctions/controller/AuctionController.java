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
    public List<Auction> listOne(@RequestParam(name = "title_like",defaultValue = "") String title, @RequestParam(defaultValue = "0") double currentBid_lte) {

        // If both are provided
        if (!title.isEmpty() && currentBid_lte > 0.0) {
            return auctionDao.getAuctionsByTitleAndMaxBid(title, currentBid_lte);
        }

        // If bid is provided (but not title)
        if (currentBid_lte>0.00 && title.isEmpty()) {
            return auctionDao.getAuctionsByMaxBid(currentBid_lte);
        }

        // If title is provided (but not bid)
         if(!title.isEmpty()) {
             return auctionDao.getAuctionsByTitle(title);
         }

        return auctionDao.getAuctions();
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
