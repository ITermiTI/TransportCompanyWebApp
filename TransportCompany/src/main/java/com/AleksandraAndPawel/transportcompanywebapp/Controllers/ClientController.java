package com.AleksandraAndPawel.transportcompanywebapp.Controllers;

import com.AleksandraAndPawel.transportcompanywebapp.Models.ClientsEntity;
import com.AleksandraAndPawel.transportcompanywebapp.Models.ReviewsEntity;
import com.AleksandraAndPawel.transportcompanywebapp.Services.ClientService;
import com.AleksandraAndPawel.transportcompanywebapp.Services.DatabaseUserDetails;
import com.AleksandraAndPawel.transportcompanywebapp.Services.ReviewService;
import com.AleksandraAndPawel.transportcompanywebapp.dto.ClientDto;
import com.AleksandraAndPawel.transportcompanywebapp.dto.ReviewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller()
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ReviewService reviewService;

    @Autowired
    ClientService clientService;

    @GetMapping
    public  String loggedClient()
    {
        return "client.html";
    }


    @GetMapping("/allReviews")
    public String allReviews(Model model) {
        List<ReviewDto> reviewDtoList = new ArrayList<>();
        List<ReviewsEntity> reviewsEntities = reviewService.getAllReviews();

        for (ReviewsEntity reviewsEntity : reviewsEntities) {
            reviewDtoList.add(
                    new ReviewDto(
                            reviewsEntity.getStars(),
                            reviewsEntity.getContent(),
                            reviewsEntity.getPackagesByPackageId().getPackageId()
                    )
            );
        }

        model.addAttribute("reviews", reviewDtoList);
        return "all_reviews.html";
    }

    @GetMapping("/review")
    public String reviewAddPage(Model model, @RequestParam(value = "packageId", required = true) Integer packageId) {
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setPackageId(packageId);
        model.addAttribute("review", reviewDto);
        return "add_review.html";
    }

    @PostMapping("/review")
    public String reviewAddPost(@ModelAttribute ReviewDto reviewDto) {
        reviewService.addReview(reviewDto);
        return "redirect:/client/allReviews";
    }

    @GetMapping("/edit")
    public String editClientPage(Model model) {
        DatabaseUserDetails d = (DatabaseUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ClientsEntity clientsEntity = clientService.getClientByAccountId(d.getUserAccountsEntity().getAccountId());
        ClientDto clientDto = new ClientDto(clientsEntity.getClientAddress(), clientsEntity.getClientPhoneNumber());
        model.addAttribute("client", clientDto);
        return "edit_client.html";
    }

    @PostMapping("/edit")
    public String editClientForm(@ModelAttribute ClientDto clientDto) {
        clientService.updateClient(clientDto);
        return "redirect:/";
    }
}
