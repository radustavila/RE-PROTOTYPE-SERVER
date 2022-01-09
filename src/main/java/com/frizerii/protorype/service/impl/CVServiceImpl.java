package com.frizerii.protorype.service.impl;

import com.frizerii.protorype.entity.CV;
import com.frizerii.protorype.repository.CVRepository;
import com.frizerii.protorype.repository.UserRepository;
import com.frizerii.protorype.service.CVService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CVServiceImpl implements CVService {

    private final CVRepository cvRepository;
    private final UserRepository userRepository;

    @Override
    public CV saveCV(CV cv, Long userId) {
        cv.setUser(userRepository.getById(userId));
        return cvRepository.save(cv);
    }

    @Override
    public List<CV> getAllCVs() {
        return cvRepository.findAll();
    }
}
