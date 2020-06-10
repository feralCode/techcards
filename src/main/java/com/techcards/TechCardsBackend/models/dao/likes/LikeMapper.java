package com.techcards.TechCardsBackend.models.dao.likes;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class LikeMapper implements RowMapper<Like> {

    public Like mapRow(ResultSet resultSet, int i) throws SQLException {

        Like like = new Like();
        like.setLikeId((UUID) resultSet.getObject("like_id", UUID.class));
        like.setUserId((UUID) resultSet.getObject("like_user_id"));
        like.setDeckId((UUID) resultSet.getObject("like_deck_id"));

        return like;
    }
}
