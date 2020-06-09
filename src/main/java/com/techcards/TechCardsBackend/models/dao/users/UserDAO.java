package com.techcards.TechCardsBackend.models.dao.users;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.UUID;

@Component
public class UserDAO {
    JdbcTemplate jdbcTemplate;

    public UserDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public User getUserById(UUID userId) {
        return jdbcTemplate.queryForObject("select * from users where id = ?", new Object[] {userId}, new UserMapper());
    }
}
