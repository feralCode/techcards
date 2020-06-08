package com.techcards.TechCardsBackend.models.dao.decks;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.UUID;

@Component
public class DeckDAO {

    JdbcTemplate jdbcTemplate;

    public DeckDAO(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Deck getDeckById(UUID id) {
        return jdbcTemplate.queryForObject("select * from decks where id = ?", new Object[] {id}, new DeckMapper());
    }
}
