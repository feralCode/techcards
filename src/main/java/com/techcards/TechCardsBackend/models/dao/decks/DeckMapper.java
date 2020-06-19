package com.techcards.TechCardsBackend.models.dao.decks;

import com.techcards.TechCardsBackend.models.dao.flashcards.Flashcard;

import com.techcards.TechCardsBackend.models.dao.likes.Like;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class DeckMapper implements RowMapper<Deck> {

    public Deck mapRow(ResultSet resultSet, int i) throws SQLException {

        Deck deck = new Deck();
        deck.setId(resultSet.getObject("deck_id", UUID.class));
        deck.setName(resultSet.getString("deck_name"));
        deck.setCreatorId((UUID) resultSet.getObject("deck_creator_id"));
        deck.setSubjectId((UUID) resultSet.getObject("deck_subject_id"));

        return deck;
    }
}
