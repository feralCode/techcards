package com.techcards.TechCardsBackend.models.dao.decks;

import com.techcards.TechCardsBackend.models.dao.flashcards.Flashcard;
import com.techcards.TechCardsBackend.models.dao.likes.Like;

import java.util.List;
import java.util.UUID;


public class Deck {

    private UUID id;
    private String name;
    private UUID creatorId;
    private UUID subjectId;
    private List<Flashcard> flashcards;
    private List<Like> likes;

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

    public UUID getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(UUID creatorId) {
        this.creatorId = creatorId;
    }

    public UUID getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(UUID subjectId) {
        this.subjectId = subjectId;
    }

    public List<Flashcard> getFlashcards() {
        return flashcards;
    }

    public void setFlashcards(List<Flashcard> flashcards) {
        this.flashcards = flashcards;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "Deck " + this.name;
    }
}
