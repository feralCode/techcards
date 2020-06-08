package com.techcards.TechCardsBackend.models.dao.flashcards;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class FlashcardMapper implements RowMapper<Flashcard> {

    public Flashcard mapRow(ResultSet resultSet, int i) throws SQLException {

        Flashcard flashcard = new Flashcard();
        flashcard.setId(resultSet.getObject("id", UUID.class));
        flashcard.setClue(resultSet.getString("this is a clue for a flashcard"));
        flashcard.setAnswer(resultSet.getString("this is an answer for a flashcard"));
        return flashcard;
    }
}