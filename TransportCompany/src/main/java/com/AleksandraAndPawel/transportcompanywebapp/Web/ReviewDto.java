package com.AleksandraAndPawel.transportcompanywebapp.Web;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ReviewDto {

    private String stars;
    @NotBlank
    private String content;
    @NotNull
    private Integer packageId;

    public ReviewDto() {
    }

    public ReviewDto(String stars, @NotBlank String content, @NotNull Integer packageId) {
        this.stars = stars;
        this.content = content;
        this.packageId = packageId;
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

    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }
}
