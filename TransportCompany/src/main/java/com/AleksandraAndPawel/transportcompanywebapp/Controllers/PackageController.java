package com.AleksandraAndPawel.transportcompanywebapp.Controllers;


import com.AleksandraAndPawel.transportcompanywebapp.Models.ClientsEntity;
import com.AleksandraAndPawel.transportcompanywebapp.Models.PackagesEntity;
import com.AleksandraAndPawel.transportcompanywebapp.Services.ClientService;
import com.AleksandraAndPawel.transportcompanywebapp.Services.DatabaseUserDetails;
import com.AleksandraAndPawel.transportcompanywebapp.Services.PackageService;
import com.AleksandraAndPawel.transportcompanywebapp.dto.PackageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller()
@RequestMapping("/client")
public class PackageController {

    @Autowired
    PackageService packageService;

    @Autowired
    ClientService clientService;

    // Dla metody GET w HTTP
    @GetMapping("/package")
    public String packageAddPage(Model model) {
        PackageDto packageDto= new PackageDto();
        model.addAttribute("package", packageDto);
        return "add_package.html";
    }

    //do metody która przesyła dane z przeglądarki do serwera
    @PostMapping("/package")
    public String packageAddForm(@ModelAttribute PackageDto packageDto) {
        packageService.addPackage(packageDto);
        return "redirect:/client/allPackages";
    }

    @GetMapping("/allPackages")
    public String allPackages(Model model) {
        DatabaseUserDetails d = (DatabaseUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ClientsEntity clientsEntity = clientService.getClientByAccountId(d.getUserAccountsEntity().getAccountId());
        List<PackagesEntity> packagesEntities = packageService.getAllPackagesByClientId(clientsEntity.getClientId());

        BigDecimal sum = new BigDecimal(0);
        for (PackagesEntity packagesEntity : packagesEntities) {
            sum = sum.add(packagesEntity.getPackagePrice());
        }

        model.addAttribute("sum", sum.toString());
        model.addAttribute("packages", packagesEntities);

        return "all_packages.html";
    }

}
