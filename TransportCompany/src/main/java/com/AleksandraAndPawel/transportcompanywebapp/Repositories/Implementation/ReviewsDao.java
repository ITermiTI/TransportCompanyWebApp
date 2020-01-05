package com.AleksandraAndPawel.transportcompanywebapp.Repositories.Implementation;

import com.AleksandraAndPawel.transportcompanywebapp.Models.ReviewsEntity;
import com.AleksandraAndPawel.transportcompanywebapp.Repositories.API.IReviewsDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ReviewsDao extends GenericDao<ReviewsEntity> implements IReviewsDao {
}
