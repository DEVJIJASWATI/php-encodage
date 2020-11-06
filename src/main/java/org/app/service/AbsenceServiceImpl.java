package org.app.service;

import org.app.model.Absence;
import org.app.repository.AbsenceRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AbsenceServiceImpl implements AbsenceService {

    @Autowired
    AbsenceRepository absenceRepository;

    @Override
    public void save(Absence absence) {
        absenceRepository.save(absence);
    }
}
