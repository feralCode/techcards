package com.techcards.TechCardsBackend.controllers;

import com.techcards.TechCardsBackend.models.dao.likes.Like;
import com.techcards.TechCardsBackend.models.services.LikeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/like")
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @RequestMapping(value = "/{likeId}", method = RequestMethod.GET)
    public Like getLike(@PathVariable("likeId") UUID likeId) {
        Like like = likeService.getLikeById(likeId);
        return like;
    }

    @RequestMapping(value = "/userLikes/{userId}", method = RequestMethod.GET)
    public List<Like> getAllLikesByUserId(@PathVariable("userId") UUID userId) {
        List<Like> allLikesByUserId = likeService.getAllLikesByUserId(userId);
        return allLikesByUserId;
    }

    @RequestMapping(value = "/deckLikes/{deckId}", method = RequestMethod.GET)
    public List<Like> getAllLikesByDeckId(@PathVariable("deckId") UUID deckId) {
        List<Like> allLikesByDeckId = likeService.getAllLikesByDeckId(deckId);
        return allLikesByDeckId;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Like> getAllLikes() {
        List<Like> allLikes = likeService.getAllLikes();
        return allLikes;
    }

    @RequestMapping(value = "/newLike", method = RequestMethod.POST)
    public String createLike(@RequestBody Like like) {
        likeService.createLike(like);
        return "redirect:/all";
    }

    @RequestMapping(value="/editLike/{likeId}")
    public Like editLike(@PathVariable("likeId") UUID likeId, @RequestBody Like like) {
        likeService.getLikeById(likeId);
        return like;
    }

    @RequestMapping(value = "/editLike", method = RequestMethod.PUT)
    public String updateLike(@RequestBody Like like) {
        likeService.updateLike(like);
        return "redirect:/all";
    }

    @RequestMapping(value="/deleteLike/{likeId}",method = RequestMethod.DELETE)
    public String deleteLike(@PathVariable("likeId") UUID likeId) {
        likeService.deleteLike(likeId);
        return "redirect:/all";
    }
}