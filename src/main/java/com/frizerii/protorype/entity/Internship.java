package com.frizerii.protorype.entity;

import com.frizerii.protorype.dto.InternshipDto;
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
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "organizer_id", foreignKey = @ForeignKey(name = "FK_INTERNSHIP_USER"))
    private UsersEntity organizer;

    public Internship(InternshipDto internshipDto) {
        this.id = internshipDto.getId();
        this.name = internshipDto.getName();
        this.description = internshipDto.getDescription();
        this.organizerName = internshipDto.getOrganizerName();
        this.startDate = internshipDto.getStartDate();
        this.endDate = internshipDto.getEndDate();
        this.salary = internshipDto.getSalary();
        this.internsNo = internshipDto.getInternsNo();
        this.phoneNumber = internshipDto.getPhoneNumber();
    }
}
