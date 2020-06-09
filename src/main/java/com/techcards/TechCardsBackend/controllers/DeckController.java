package com.techcards.TechCardsBackend.controllers;

import com.techcards.TechCardsBackend.models.dao.decks.Deck;
import com.techcards.TechCardsBackend.models.services.DeckService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/deck")
public class DeckController {

    private final DeckService deckService;

    public DeckController(DeckService deckService) {
        this.deckService = deckService;
    }

    @RequestMapping(value = "/{deckId}", method = RequestMethod.GET)
    public Deck getDeck(@PathVariable("deckId") UUID deckId) {

        Deck deck = deckService.getDeckById(deckId);

        return deck;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Deck> getAllDecks() {
        List<Deck> allDecks = deckService.getAllDecks();
        return allDecks;
    }

    @RequestMapping(value = "/newDeck", method = RequestMethod.POST)
    public String createDeck(@ModelAttribute("deck") Deck deck) {
        deckService.createDeck(deck);
        return "redirect:/all";
    }

    @RequestMapping(value="/editDeck/{deckId}")
    public String editDeck(@PathVariable("deckId") UUID deckId, Model m) {
        Deck deck = deckService.getDeckById(deckId);
        m.addAttribute("command", deck);
        return "editDeckForm";
    }

    @RequestMapping(value = "/editDeck", method = RequestMethod.PUT)
    public String updateDeck(@ModelAttribute("deck") Deck deck) {
        deckService.updateDeck(deck);
        return "redirect:/all";
    }

    @RequestMapping(value="/deleteDeck/{deckId}",method = RequestMethod.DELETE)
    public String deleteDeck(@PathVariable("deckId") UUID deckId) {
        deckService.deleteDeck(deckId);
        return "redirect:/all";
    }
}
