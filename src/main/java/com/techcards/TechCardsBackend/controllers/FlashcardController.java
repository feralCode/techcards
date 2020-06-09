package com.techcards.TechCardsBackend.controllers;

import com.techcards.TechCardsBackend.models.dao.flashcards.Flashcard;
import com.techcards.TechCardsBackend.models.services.FlashcardService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Flashcard> getAllFlashcards() {
        List<Flashcard> allFlashcards = flashcardService.getAllFlashcards();
        return allFlashcards;
    }

    @RequestMapping(value = "/newFlashcard", method = RequestMethod.POST)
    public String createFlashcard(@RequestBody Flashcard flashcard) {
        flashcardService.createFlashcard(flashcard);
        return "redirect:/all";
    }

    @RequestMapping(value="/editFlashcard/{flashcardId}")
    public String editFlashcard(@PathVariable("flashcardId") UUID flashcardId, Model m) {
        Flashcard flashcard = flashcardService.getFlashcardById(flashcardId);
        m.addAttribute("command", flashcard);
        return "editFlashcardForm";
    }

    @RequestMapping(value = "/editFlashcard", method = RequestMethod.PUT)
    public String updateFlashcard(@ModelAttribute("flashcard") Flashcard flashcard) {
        flashcardService.updateFlashcard(flashcard);
        return "redirect:/all";
    }

    @RequestMapping(value="/deleteFlashcard/{flashcardId}",method = RequestMethod.DELETE)
    public String deleteFlashcard(@PathVariable("flashcardId") UUID flashcardId) {
        flashcardService.deleteFlashcard(flashcardId);
        return "redirect:/all";
    }
}