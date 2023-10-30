package com.kloudvista.nursingAPI.service;

import com.kloudvista.nursingAPI.domain.NextOfKin;
import com.kloudvista.nursingAPI.dto.NewNextOfKin;
import com.kloudvista.nursingAPI.dto.NurseNextOfKin;
import org.springframework.stereotype.Service;

import java.util.List;


public interface NextOfKinService {
   int saveNextOfKin(NewNextOfKin nextOfKin);
   List<NextOfKin> getAllById(int nurseid);
   NextOfKin getById(int id);
   NurseNextOfKin getNurseAndNextOfKin(int nurseId);
   int updateNextOfKin(NewNextOfKin nextOfKin, int id);
}
