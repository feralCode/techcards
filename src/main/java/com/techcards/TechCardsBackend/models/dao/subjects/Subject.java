package com.techcards.TechCardsBackend.models.dao.subjects;

import com.techcards.TechCardsBackend.models.dao.decks.Deck;

import java.util.Set;
import java.util.UUID;

public class Subject {

    private UUID id;
    private String name;
    private String imageUrl;
    private Set<Deck> deckList;

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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Set<Deck> getDeckList() {
        return deckList;
    }

    public void setDeckList(Set<Deck> deckList) {
        this.deckList = deckList;
    }

    @Override
    public String toString() {
        return "Subject name: " + this.name + ", Decks: " +this.deckList;
    }
}
