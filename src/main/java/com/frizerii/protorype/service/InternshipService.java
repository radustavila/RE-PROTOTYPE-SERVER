package com.frizerii.protorype.service;

import com.frizerii.protorype.dto.InternshipDto;
import com.frizerii.protorype.entity.Internship;

import java.util.List;

public interface InternshipService {

    Internship saveInternship(InternshipDto internshipDto);
    List<Internship> getAllInternships(String sorted, String ordered, Double start, Double stop);
    Internship deleteInternship(Long userId, Long internshipId);

}
