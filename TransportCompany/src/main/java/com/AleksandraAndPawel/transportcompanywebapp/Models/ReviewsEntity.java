package com.AleksandraAndPawel.transportcompanywebapp.Models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

//@Entity
@Table(name = "reviews", schema = "systransport")
@EntityListeners(AuditingEntityListener.class)
public class ReviewsEntity {
    @Id
    @Column(name = "review_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int reviewId;
    @Basic
    @Column(name = "stars", nullable = false)
    private String stars;
    @Basic
    @Column(name = "content", nullable = false, length = 255)
    private String content;
    @Basic
    @Column(name = "package_id", nullable = false)
    private int packageId;

    private PackagesEntity packagesByPackageId;


    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }


    public Object getStars() {
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


    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReviewsEntity that = (ReviewsEntity) o;

        if (reviewId != that.reviewId) return false;
        if (packageId != that.packageId) return false;
        if (stars != null ? !stars.equals(that.stars) : that.stars != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = reviewId;
        result = 31 * result + (stars != null ? stars.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + packageId;
        return result;
    }

    public PackagesEntity getPackagesByPackageId() {
        return packagesByPackageId;
    }

    public void setPackagesByPackageId(PackagesEntity packagesByPackageId) {
        this.packagesByPackageId = packagesByPackageId;
    }
}
