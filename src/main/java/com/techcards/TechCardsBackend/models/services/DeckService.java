package com.techcards.TechCardsBackend.models.services;

import com.techcards.TechCardsBackend.models.dao.decks.Deck;
import com.techcards.TechCardsBackend.models.dao.decks.DeckDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DeckService {

    DeckDAO deckDAO;

    @Autowired
    public DeckService(DeckDAO deckDAO) {
        this.deckDAO = deckDAO;
    }

    public Deck getDeckById(UUID id) {
        Deck deck = deckDAO.getDeckById(id);

        return deck;
    }

    public List<Deck> getAllDecksBySubjectId(UUID subjectId) {
        List<Deck> allDecksBySubjectId = deckDAO.getAllDecksBySubjectId(subjectId);
        return allDecksBySubjectId;
    }

    public List<Deck> getAllDecks() {
        List<Deck> allDecks = deckDAO.getAllDecks();
        return allDecks;
    }

    public int createDeck(Deck deck) {
        return deckDAO.createDeck(deck);
    }

    public int updateDeck(Deck deck) {
        return deckDAO.updateDeck(deck);
    }

    public int deleteDeck(UUID deckId) {
        return deckDAO.deleteDeck(deckId);
    }
}
