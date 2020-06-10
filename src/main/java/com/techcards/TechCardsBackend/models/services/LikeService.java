package com.techcards.TechCardsBackend.models.services;

import com.techcards.TechCardsBackend.models.dao.likes.Like;
import com.techcards.TechCardsBackend.models.dao.likes.LikeDAO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LikeService {

    LikeDAO likeDAO;

    public LikeService(LikeDAO likeDAO) {
        this.likeDAO = likeDAO;
    }

    public Like getLikeById(UUID id) {
        Like like = likeDAO.getLikeById(id);

        return like;
    }

    public List<Like> getAllLikesByUserId(UUID userId) {
        List<Like> allLikesByUserId = likeDAO.getAllLikesByUserId(userId);
        return allLikesByUserId;
    }

    public List<Like> getAllLikesByDeckId(UUID deckId) {
        List<Like> allLikesByDeckId = likeDAO.getAllLikesByUserId(deckId);
        return allLikesByDeckId;
    }

    public List<Like> getAllLikes() {
        List<Like> allLikes = likeDAO.getAllLikes();
        return allLikes;
    }

    public int createLike(Like like) {
        return likeDAO.createLike(like);
    }

    public int updateLike(Like like) {
        return likeDAO.updateLike(like);
    }

    public int deleteLike(UUID likeId) {
        return likeDAO.deleteLike(likeId);
    }
}
