package com.AleksandraAndPawel.transportcompanywebapp.Controllers;

import com.AleksandraAndPawel.transportcompanywebapp.Services.ReviewService;
import com.AleksandraAndPawel.transportcompanywebapp.dto.ReviewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/allReviews")
    public String allReviews() {
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
}
