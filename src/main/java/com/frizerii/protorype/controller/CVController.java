package com.frizerii.protorype.controller;

import com.frizerii.protorype.dto.InternshipDto;
import com.frizerii.protorype.entity.CV;
import com.frizerii.protorype.service.CVService;
import com.frizerii.protorype.service.InternshipService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CVController {

    private final CVService cvService;

    @GetMapping("/CVs")
    public List<CV> getAllCVs() {

        return cvService.getAllCVs();
    }

    @PostMapping("/users/{userId}/CVs")
    public CV saveInternship(@PathVariable Long userId, @RequestBody CV cv) {
        return cvService.saveCV(cv,userId);
    }
}

