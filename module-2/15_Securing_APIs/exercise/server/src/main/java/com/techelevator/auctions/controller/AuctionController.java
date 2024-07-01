package com.techelevator.auctions.controller;

import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.dao.MemoryAuctionDao;
import com.techelevator.auctions.exception.DaoException;
import com.techelevator.auctions.model.Auction;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping("/auctions")
public class AuctionController {

    private AuthenticationController myfriend;

    private AuctionDao auctionDao;
    private RestTemplate hello;

    public AuctionController() {
        this.auctionDao = new MemoryAuctionDao();
    }

    @ResponseStatus(HttpStatus.FOUND)
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Auction> list(@RequestParam(defaultValue = "") String title_like, @RequestParam(defaultValue = "0") double currentBid_lte) {
        try {
            if (!title_like.equals("")) {
                return auctionDao.getAuctionsByTitle(title_like);
            }
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        try {
            if (currentBid_lte > 0) {
                return auctionDao.getAuctionsByMaxBid(currentBid_lte);
            }
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return auctionDao.getAuctions();
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable int id) {
        Auction auction = auctionDao.getAuctionById(id);
        if (auction == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Auction Not Found");
        } else {
            return auction;
        }
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER', 'CREATOR')")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    public Auction create(@Valid @RequestBody Auction auction) {
        return auctionDao.createAuction(auction);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER', 'CREATOR')")
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public Auction update(@Valid @RequestBody Auction auction, @PathVariable int id) {
        // The id on the path takes precedence over the id in the request body, if any
        auction.setId(id);
        try {
            Auction updatedAuction = auctionDao.updateAuction(auction);
            return updatedAuction;
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Auction Not Found");
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        auctionDao.deleteAuctionById(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @RequestMapping(path = "/whoami", method = RequestMethod.GET)
    public String whoAmI(@RequestHeader(name = "header") String name) {
        try {
            if (name != null) {
                return name;
            }
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
return null;
    }
}