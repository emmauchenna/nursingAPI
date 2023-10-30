package com.kloudvista.nursingAPI.repository;

import com.kloudvista.nursingAPI.domain.Qualification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class QualificationRepoImpl implements QualificationRepo{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Qualification qua) {
        String sql = "Insert into Qualification (name, startdate, enddate, nurseid) values (?,?,?,?) ";
        return jdbcTemplate.update(sql, new Object[]{qua.getName(), qua.getStartDate(), qua.getEndDate(), qua.getNurseId()});
    }

    @Override
    public Qualification getById(int id) {
        String sql = "select id, name, startdate, enddate, nurseid from Qualification where id = ? ";
    return     jdbcTemplate.queryForObject(sql, new Object[]{id}, new QualificationMapper());
    }

    @Override
    public List<Qualification> getAll(int nursId) {
        String query = "Select id, name, startDate, endDate, nurseId from qualification where nurseId = ? " ;
        return   jdbcTemplate.query(query, new Object[]{nursId}, new QualificationMapper());
    }

    @Override
    public int updateQualification(Qualification qualification) {
        String query ="Update qualification set name = ?, startDate = ? , endDate = ? where id ? ";
        return jdbcTemplate.update(query,qualification);
    }

    @Override
    public int delete(int nurseId, long id) {

        String query ="Delete from qualification  where id ? ";
        return jdbcTemplate.update(query, new Object[]{id});
    }

    class QualificationMapper implements RowMapper<Qualification>{
        @Override
        public Qualification mapRow(ResultSet rs, int rowNum) throws SQLException {
            Qualification qualification = new Qualification();
            qualification.setId(rs.getInt("id"));
            qualification.setName(rs.getString("name"));
            qualification.setStartDate(rs.getDate("startDate").toLocalDate());
            qualification.setEndDate(rs.getDate("endDate").toLocalDate());
            qualification.setNurseId(rs.getInt("nurseId"));
            return qualification;
        }
    }
}
