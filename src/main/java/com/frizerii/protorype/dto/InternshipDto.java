package com.frizerii.protorype.dto;

import com.frizerii.protorype.entity.Internship;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InternshipDto {
    private Long id;
    private String name;
    private String description;
    private String organizerName;
    private String startDate;
    private String endDate;
    private Double salary;
    private String phoneNumber;
    private Integer internsNo;
    private Long organizerId;


    public InternshipDto(Internship internship) {
        this.id = internship.getId();
        this.name = internship.getName();
        this.description = internship.getDescription();
        this.organizerName = internship.getOrganizerName();
        this.startDate = internship.getStartDate();
        this.endDate = internship.getEndDate();
        this.salary = internship.getSalary();
        this.phoneNumber = internship.getPhoneNumber();
        this.internsNo = internship.getInternsNo();
        this.organizerId = internship.getOrganizer().getId();
    }
}
