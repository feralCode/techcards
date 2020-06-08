package com.techcards.TechCardsBackend.models.dao.flashcards;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.UUID;

@Component
public class FlashcardDAO {

    JdbcTemplate jdbcTemplate;

    public FlashcardDAO(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Flashcard getFlashcardById(UUID id) {
        return jdbcTemplate.queryForObject("select * from flashcards where id = ?", new Object[] {id}, new FlashcardMapper());
    }
}
