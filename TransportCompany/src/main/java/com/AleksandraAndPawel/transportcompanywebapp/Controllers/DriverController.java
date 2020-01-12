package com.AleksandraAndPawel.transportcompanywebapp.Controllers;

import com.AleksandraAndPawel.transportcompanywebapp.Models.*;
import com.AleksandraAndPawel.transportcompanywebapp.Repositories.API.IUserAccountsDao;
import com.AleksandraAndPawel.transportcompanywebapp.Services.DatabaseUserDetails;
import com.AleksandraAndPawel.transportcompanywebapp.Services.DriversService;
import com.AleksandraAndPawel.transportcompanywebapp.Services.PackageService;
import com.AleksandraAndPawel.transportcompanywebapp.Services.TransportService;
import com.AleksandraAndPawel.transportcompanywebapp.Web.PackageDto;
import com.AleksandraAndPawel.transportcompanywebapp.Web.TransportDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/driver")
public class DriverController {
    @Autowired
    TransportService transportService;
    @Autowired
    PackageService packageService;
    @Autowired
    DriversService driversService;

    @GetMapping
    public String logged(Model model,  @RequestParam(value = "transportAssigned", required = false)boolean transportAssigned,
                         @RequestParam(value = "notAllEnded", required = false)boolean notAllEnded){
        DatabaseUserDetails d = (DatabaseUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("login",d.getUserAccountsEntity().getLoginEmail());
        DriversEntity driver = driversService.getDriverByAccountId(d.getUserAccountsEntity().getAccountId());
        List<TransportsEntity> foundTransports = transportService.getAllDriversTransports(driver.getDriverId());
        List<TransportDto> transportDtos = new ArrayList();
        for (TransportsEntity transport : foundTransports
             ) {
            List<PackagesEntity> packages =packageService.getAllPackagesInTransport(transport.getTransportId());
            TransportDto transportDto = new TransportDto(transport.getTransportId(),transport.getTransportStatus(),
                    transport.getTransportCity(),driver.getDriverId(),packages.get(0).getClientsByClientId().getClientCity(),
                    packages.size());
            transportDtos.add(transportDto);
        }
        List<TransportsEntity> notAssigned = transportService.getAllNotAssignedTransports();
        List<TransportDto> freeTransports = new ArrayList();
        for (TransportsEntity transport : notAssigned
        ) {
            List<PackagesEntity> packages =packageService.getAllPackagesInTransport(transport.getTransportId());
            TransportDto transportDto = new TransportDto(transport.getTransportId(),transport.getTransportStatus(),
                    transport.getTransportCity(),driver.getDriverId(),packages.get(0).getClientsByClientId().getClientCity(),
                    packages.size());
            freeTransports.add(transportDto);
        }
        model.addAttribute("freeTransports",freeTransports);
        model.addAttribute("transports",transportDtos);
        if(notAllEnded)model.addAttribute("notAllEnded",true);
        if(transportAssigned)model.addAttribute("transportAssigned",true);
        return "driver.html";}

        @GetMapping("/viewPackage")
        public String viewPackage(Model model, @RequestParam(value = "packageId", required = true)Integer packageId,
                              @RequestParam(value = "transportId", required = true)Integer transportId,
                              @RequestParam(value = "pickUpSuccess", required = false)boolean pickUpSuccess,
                              @RequestParam(value = "transportEnRoute", required = false)boolean transportEnRoute,
                              @RequestParam(value = "packagePicked", required = false)boolean packagePicked,
                              @RequestParam(value = "packageDelivered", required = false)boolean packageDelivered,
                              @RequestParam(value = "deliverSuccess", required = false)boolean deliverSuccess)
        {
            PackageDto packDto = packageService.setUpPackageDto(packageService.getPackageById(packageId));
            model.addAttribute("package",packDto);
            model.addAttribute("transportId",transportId);
            if(pickUpSuccess) model.addAttribute("pickUpSuccess",true);
            if(transportEnRoute) model.addAttribute("transportEnRoute",true);
            if(packagePicked) model.addAttribute("packagePicked",true);
            if(packageDelivered) model.addAttribute("packageDelivered", true);
            if(deliverSuccess) model.addAttribute("deliverSuccess",true);
            return "viewPackage.html";
        }

        @GetMapping(value="/pickUpPackage")
    public RedirectView pickUpPackage(RedirectAttributes attributes, @RequestParam(value = "packageId", required = true)Integer packageId,
                                      @RequestParam(value = "transportId", required = true)Integer transportId)
        {
            attributes.addAttribute("packageId",packageId);
            attributes.addAttribute("transportId",transportId);
            if(!transportService.getTransport(transportId).getTransportStatus().equals(TransportStatus.WTRASIE))
            {
                attributes.addAttribute("transportEnRoute",true);
                return new RedirectView("/driver/viewPackage");
            }
            PackagesEntity pack = packageService.getPackageById(packageId);
            if(!pack.getPackageStatus().equals(PackageStatus.NIEODEBRANE))
            {
                attributes.addAttribute("packagePicked",true);
                return new RedirectView("/driver/viewPackage");
            }
            packageService.pickUpPackage(pack);
            attributes.addAttribute("pickUpSuccess",true);
            return new RedirectView("/driver/viewPackage");
        }

    @GetMapping(value="/deliverPackage")
    public RedirectView deliverPackage(RedirectAttributes attributes, @RequestParam(value = "packageId", required = true)Integer packageId,
                                      @RequestParam(value = "transportId", required = true)Integer transportId)
    {
        attributes.addAttribute("packageId",packageId);
        attributes.addAttribute("transportId",transportId);
        if(!transportService.getTransport(transportId).getTransportStatus().equals(TransportStatus.WTRASIE))
        {
            attributes.addAttribute("transportEnRoute",true);
            return new RedirectView("/driver/viewPackage");
        }
        PackagesEntity pack = packageService.getPackageById(packageId);
        if(!pack.getPackageStatus().equals(PackageStatus.ODEBRANE))
        {
            attributes.addAttribute("packageDelivered",true);
            return new RedirectView("/driver/viewPackage");
        }
        packageService.deliverPackage(pack);
        attributes.addAttribute("deliverSuccess",true);
        return new RedirectView("/driver/viewPackage");
    }



}

