package com.AleksandraAndPawel.transportcompanywebapp.Models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "reviews", schema = "systransport")
@EntityListeners(AuditingEntityListener.class)
public class ReviewsEntity {
    @Id
    @Column(name = "review_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewId;
    @Basic
    @Column(name = "stars", nullable = false)
    private String stars;
    @Basic
    @Column(name = "content", nullable = false, length = 255)
    private String content;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "package_id")
    private PackagesEntity packagesByPackageId;


    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }


    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewsEntity that = (ReviewsEntity) o;
        return reviewId == that.reviewId &&
                Objects.equals(stars, that.stars) &&
                Objects.equals(content, that.content) &&
                Objects.equals(packagesByPackageId, that.packagesByPackageId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(reviewId, stars, content, packagesByPackageId);
    }

    public PackagesEntity getPackagesByPackageId() {
        return packagesByPackageId;
    }

    public void setPackagesByPackageId(PackagesEntity packagesByPackageId) {
        this.packagesByPackageId = packagesByPackageId;
    }
}
