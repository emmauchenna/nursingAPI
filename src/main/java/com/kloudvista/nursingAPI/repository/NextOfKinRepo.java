package com.kloudvista.nursingAPI.repository;

import com.kloudvista.nursingAPI.domain.NextOfKin;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NextOfKinRepo {

    int save(NextOfKin nextOfKin);
    public NextOfKin getById(int id) ;
    public List<NextOfKin> getAll(int nurseId);
    public int updateNextOfkin(NextOfKin nextOfKin);
    public int delete(long id);

}
