package com.techcards.TechCardsBackend.models.dao.subjects;

import com.techcards.TechCardsBackend.models.dao.decks.Deck;

import java.util.List;
import java.util.UUID;

public class Subject {

    private UUID id;
    private String name;
    private List<Deck> deckList;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Deck> getDeckList() {
        return deckList;
    }

    public void setDeckList(List<Deck> deckList) {
        this.deckList = deckList;
    }
}
