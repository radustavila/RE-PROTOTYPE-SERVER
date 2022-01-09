package com.frizerii.protorype.dto;

import com.frizerii.protorype.entity.CV;
import com.frizerii.protorype.entity.Review;
import com.frizerii.protorype.entity.UsersEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReviewDto {

    private Long id;

    private Double stars;
    private String comments;
    private Long cvId;
    private Long userId;

    public ReviewDto(Review review) {
        this.id = review.getId();
        this.stars = review.getStars();
        this.comments = review.getComments();
        this.cvId = review.getCv().getId();
        this.userId = review.getUser().getId();
    }
}

