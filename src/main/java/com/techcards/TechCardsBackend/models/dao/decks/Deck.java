package com.techcards.TechCardsBackend.models.dao.decks;

import com.techcards.TechCardsBackend.models.dao.flashcards.Flashcard;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "decks")
public class Deck {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "deck_name")
    private String name;

    @Column(name = "deck_creator")
    private String creator;

    @Column(name = "deck_subject")
    private String subject;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "flashcards")
    private Set<Flashcard> flashcards;

    @Column(name = "deck_likes")
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
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
}
