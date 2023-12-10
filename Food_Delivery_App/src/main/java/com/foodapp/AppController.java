package com.foodapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.foodapp.authrepository.UserSessionDAO;
 
@Controller

public class AppController {
    @Autowired
    private UserSessionDAO userSessionDAO;
     
    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }
    }
