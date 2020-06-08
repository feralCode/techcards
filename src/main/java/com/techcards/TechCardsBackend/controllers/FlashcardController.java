package com.techcards.TechCardsBackend.controllers;

import com.techcards.TechCardsBackend.models.dao.flashcards.Flashcard;
import com.techcards.TechCardsBackend.models.services.FlashcardService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/flashcards")
public class FlashcardController {

    private final FlashcardService flashcardService;

    public FlashcardController(FlashcardService flashcardService) {
        this.flashcardService = flashcardService;
    }

    @RequestMapping(value = "/{flashcardId}", method = RequestMethod.GET)
    public Flashcard getFlashcard(@PathVariable("flashcardId") UUID flashcardId) {

        Flashcard flashcard = flashcardService.getFlashcardById(flashcardId);

        return flashcard;
    }
}