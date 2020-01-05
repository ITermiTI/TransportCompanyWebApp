package com.AleksandraAndPawel.transportcompanywebapp.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class ReviewDto {

    @Min(value = 1)
    @Max(value = 5)
    private Integer stars;
    @NotBlank
    private String content;
    @NotBlank
    private Integer packageId;

    public ReviewDto(@Min(value = 1) @Max(value = 5) Integer stars, @NotBlank String content, @NotBlank Integer packageId) {
        this.stars = stars;
        this.content = content;
        this.packageId = packageId;
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
