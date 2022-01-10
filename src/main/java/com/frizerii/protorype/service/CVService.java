package com.frizerii.protorype.service;

import com.frizerii.protorype.dto.InternshipDto;
import com.frizerii.protorype.entity.CV;
import com.frizerii.protorype.entity.Internship;
import com.frizerii.protorype.entity.Review;

import java.util.List;

public interface CVService {

    CV saveCV(CV cv, Long userId);
    Review saveReview(Long userId, Long cvId, Review review);
    List<CV> getAllCVs();
    List<CV> getUserCvs(Long userId);
    List<Review> getAllReviews(Long cvId);
}
