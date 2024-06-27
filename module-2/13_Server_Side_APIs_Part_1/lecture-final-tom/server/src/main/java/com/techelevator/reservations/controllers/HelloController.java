package com.techelevator.reservations.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    //  HTTP GET: /hello
    @ResponseStatus(HttpStatus.OK) // 200 OK
    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public String helloWorld() {
        return "Hello World!";
    }

}
