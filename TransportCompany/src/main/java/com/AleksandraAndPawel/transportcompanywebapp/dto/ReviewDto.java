package com.AleksandraAndPawel.transportcompanywebapp.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ReviewDto {

    @Min(value = 1)
    @Max(value = 5)
    private Integer stars;
    @NotBlank
    private String content;
    @NotNull
    private Integer packageId;

    public ReviewDto() {
    }

    public ReviewDto(@Min(value = 1) @Max(value = 5) Integer stars, @NotBlank String content, @NotNull Integer packageId) {
        this.stars = stars;
        this.content = content;
        this.packageId = packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStars() {
        return stars;
    }

    public String getContent() {
        return content;
    }

    public Integer getPackageId() {
        return packageId;
    }
}
