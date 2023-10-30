package com.kloudvista.nursingAPI.repository;

import com.kloudvista.nursingAPI.domain.Qualification;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
public interface QualificationRepo{
        public int save(Qualification qualification) ;
        public Qualification getById(int id) ;
        public List<Qualification> getAll(int nursId);
        public int updateQualification(Qualification qualification);
        public int delete(int nurseId, long id);

}
