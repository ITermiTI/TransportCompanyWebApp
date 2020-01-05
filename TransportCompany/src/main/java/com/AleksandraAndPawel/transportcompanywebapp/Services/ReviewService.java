package com.AleksandraAndPawel.transportcompanywebapp.Services;

import com.AleksandraAndPawel.transportcompanywebapp.Models.ReviewsEntity;
import com.AleksandraAndPawel.transportcompanywebapp.dto.ReviewDto;

import java.util.List;

public interface ReviewService {

    public List<ReviewsEntity> getAllReviews();
    public void addReview(ReviewDto reviewDto);
}
