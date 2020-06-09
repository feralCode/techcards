package com.techcards.TechCardsBackend.models.dao.decks;

import com.techcards.TechCardsBackend.models.dao.flashcards.Flashcard;
import com.techcards.TechCardsBackend.models.dao.subjects.Subject;
import com.techcards.TechCardsBackend.models.dao.users.User;

import java.util.Set;
import java.util.UUID;


public class Deck {


    private UUID id;
    private String name;
    private User creator;
    private Subject subject;
    private Set<Flashcard> flashcards;
    private int likes;

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

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Set<Flashcard> getFlashcards() {
        return flashcards;
    }

    public void setFlashcards(Set<Flashcard> flashcards) {
        this.flashcards = flashcards;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int liked) {
        this.likes = liked;
    }

    @Override
    public String toString() {
        return "Deck " + this.name;
    }
}
