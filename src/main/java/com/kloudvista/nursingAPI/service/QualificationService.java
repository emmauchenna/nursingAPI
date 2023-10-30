package com.kloudvista.nursingAPI.service;

import com.kloudvista.nursingAPI.domain.Qualification;
import com.kloudvista.nursingAPI.dto.NewNurseResp;

import java.util.List;

public interface QualificationService {
   NewNurseResp saveQualification(Qualification qualification);
   Qualification getById(int id);
   List<Qualification> getAllById(int nurseId);
}
