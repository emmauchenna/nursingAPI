package com.kloudvista.nursingAPI.repository;

import com.kloudvista.nursingAPI.domain.Nurse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NurseRepoImpl implements NurseRepo{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int saveNurse(Nurse nurse) {
        String query = "Insert into Nurse (firstname, lastname, address, status, email, phonenumber, datecreated ) " +
                "values (?, ?, ?, ?, ?, ?, ?)";

        int noOfRecordsInserted = jdbcTemplate.update(query, new Object[]{nurse.getFirstName(),
                nurse.getLastName(), nurse.getAddress(), nurse.isStatus(),
                nurse.getEmail(), nurse.getPhoneNumber(), nurse.getDateCreated()});

        return noOfRecordsInserted;
    }

    @Override
    public List<Nurse> getNurses() {
        String query = "Select id, firstname, lastname, address, status, email, phonenumber, datecreated " +
                "from Nurse";

        //CRUD - Create, Retrieve, Update and delete
        //query - Retrieve
        //Update - Create, Update and delete

     return   jdbcTemplate.query(query, new NurseMapper());
    }


    @Override
    public Nurse getNurseById(long id) {
        String query = "Select id, firstname, lastname, address, status, email, phonenumber, datecreated " +
                "from Nurse where id = ?";

        return   jdbcTemplate.queryForObject(query, new Object[]{id}, new NurseMapper());
    }

    @Override
    public Nurse getNurseByIdAndFirstname(long id, String firstname) {
        String query = "Select id, firstname, lastname, address, status, email, phonenumber, datecreated " +
                "from Nurse where id = ? and firstname = ?";
        return   jdbcTemplate.queryForObject(query, new Object[]{id, firstname}, new NurseMapper());
    }

    @Override
    public int updateNurse(Nurse nurse) {
        String query = "Update Nurse set firstname = ?, lastname = ? where id = ?";
        int update = jdbcTemplate.update(query, new Object[]{nurse.getFirstName(), nurse.getLastName(), nurse.getId()});
        return update;
    }

    @Override
    public int deleteNurse(int id) {
        String query = "Delete from Nurse where id = ?";
        int update = jdbcTemplate.update(query, new Object[]{id});
        return update;
    }

    @Override
    public int findByEmail(String email) {
        String sql = "select count(*) from nurse where email = ?";
      return jdbcTemplate.queryForObject(sql, new Object[]{email}, Integer.class);
    }


}
