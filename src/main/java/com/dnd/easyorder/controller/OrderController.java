package com.dnd.easyorder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {

    @GetMapping("/test")
    public String index(){
        return "myfile.html";
    }
}
