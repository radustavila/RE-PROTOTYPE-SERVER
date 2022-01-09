package com.frizerii.protorype.repository;

import com.frizerii.protorype.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findAllByCv_Id(Long cvId);
}
