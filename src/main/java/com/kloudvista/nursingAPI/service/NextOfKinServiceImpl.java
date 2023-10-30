package com.kloudvista.nursingAPI.service;

import com.kloudvista.nursingAPI.domain.NextOfKin;
import com.kloudvista.nursingAPI.domain.Nurse;
import com.kloudvista.nursingAPI.dto.NewNextOfKin;
import com.kloudvista.nursingAPI.dto.NurseNextOfKin;
import com.kloudvista.nursingAPI.repository.NextOfKinRepo;
import com.kloudvista.nursingAPI.repository.NurseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NextOfKinServiceImpl implements NextOfKinService{
    @Autowired
    private NextOfKinRepo nextOfKinRepo;
    @Autowired
    private NurseRepo nurseRepo;

    @Override
    public int saveNextOfKin(NewNextOfKin nextOfKin) {

        Nurse nurseById = nurseRepo.getNurseById(nextOfKin.getNurseId());
        if(nurseById == null){
            return 0;
        }
        //
        NextOfKin nextOfKin1 = new NextOfKin();
        nextOfKin1.setNurseId(nextOfKin.getNurseId());
        nextOfKin1.setFullname(nextOfKin.getFullname());
        nextOfKin1.setEmail(nextOfKin.getEmail());
        nextOfKin1.setPhoneNumber(nextOfKin1.getPhoneNumber());
        nextOfKin1.setAddress(nextOfKin1.getPhoneNumber());
       return nextOfKinRepo.save(nextOfKin1);
    }

    @Override
    public NextOfKin getById(int id){
        return nextOfKinRepo.getById(id);
    }
    @Override
    public List<NextOfKin> getAllById(int nurseid) {
        return nextOfKinRepo.getAll(nurseid);
    }

    @Override
    public NurseNextOfKin getNurseAndNextOfKin(int nurseId) {
        Nurse nurse = nurseRepo.getNurseById(nurseId);
        if(nurse == null) return null;
        NurseNextOfKin resp = new NurseNextOfKin();
        List<NextOfKin> nextofkinList = nextOfKinRepo.getAll(nurseId);
        resp.setFirstName(nurse.getFirstName());
        resp.setLastName(nurse.getLastName());
        resp.setAddress(nurse.getAddress());
        resp.setId(nurse.getId());
        resp.setPhoneNumber(nurse.getPhoneNumber());
        resp.setNextOfKinList(nextofkinList);
        return resp;
    }

    @Override
    public int updateNextOfKin(NewNextOfKin nextOfKin, int id) {
        NextOfKin nextOfKin1 = new NextOfKin();
        nextOfKin1.setId(id);
        nextOfKin1.setNurseId(nextOfKin.getNurseId());
        nextOfKin1.setFullname(nextOfKin.getFullname());
        nextOfKin1.setEmail(nextOfKin.getEmail());
        nextOfKin1.setPhoneNumber(nextOfKin.getPhoneNumber());
        nextOfKin1.setAddress(nextOfKin.getAddress());
        return nextOfKinRepo.updateNextOfkin(nextOfKin1);

    }
}
