package com.techcards.TechCardsBackend.models.services;

import com.techcards.TechCardsBackend.models.dao.decks.Deck;
import com.techcards.TechCardsBackend.models.dao.decks.DeckDAO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DeckService {

    DeckDAO deckDAO;

    public DeckService(DeckDAO deckDAO) {
        this.deckDAO = deckDAO;
    }

    public Deck getDeckById(UUID id) {
        Deck deck = deckDAO.getDeckById(id);

//        Deck deck = new Deck();
//
//        deck.setId(id);
//        deck.setName("Deck Name");
//        deck.setSubject("Java Spring");
//        deck.setCreator("Will Rowston");
//        deck.setLikes(15);

        return deck;
    }

    public List<Deck> getAllDecks() {
        List<Deck> allDecks = deckDAO.getAllDecks();
        return allDecks;
    }
}
