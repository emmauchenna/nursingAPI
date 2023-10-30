package com.kloudvista.nursingAPI.repository;

import com.kloudvista.nursingAPI.domain.Nurse;
import java.util.List;

public interface NurseRepo {
    int saveNurse(Nurse nurse);
    List<Nurse> getNurses();
    Nurse getNurseById(long id);
    Nurse getNurseByIdAndFirstname(long id, String firstname);
    int updateNurse(Nurse nurse);
    int deleteNurse(int id);
    int findByEmail(String email);
}
