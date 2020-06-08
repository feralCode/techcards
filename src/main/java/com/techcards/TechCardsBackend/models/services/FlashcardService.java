package com.techcards.TechCardsBackend.models.services;

import com.techcards.TechCardsBackend.models.dao.flashcards.Flashcard;
import com.techcards.TechCardsBackend.models.dao.flashcards.FlashcardDAO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FlashcardService {

    FlashcardDAO flashcardDAO;

    public FlashcardService(FlashcardDAO flashcardDAO) {
        this.flashcardDAO = flashcardDAO;
    }

    public Flashcard getFlashcardById(UUID id) {
        Flashcard flashcard = new Flashcard();

        flashcard.setId(id);
        flashcard.setClue("This is a CLUE");
        flashcard.setAnswer("This is an ANSWER");

        System.out.println(flashcard.getId());

        return flashcard;
    }
}
