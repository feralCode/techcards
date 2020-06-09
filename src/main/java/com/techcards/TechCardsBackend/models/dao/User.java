package com.techcards.TechCardsBackend.models.dao;

import com.techcards.TechCardsBackend.models.dao.decks.Deck;

import java.util.Set;
import java.util.UUID;

public class User {

    private UUID id;
    private String name;
    private String about;
    private Set<Deck> createdDecks;
    private Set<Deck> likedDecks;

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

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Set<Deck> getCreatedDecks() {
        return createdDecks;
    }

    public void setCreatedDecks(Set<Deck> createdDecks) {
        this.createdDecks = createdDecks;
    }

    public Set<Deck> getLikedDecks() {
        return likedDecks;
    }

    public void setLikedDecks(Set<Deck> likedDecks) {
        this.likedDecks = likedDecks;
    }
}
