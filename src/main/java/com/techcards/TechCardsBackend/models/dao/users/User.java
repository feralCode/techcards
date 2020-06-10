package com.techcards.TechCardsBackend.models.dao.users;

import com.techcards.TechCardsBackend.models.dao.decks.Deck;
import com.techcards.TechCardsBackend.models.dao.likes.Like;

import java.util.List;
import java.util.UUID;

public class User {

    private UUID id;
    private String name;
    private String about;
    private List<Deck> createdDecks;
    private List<Like> likedDecks;

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

    public List<Deck> getCreatedDecks() {
        return createdDecks;
    }

    public void setCreatedDecks(List<Deck> createdDecks) {
        this.createdDecks = createdDecks;
    }

    public List<Like> getLikedDecks() {
        return likedDecks;
    }

    public void setLikedDecks(List<Like> likedDecks) {
        this.likedDecks = likedDecks;
    }

    @Override
    public String toString() {
        return "User " + this.name;
    }
}
