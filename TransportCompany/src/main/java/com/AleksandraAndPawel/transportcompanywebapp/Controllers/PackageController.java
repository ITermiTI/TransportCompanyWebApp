package com.AleksandraAndPawel.transportcompanywebapp.Controllers;


import com.AleksandraAndPawel.transportcompanywebapp.Models.PackagesEntity;
import com.AleksandraAndPawel.transportcompanywebapp.Services.PackageService;
import com.AleksandraAndPawel.transportcompanywebapp.dto.PackageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller()
@RequestMapping("/client")
public class PackageController {

    @Autowired
    PackageService packageService;

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
        return "redirect:/client/package";
    }

}
