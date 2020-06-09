package com.techcards.TechCardsBackend.models.dao.flashcards;

import com.techcards.TechCardsBackend.models.dao.decks.Deck;

import java.util.UUID;

public class Flashcard {

    private UUID id;
    private String clue;
    private String answer;
    private Deck deck;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getClue() {
        return clue;
    }

    public void setClue(String clue) {
        this.clue = clue;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    @Override
    public String toString() {
        return "Flashcard clue: " + this.clue + ", answer: " + this.answer;
    }
}
