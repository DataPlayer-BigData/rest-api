package com.codecompass.restapi.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("meeting")
public class mettingController {
    @Value("${spring.message}")

    private String msg;
    @GetMapping("/")
    public  String mm() {
      return "<html><h1>Welcome shabbir to Meeting Minute Application</h1><p>Meeting can be captured, searched easily.</p></html>";
       //return msg;
    }
}
