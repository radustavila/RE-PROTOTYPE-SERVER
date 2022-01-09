package com.frizerii.protorype.service;

import com.frizerii.protorype.dto.InternshipDto;
import com.frizerii.protorype.entity.CV;
import com.frizerii.protorype.entity.Internship;

import java.util.List;

public interface CVService {
    CV saveCV(CV cv, Long userId);

    List<CV> getAllCVs();
}
