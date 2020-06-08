package com.techcards.TechCardsBackend.models.dao.flashcards;

import com.techcards.TechCardsBackend.models.dao.decks.Deck;

import java.util.UUID;
import javax.persistence.*;

@Entity
@Table(name = "flashcards")
public class Flashcard {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "flashcard_clue")
    private String clue;

    @Column(name = "flashcard_answer")
    private String answer;

    @ManyToOne
    @JoinColumn(name = "deck_id")
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
}
