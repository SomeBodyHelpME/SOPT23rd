package org.sopt.service;

import org.sopt.model.University;

public interface UniversityService {
    University getByUniversityName(final String UniversityName);
}
