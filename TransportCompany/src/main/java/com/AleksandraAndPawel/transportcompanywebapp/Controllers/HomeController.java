package com.AleksandraAndPawel.transportcompanywebapp.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home()
    {
        return "home.html";
    }
    @GetMapping("/driver")
    public String loggedDriver()
    {
        return "driver.html";
    }

}

