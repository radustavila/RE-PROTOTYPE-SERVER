package com.frizerii.protorype.service.impl;

import com.frizerii.protorype.entity.CV;
import com.frizerii.protorype.entity.Review;
import com.frizerii.protorype.repository.CVRepository;
import com.frizerii.protorype.repository.ReviewRepository;
import com.frizerii.protorype.repository.UserRepository;
import com.frizerii.protorype.service.CVService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CVServiceImpl implements CVService {

    private final CVRepository cvRepository;
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public CV saveCV(CV cv, Long userId) {
        cv.setUser(userRepository.getById(userId));
        return cvRepository.save(cv);
    }

    @Override
    public Review saveReview(Long userId, Long cvId, Review review) {
        review.setUser(userRepository.getById(userId));
        review.setCv(cvRepository.findById(userId).orElse(null));
        return reviewRepository.save(review);
    }

    @Override
    public List<CV> getAllCVs() {

        return cvRepository.findAll().stream().peek(cv -> {
            AtomicReference<Double> sum = new AtomicReference<>(0.0);
            List<Review> allReviews = reviewRepository.findAllByCv_Id(cv.getId());
            allReviews.forEach(r -> {
                sum.updateAndGet(v -> v + r.getStars());
            });
            cv.setOverallStars(sum.get() / allReviews.size());
        }).collect(Collectors.toList());
    }

    @Override
    public List<CV> getUserCvs(Long userId) {
        return getAllCVs().stream().filter(c -> c.getUser().getId().equals(userId)).collect(Collectors.toList());
    }

    @Override
    public List<Review> getAllReviews(Long cvId) {
        return reviewRepository.findAllByCv_Id(cvId);
    }
}
