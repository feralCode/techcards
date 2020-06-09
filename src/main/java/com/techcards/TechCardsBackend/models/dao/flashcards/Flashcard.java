package com.techcards.TechCardsBackend.models.dao.flashcards;

import java.util.UUID;

public class Flashcard {

    private UUID id;
    private String clue;
    private String answer;
    private UUID deckId;

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

    public UUID getDeckId() {
        return deckId;
    }

    public void setDeckId(UUID deckId) {
        this.deckId = deckId;
    }

    @Override
    public String toString() {
        return "Flashcard clue: " + this.clue + ", answer: " + this.answer;
    }
}
