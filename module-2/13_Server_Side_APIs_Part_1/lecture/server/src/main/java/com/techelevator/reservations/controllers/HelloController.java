package com.techelevator.reservations.controllers;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;


@RestController("http://localhost:8080/")
public class HelloController {


    @RequestMapping(path= "/hello",method = RequestMethod.GET)
    public String helloWorld(){
        return "hello world";
    }

    @RequestMapping(path= "/hello",method = RequestMethod.POST)
    public String helloWorld2(){
        return "hello world chess";
    }


    }




