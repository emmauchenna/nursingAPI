package com.kloudvista.nursingAPI.service;

import com.kloudvista.nursingAPI.domain.Nurse;
import com.kloudvista.nursingAPI.dto.NewNurseResp;
import com.kloudvista.nursingAPI.dto.NurseReq;
import com.kloudvista.nursingAPI.dto.NurseResp;

import java.util.List;

public interface NurseService {
    NewNurseResp createNurse(NurseReq nurseDto);
    List<NurseResp> getNurses();
    NurseResp getNurseById(int id);
    NurseResp getNurseByIdAndFirstname(int id , String firstname);
    int updateNurse(NurseReq nurse, int id);
    int deleteNurse(int id);
    boolean validateEmail(String email);
}
