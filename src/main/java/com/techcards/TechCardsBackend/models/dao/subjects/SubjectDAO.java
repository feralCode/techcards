package com.techcards.TechCardsBackend.models.dao.subjects;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.UUID;

@Component
public class SubjectDAO {

    JdbcTemplate jdbcTemplate;


    public SubjectDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Subject getSubjectById(UUID id) {
        return jdbcTemplate.queryForObject("select * from subjects where id = ?", new Object[] { id }, new SubjectMapper());
    }

}
