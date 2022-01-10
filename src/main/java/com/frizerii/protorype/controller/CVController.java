package com.frizerii.protorype.controller;

import com.frizerii.protorype.dto.ReviewDto;
import com.frizerii.protorype.entity.CV;
import com.frizerii.protorype.entity.Review;
import com.frizerii.protorype.service.CVService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


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
        return cvService.saveCV(cv, userId);
    }

    @GetMapping("/users/{userId}/CVs")
    public List<CV> getUserCvs(@PathVariable Long userId) {
        return cvService.getUserCvs(userId);
    }

    @GetMapping("/CVs/{cvId}/reviews")
    public List<ReviewDto> getAllReviews(@PathVariable Long cvId) {

        return cvService.getAllReviews(cvId).stream().map(ReviewDto::new).collect(Collectors.toList());
    }

    @PostMapping("/users/{userId}/CVs/{cvId}/reviews")
    public ReviewDto saveReviews(@PathVariable Long userId, @PathVariable Long cvId, @RequestBody Review review) {
        return new ReviewDto(cvService.saveReview(userId, cvId, review));
    }
}

