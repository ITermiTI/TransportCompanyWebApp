package com.AleksandraAndPawel.transportcompanywebapp.Services;

import com.AleksandraAndPawel.transportcompanywebapp.Models.ReviewsEntity;
import com.AleksandraAndPawel.transportcompanywebapp.Repositories.Implementation.PackagesDao;
import com.AleksandraAndPawel.transportcompanywebapp.Repositories.Implementation.ReviewsDao;
import com.AleksandraAndPawel.transportcompanywebapp.dto.ReviewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewsDao reviewsDao;

    @Autowired
    PackagesDao packagesDao;

    @Override
    public List<ReviewsEntity> getAllReviews() {
        return reviewsDao.getAll();
    }

    @Override
    public void addReview(ReviewDto reviewDto) {
        ReviewsEntity reviewsEntity = new ReviewsEntity();
        reviewsEntity.setContent(reviewDto.getContent());
        reviewsEntity.setStars(String.valueOf(reviewDto.getStars()));
        reviewsEntity.setPackagesByPackageId(packagesDao.getById(reviewDto.getPackageId()));

        reviewsDao.add(reviewsEntity);
    }
}
