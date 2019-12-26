package com.AleksandraAndPawel.transportcompany.controller;

import com.AleksandraAndPawel.transportcompany.repository.DriverRepository;
import com.AleksandraAndPawel.transportcompany.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarController {

    private UserAccountRepository userAccountRepository;
    private DriverRepository driverRepository;

    @Autowired
    public CarController(UserAccountRepository userAccountRepository, DriverRepository driverRepository) {
        this.userAccountRepository = userAccountRepository;
        this.driverRepository = driverRepository;
    }

    @GetMapping("/")
    public String home() {
        //System.out.println(userAccountRepository.count());
        System.out.println("TEST: " + driverRepository.findById(1).get().getDriverEmail());
        return "Hello, world";
    }
}
