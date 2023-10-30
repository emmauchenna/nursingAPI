package com.kloudvista.nursingAPI.service;

import com.kloudvista.nursingAPI.domain.Nurse;
import com.kloudvista.nursingAPI.domain.Qualification;
import com.kloudvista.nursingAPI.dto.NewNurseResp;
import com.kloudvista.nursingAPI.repository.NurseRepo;
import com.kloudvista.nursingAPI.repository.QualificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QualificationServiceImpl implements QualificationService{
    @Autowired
    private QualificationRepo repo;
    @Autowired
    private NurseRepo nurseRepo;

    @Override
    public NewNurseResp saveQualification(Qualification qualification) {
        Nurse nurseById = nurseRepo.getNurseById(qualification.getNurseId());

        if(nurseById == null){
            return new NewNurseResp("01","Nurse Id does not exist");}
        int save = repo.save(qualification);
        return new NewNurseResp("00", "Number of record saved: "+save);

    }

    @Override
    public Qualification getById(int id) {
        return repo.getById(id);
    }

    @Override
    public List<Qualification> getAllById(int nurseId){
        return repo.getAll(nurseId);
    }
}
