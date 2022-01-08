package com.frizerii.protorype.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Internship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String organizerName;
    private String startDate;
    private String endDate;
    private Double salary;
    private Integer internsNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizer_id", foreignKey = @ForeignKey(name = "FK_INTERNSHIP_USER"))
    private UsersEntity organizer;
}
