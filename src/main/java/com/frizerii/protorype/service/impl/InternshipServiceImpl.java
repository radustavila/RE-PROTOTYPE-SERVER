package com.frizerii.protorype.service.impl;

import com.frizerii.protorype.dto.InternshipDto;
import com.frizerii.protorype.entity.Internship;
import com.frizerii.protorype.errors.CustomException;
import com.frizerii.protorype.repository.InternshipRepository;
import com.frizerii.protorype.repository.UserRepository;
import com.frizerii.protorype.service.InternshipService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class InternshipServiceImpl implements InternshipService {

    private final InternshipRepository internshipRepository;
    private final UserRepository userRepository;

    @Override
    public Internship saveInternship(InternshipDto internshipDto) {
        Internship internship = new Internship(internshipDto);
        internship.setOrganizer(userRepository.getById(internshipDto.getOrganizerId()));
        return internshipRepository.save(internship);

    }

    static class SortUtilDesc implements Comparator<Internship> {

        public int compare(Internship a, Internship b) {
            return (int) (b.getSalary() - a.getSalary());
        }
    }

    @Override
    public List<Internship> getAllInternships(String sorted, String ordered, Double start, Double stop) {

        List<Internship> internships = internshipRepository.findAll();
        if (sorted.equals("True")) {
            internships.sort(new SortUtilDesc());
            if (ordered.equals("Desc")) {
                Collections.reverse(internships);
            }
        }

        if (start != null) {
            internships = internships.stream().filter(i -> i.getSalary() >= start).collect(Collectors.toList());
        }
        if (stop != null) {
            internships = internships.stream().filter(i -> i.getSalary() <= stop).collect(Collectors.toList());
        }

        return internships;
    }

    @Override
    public Internship deleteInternship(Long userId, Long internshipId) {
        Internship internship = internshipRepository.findById(internshipId).orElse(null);
        if (internship != null) {
            if (!internship.getOrganizer().getId().equals(userId)) {
                throw new CustomException("The user does not own the internship");
            }
            internshipRepository.delete(internship);
        }
        return internship;
    }
}
