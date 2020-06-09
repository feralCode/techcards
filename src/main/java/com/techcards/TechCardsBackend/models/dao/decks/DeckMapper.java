package com.techcards.TechCardsBackend.models.dao.decks;

import com.techcards.TechCardsBackend.models.dao.flashcards.Flashcard;

import com.techcards.TechCardsBackend.models.dao.users.User;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class DeckMapper implements RowMapper<Deck> {

    public Deck mapRow(ResultSet resultSet, int i) throws SQLException {

        Deck deck = new Deck();
        deck.setId(resultSet.getObject("deck_id", UUID.class));
        deck.setCreator((User) resultSet.getObject("deck_creator"));
        deck.setSubjectId((UUID) resultSet.getObject("deck_subject_id"));
        deck.setFlashcards((List<Flashcard>) resultSet.getObject("deck_flashcards"));
        deck.setLikes(resultSet.getInt("deck_likes"));

        return deck;
    }
}
