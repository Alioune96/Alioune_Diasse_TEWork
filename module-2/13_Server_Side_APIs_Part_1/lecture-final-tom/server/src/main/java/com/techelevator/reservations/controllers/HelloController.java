package com.techelevator.reservations.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    //  HTTP GET: /hello
    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public String helloWorld() {
        return "Hello World!";
    }

}
