package com.AleksandraAndPawel.transportcompany.controller;

import com.AleksandraAndPawel.transportcompany.repository.CarRepository;
import com.AleksandraAndPawel.transportcompany.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarController {

    private UserAccountRepository userAccountRepository;

    @Autowired
    public CarController(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @GetMapping("/")
    public String home() {
        System.out.println(userAccountRepository.count());
        return "Hello, world";
    }
}
