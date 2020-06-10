package com.techcards.TechCardsBackend.models.dao.likes;

import java.util.UUID;

public class Like {

    private UUID likeId;
    private UUID userId;
    private UUID deckId;

    public UUID getLikeId() {
        return likeId;
    }

    public void setLikeId(UUID likeId) {
        this.likeId = likeId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getDeckId() {
        return deckId;
    }

    public void setDeckId(UUID deckId) {
        this.deckId = deckId;
    }
}
