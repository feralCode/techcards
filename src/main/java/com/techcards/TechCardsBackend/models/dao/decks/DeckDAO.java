package com.techcards.TechCardsBackend.models.dao.decks;

import com.techcards.TechCardsBackend.models.dao.flashcards.Flashcard;
import com.techcards.TechCardsBackend.models.dao.subjects.Subject;
import com.techcards.TechCardsBackend.models.dao.users.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.*;

@Component
public class DeckDAO {

    JdbcTemplate jdbcTemplate;

    public DeckDAO(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Deck getDeckById(UUID id) {
        return jdbcTemplate.queryForObject("select * from decks where id = ?", new Object[] {id}, new DeckMapper());
    }

    public List<Deck> getAllDecks() {
        List<Deck> decks = new ArrayList<>();

        List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from decks");

        for (Map row : rows) {
            Deck deck = new Deck();
            deck.setId((UUID) row.get("deck_id"));
            deck.setName((String) row.get("deck_name"));
            deck.setCreator((User) row.get("deck_creator"));
            deck.setSubject((Subject) row.get("deck_subject"));
            deck.setFlashcards((Set<Flashcard>) row.get("deck_flashcards"));
            deck.setLikes((Integer) row.get("deck_likes"));

            decks.add(deck);
        }
        return decks;
    }

    public int createDeck(Deck deck) {

        UUID newDeckId = UUID.randomUUID();
        deck.setId(newDeckId);

        String sql = "insert into decks " +
                "(deck_id, deck_name, deck_creator, deck_subject, deck_flashcards, deck_likes) values " +
                "('" + deck.getId() +
                "','" + deck.getName() +
                "','" + deck.getCreator() +
                "','" + deck.getSubject() +
                "','" + deck.getFlashcards() +
                "'," + deck.getLikes() + ")";

        return jdbcTemplate.update(sql);
    }

    public int updateDeck(Deck deck) {
        String sql = "update decks set " +
                "deck_name = '" + deck.getName() +
                "', deck_creator = '" + deck.getCreator() +
                "', deck_subject = '" + deck.getSubject() +
                "', deck_flashcards = '" + deck.getFlashcards() +
                "', deck_likes = " + deck.getLikes() +
                " where deck_id = " + deck.getId() + "";

        return jdbcTemplate.update(sql);
    }

    public int deleteDeck(UUID deckId) {
        String sql = "delete from decks where id = '" + deckId + "'";
        return jdbcTemplate.update(sql);
    }


}
