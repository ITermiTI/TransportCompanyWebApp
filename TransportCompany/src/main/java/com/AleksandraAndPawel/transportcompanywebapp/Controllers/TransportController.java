package com.AleksandraAndPawel.transportcompanywebapp.Controllers;

import com.AleksandraAndPawel.transportcompanywebapp.Models.*;
import com.AleksandraAndPawel.transportcompanywebapp.Services.DatabaseUserDetails;
import com.AleksandraAndPawel.transportcompanywebapp.Services.DriversService;
import com.AleksandraAndPawel.transportcompanywebapp.Services.PackageService;
import com.AleksandraAndPawel.transportcompanywebapp.Services.TransportService;
import com.AleksandraAndPawel.transportcompanywebapp.Web.PackageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/driver")
public class TransportController {
    @Autowired
    TransportService transportService;
    @Autowired
    PackageService packageService;
    @Autowired
    DriversService driversService;

    @GetMapping("/transport")
    public String operateOnTransport(Model model, @RequestParam(value = "transportId", required = true)Integer transportId,
                                     @RequestParam(value = "startSuccess", required = false)boolean startSuccess,
                                     @RequestParam(value = "endSuccess", required = false)boolean endSuccess,
                                     @RequestParam(value = "transportNotEnRoute", required = false)boolean transportNotEnRoute,
                                     @RequestParam(value = "transportStarted", required = false)boolean transportStarted,
                                     @RequestParam(value = "notAllDelivered", required = false)boolean notAllDelivered)
    {
        List<PackagesEntity> packages =packageService.getAllPackagesInTransport(transportId);
        List<PackageDto> packageDtos = new ArrayList();
        for (PackagesEntity pack: packages
        ) {
            packageDtos.add(packageService.setUpPackageDto(pack));
        }
        DatabaseUserDetails d = (DatabaseUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("transportId",transportId);
        model.addAttribute("packages",packageDtos);
        model.addAttribute("login",d.getUserAccountsEntity().getLoginEmail());
        if(startSuccess)model.addAttribute("startSuccess",true);
        if(endSuccess)model.addAttribute("endSuccess",true);
        if(transportNotEnRoute)model.addAttribute("transportNotEnRoute",true);
        if(transportStarted)model.addAttribute("transportStarted",true);
        if(notAllDelivered)model.addAttribute("notAllDelivered",true);
        return "transport.html";
    }

    @GetMapping(value="/startTransport")
    public RedirectView startTransport(RedirectAttributes attributes,
                                       @RequestParam(value = "transportId", required = true)Integer transportId)
    {
        attributes.addAttribute("transportId",transportId);
        if(!transportService.getTransport(transportId).getTransportStatus().equals(TransportStatus.OCZEKUJE))
        {
            attributes.addAttribute("transportStarted",true);
            return new RedirectView("/driver/transport");
        }
        transportService.startTransport(transportId);
        attributes.addAttribute("startSuccess",true);
        return new RedirectView("/driver/transport");
    }

    @GetMapping(value="/endTransport")
    public RedirectView endTransport(RedirectAttributes attributes,
                                     @RequestParam(value = "transportId", required = true)Integer transportId)
    {
        attributes.addAttribute("transportId",transportId);
        if(!transportService.getTransport(transportId).getTransportStatus().equals(TransportStatus.WTRASIE))
        {
            attributes.addAttribute("transportNotEnRoute",true);
            return new RedirectView("/driver/transport");
        }
        boolean allDelivered = true;
        List<PackagesEntity> packages = packageService.getAllPackagesInTransport(transportId);
        for (PackagesEntity pack: packages
        ) {
            if(!pack.getPackageStatus().equals(PackageStatus.DOSTARCZONE)) allDelivered=false;
        }
        if(!allDelivered)
        {
            attributes.addAttribute("notAllDelivered",true);
            return new RedirectView("/driver/transport");
        }
        transportService.endTransport(transportId);
        attributes.addAttribute("endSuccess",true);
        return new RedirectView("/driver/transport");
    }

    @GetMapping("/assignTransport")
    public RedirectView assignTransport(RedirectAttributes attributes, @RequestParam(value="transportId", required=true) Integer transportId)
    {
        DatabaseUserDetails d = (DatabaseUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        attributes.addAttribute("login",d.getUserAccountsEntity().getLoginEmail());
        DriversEntity driver = driversService.getDriverByAccountId(d.getUserAccountsEntity().getAccountId());
        List<TransportsEntity> driversTransports= transportService.getAllDriversTransports(driver.getDriverId());
        boolean allEnded=true;
        for (TransportsEntity transport: driversTransports
             ) {
            if(!transport.getTransportStatus().equals(TransportStatus.ZAKONCZONE)) allEnded=false;
        }
        if(!allEnded)
        {
            attributes.addAttribute("notAllEnded",true);
            return new RedirectView("/driver");
        }
        transportService.assignDriver(driver.getDriverId(),transportId);
        attributes.addAttribute("transportAssigned",true);
        return new RedirectView("/driver");
    }
}
