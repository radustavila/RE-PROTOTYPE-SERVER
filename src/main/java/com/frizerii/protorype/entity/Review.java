package com.frizerii.protorype.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double stars;
    private String comments;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cv_id", foreignKey = @ForeignKey(name = "FK_REVIEW_CV"))
    private CV cv;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_REVIEW_USER"))
    private UsersEntity user;
}
