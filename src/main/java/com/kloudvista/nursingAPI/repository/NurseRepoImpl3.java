package com.kloudvista.nursingAPI.repository;

import com.kloudvista.nursingAPI.domain.Nurse;

import java.util.List;

public class NurseRepoImpl3 implements NurseRepo{
    @Override
    public int saveNurse(Nurse nurse) {
        return 0;
    }

    @Override
    public List<Nurse> getNurses() {
        return null;
    }

    @Override
    public Nurse getNurseById(long id) {
        return null;
    }

    @Override
    public Nurse getNurseByIdAndFirstname(long id, String firstname) {
        return null;
    }

    @Override
    public int updateNurse(Nurse nurse) {
        return 0;
    }

    @Override
    public int deleteNurse(int id) {
        return 0;
    }

    @Override
    public int findByEmail(String email) {
        return 0;
    }
}
