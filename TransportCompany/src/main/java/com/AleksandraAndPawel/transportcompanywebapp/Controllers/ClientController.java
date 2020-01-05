package com.AleksandraAndPawel.transportcompanywebapp.Controllers;

import com.AleksandraAndPawel.transportcompanywebapp.Services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ReviewService reviewService;

    @GetMapping("/")
    public  String loggedClient()
    {
        return "client.html";
    }

    @GetMapping("/reviews")
    public String reviewAddPage() {
        return "add_review.html";
    }
}
