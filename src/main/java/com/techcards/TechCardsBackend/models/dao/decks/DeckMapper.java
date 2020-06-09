package com.techcards.TechCardsBackend.models.dao.decks;

import com.techcards.TechCardsBackend.models.dao.flashcards.Flashcard;

import com.techcards.TechCardsBackend.models.dao.subjects.Subject;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import java.util.UUID;

public class DeckMapper implements RowMapper<Deck> {

    public Deck mapRow(ResultSet resultSet, int i) throws SQLException {

        Deck deck = new Deck();
        deck.setId(resultSet.getObject("deck_id", UUID.class));
        deck.setCreator(resultSet.getString("deck_creator"));
        deck.setSubject((Subject) resultSet.getObject("deck_subject"));
        deck.setFlashcards((Set<Flashcard>) resultSet.getObject("deck_flashcards"));
        deck.setLikes(resultSet.getInt("deck_likes"));

        return deck;
    }
}
