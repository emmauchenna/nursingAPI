package com.kloudvista.nursingAPI.repository;

import com.kloudvista.nursingAPI.domain.Nurse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import java.util.ArrayList;
import java.util.List;

public class NurseRepo2Impl implements NurseRepo{
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public int saveNurse(Nurse nurse) {
        String query = "Insert into Nurse (firstname, lastname, address, status, email, phonenumber, datecreated ) " +
                "values (:firstname, :lastname, :address, :status, :email, : phonenumber, :datecreated)";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("firstname", nurse.getFirstName())
                .addValue("lastname", nurse.getLastName())
                .addValue("address", nurse.getAddress())
                .addValue("status", nurse.getAddress())
                .addValue("email", nurse.getEmail())
                .addValue("phonenumber", nurse.getPhoneNumber())
                .addValue("datecreated", nurse.getDateCreated());


        int update = namedParameterJdbcTemplate.update(query, parameterSource);
        return update;
    }

    @Override
    public List<Nurse> getNurses() {
        String query = "Select id, firstname, lastname, address, status, email, phonenumber, datecreated from Nurse";
        List<Nurse> NurseList = new ArrayList<>();
        return namedParameterJdbcTemplate.query(query, new NurseMapper());
    }

    @Override
    public Nurse getNurseById(long id) {
        String query = "Select * from Nurse where id = :id)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);

        return namedParameterJdbcTemplate.queryForObject(query, parameterSource, new NurseMapper());
    }

    @Override
    public Nurse getNurseByIdAndFirstname(long id, String firstname) {
        String query = "Select * from Nurse where id = :id and firstname = :firstname)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        parameterSource.addValue("firstname", firstname);
        return namedParameterJdbcTemplate.queryForObject(query, parameterSource, new NurseMapper());
    }

    @Override
    public int updateNurse(Nurse nurse) {
        String query = "update nurse set firstname = :firstname, lastname = :lastname where id = : id";
        MapSqlParameterSource mapSqlP = new MapSqlParameterSource();
        mapSqlP.addValue("firstname",nurse.getFirstName())
                .addValue("lastname", nurse.getLastName())
                .addValue("id",nurse.getId());
        return namedParameterJdbcTemplate.update(query,mapSqlP);
    }

    @Override
    public int deleteNurse(int id) {
        String query = "Delete from nurse where id = : id";
        MapSqlParameterSource mapSqlP = new MapSqlParameterSource();
        mapSqlP.addValue("id",id);

        return namedParameterJdbcTemplate.update(query,mapSqlP);
    }

    @Override
    public int findByEmail(String email) {
        return 0;
    }
}
