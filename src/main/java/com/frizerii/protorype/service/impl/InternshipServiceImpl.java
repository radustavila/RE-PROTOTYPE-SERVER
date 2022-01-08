package com.frizerii.protorype.service.impl;

import com.frizerii.protorype.dto.InternshipDto;
import com.frizerii.protorype.entity.Internship;
import com.frizerii.protorype.errors.CustomException;
import com.frizerii.protorype.repository.InternshipRepository;
import com.frizerii.protorype.repository.UserRepository;
import com.frizerii.protorype.service.InternshipService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Internship> getAllInternships() {
        return internshipRepository.findAll();
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
