package com.kloudvista.nursingAPI.repository;

import com.kloudvista.nursingAPI.domain.NextOfKin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class NextOfKinRepoImpl implements NextOfKinRepo{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int save(NextOfKin nextOfKin) {
        String sql= "insert into NextOfkin (fullname, address, phonenumber, email, nurseId) values (?,?,?,?, ?)";
       return jdbcTemplate.update(sql, new Object[]{ nextOfKin.getFullname(), nextOfKin.getAddress(), nextOfKin.getPhoneNumber(), nextOfKin.getEmail(), nextOfKin.getNurseId()});
    }

    @Override
    public NextOfKin getById(int id) {
        String query = "Select * from nextofkin where id = ?";
        return  jdbcTemplate.queryForObject(query, new Object[]{id}, new NextOfKinMapper());
    }

    @Override
    public List<NextOfKin> getAll(int nurseId) {
        String query = "Select * from nextofkin where nurseid = ?";
        return  jdbcTemplate.query(query, new NextOfKinMapper());

    }

    @Override
    public int updateNextOfkin(NextOfKin kin) {
        String query = "Update NextOfKin set fullname = ?, email = ?, phonenumber = ?, address = ? where id = ?";
        int i = jdbcTemplate.update(query, new Object[] {kin.getFullname(), kin.getEmail(), kin.getPhoneNumber(), kin.getAddress(), kin.getId()});
        return i;
    }

    @Override
    public int delete(long id) {
        String query = "Delete from NextOfKin where id = ? and ";
        int i = jdbcTemplate.update(query, new Object[]{id});
        return i;
    }

    class NextOfKinMapper implements RowMapper<NextOfKin>{

        @Override
        public NextOfKin mapRow(ResultSet rs, int rowNum) throws SQLException {
            NextOfKin nextOfKin = new NextOfKin();
            nextOfKin.setAddress(rs.getString("Address"));
            nextOfKin.setEmail(rs.getString("email"));
            nextOfKin.setPhoneNumber(rs.getString("phonenumber"));
            nextOfKin.setFullname(rs.getString("fullname"));
            nextOfKin.setNurseId(rs.getInt("nurseid"));
            nextOfKin.setId(rs.getInt("id"));
            return nextOfKin;
        }
    }
}
