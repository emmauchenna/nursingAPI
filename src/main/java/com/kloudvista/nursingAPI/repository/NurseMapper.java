package com.kloudvista.nursingAPI.repository;

import com.kloudvista.nursingAPI.domain.Nurse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NurseMapper implements RowMapper<Nurse> {

    public Nurse mapRow(ResultSet rs, int rowNum) throws SQLException {
        Nurse nurse = new Nurse();
        nurse.setStatus(rs.getBoolean("Status"));
        nurse.setDateCreated(rs.getTimestamp("datecreated").toLocalDateTime());
        nurse.setEmail(rs.getString("Email"));
        nurse.setPhoneNumber(rs.getString("Phonenumber"));
        nurse.setFirstName(rs.getString("firstname"));
        nurse.setLastName(rs.getString("lastname"));
        nurse.setId(rs.getInt("id"));
        return nurse;
    }
}