package com.techcards.TechCardsBackend.models.dao.flashcards;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class FlashcardMapper implements RowMapper<Flashcard> {

    public Flashcard mapRow(ResultSet resultSet, int i) throws SQLException {

        Flashcard flashcard = new Flashcard();
        flashcard.setId(resultSet.getObject("flashcard_id", UUID.class));
        flashcard.setClue(resultSet.getString("flashcard_clue"));
        flashcard.setAnswer(resultSet.getString("flashcard_answer"));
        flashcard.setDeckId((UUID) resultSet.getObject("flashcard_deck_id"));
        return flashcard;
    }
}