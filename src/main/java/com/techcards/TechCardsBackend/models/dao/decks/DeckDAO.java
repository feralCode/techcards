package com.techcards.TechCardsBackend.models.dao.decks;

import com.techcards.TechCardsBackend.models.dao.flashcards.Flashcard;
import com.techcards.TechCardsBackend.models.dao.flashcards.FlashcardDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.*;

@Component
public class DeckDAO {

    JdbcTemplate jdbcTemplate;
    FlashcardDAO flashcardDAO;

    public DeckDAO(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Deck getDeckById(UUID deckId) {
        Deck currentDeck = jdbcTemplate.queryForObject("select * from decks where deck_id = ?", new Object[] {deckId}, new DeckMapper());
        currentDeck.setFlashcards(flashcardDAO.getAllFlashcardsByDeckId(deckId));
        return currentDeck;
    }

    //TODO: get all decks liked by a user

    public List<Deck> getAllDecksByCreatorId(UUID creatorId) {
        List<Deck> decks = new ArrayList<>();

        String sql = "select * from decks where deck_subject_id = '" + creatorId + "'";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

        for (Map row : rows) {
            Deck deck = new Deck();
            deck.setId((UUID) row.get("deck_id"));
            deck.setName((String) row.get("deck_name"));
            deck.setCreatorId((UUID) row.get("deck_creator_id"));
            deck.setSubjectId((UUID) row.get("deck_subject_id"));
            deck.setFlashcards((List<Flashcard>) row.get("deck_flashcards"));
            deck.setLikes((Integer) row.get("deck_likes"));

            decks.add(deck);
        }
        return decks;
    }

    public List<Deck> getAllDecksBySubjectId(UUID subjectId) {
        List<Deck> decks = new ArrayList<>();

        String sql = "select * from decks where deck_subject_id = '" + subjectId + "'";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

        for (Map row : rows) {
            Deck deck = new Deck();
            deck.setId((UUID) row.get("deck_id"));
            deck.setName((String) row.get("deck_name"));
            deck.setCreatorId((UUID) row.get("deck_creator_id"));
            deck.setSubjectId((UUID) row.get("deck_subject_id"));
            deck.setFlashcards((List<Flashcard>) row.get("deck_flashcards"));
            deck.setLikes((Integer) row.get("deck_likes"));

            decks.add(deck);
        }
        return decks;
    }

    public List<Deck> getAllDecks() {
        List<Deck> decks = new ArrayList<>();

        List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from decks");

        for (Map row : rows) {
            Deck deck = new Deck();
            deck.setId((UUID) row.get("deck_id"));
            deck.setName((String) row.get("deck_name"));
            deck.setCreatorId((UUID) row.get("deck_creator_id"));
            deck.setSubjectId((UUID) row.get("deck_subject_id"));
            deck.setFlashcards((List<Flashcard>) row.get("deck_flashcards"));
            deck.setLikes((Integer) row.get("deck_likes"));

            decks.add(deck);
        }
        return decks;
    }

    public int createDeck(Deck deck) {

        UUID newDeckId = UUID.randomUUID();
        deck.setId(newDeckId);

        String sql = "insert into decks " +
                "(deck_id, deck_name, deck_creator_id, deck_subject_id, deck_flashcards, deck_likes) values " +
                "('" + deck.getId() +
                "','" + deck.getName() +
                "','" + deck.getCreatorId() +
                "','" + deck.getSubjectId() +
                "','" + deck.getFlashcards() +
                "'," + deck.getLikes() + ")";

        return jdbcTemplate.update(sql);
    }

    public int updateDeck(Deck deck) {
        String sql = "update decks set " +
                "deck_name = '" + deck.getName() +
                "', deck_creator_id = '" + deck.getCreatorId() +
                "', deck_subject_id = '" + deck.getSubjectId() +
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
