package com.frizerii.protorype.controller;

import com.frizerii.protorype.dto.InternshipDto;
import com.frizerii.protorype.entity.Internship;
import com.frizerii.protorype.service.InternshipService;
import com.frizerii.protorype.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class InternshipController {

    private final InternshipService internshipService;

    @GetMapping("/test")
    public String test() {
        return "OK";
    }

    @PostMapping("/users/{userId}/internships")
    public InternshipDto saveInternship(@PathVariable Long userId, @RequestBody InternshipDto internshipDto) {
        internshipDto.setOrganizerId(userId);
        return new InternshipDto(internshipService.saveInternship(internshipDto));
    }

    @DeleteMapping("/users/{userId}/internships/{internshipId}")
    public InternshipDto deleteInternship(@PathVariable Long userId, @PathVariable Long internshipId) {

        return new InternshipDto(internshipService.deleteInternship(userId, internshipId));
    }

    @GetMapping("/internships")
    public List<InternshipDto> getInternships() {
        return internshipService.getAllInternships()
                .stream().map(InternshipDto::new).collect(Collectors.toList());
    }

}
