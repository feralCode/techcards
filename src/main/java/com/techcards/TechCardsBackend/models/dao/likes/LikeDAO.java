package com.techcards.TechCardsBackend.models.dao.likes;

import com.techcards.TechCardsBackend.models.dao.decks.Deck;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class LikeDAO {

    JdbcTemplate jdbcTemplate;

    public LikeDAO(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Like getLikeById(UUID likeId) {
        return jdbcTemplate.queryForObject("select * from likes where like_id = ?", new Object[] {likeId}, new LikeMapper());
    }

    //TODO: get number of likes

    public List<Like> getAllLikesByUserId(UUID userId) {
        List<Like> likes = new ArrayList<>();

        String sql = "select * from likes where like_user_id = '" + userId + "'";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

        for (Map row : rows) {
            Like like = new Like();
            like.setLikeId((UUID) row.get("like_id"));
            like.setUserId((UUID) row.get("like_user_id"));
            like.setDeckId((UUID) row.get("like_deck_id"));

            likes.add(like);
        }
        return likes;
    }

    public List<Like> getAllLikesByDeckId(UUID deckId) {
        List<Like> likes = new ArrayList<>();

        String sql = "select * from likes where like_deck_id = '" + deckId + "'";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

        for (Map row : rows) {
            Like like = new Like();
            like.setLikeId((UUID) row.get("like_id"));
            like.setUserId((UUID) row.get("like_user_id"));
            like.setDeckId((UUID) row.get("like_deck_id"));

            likes.add(like);
        }
        return likes;
    }

    public List<Like> getAllLikes() {
        List<Like> likes = new ArrayList<>();

        List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from likes");

        for (Map row : rows) {
            Like like = new Like();
            like.setLikeId((UUID) row.get("like_id"));
            like.setUserId((UUID) row.get("like_user_id"));
            like.setDeckId((UUID) row.get("like_deck_id"));

            likes.add(like);
        }
        return likes;
    }

    public int createLike(Like like) {

        UUID newLikeId = UUID.randomUUID();
        like.setLikeId(newLikeId);

        String sql = "insert into likes " +
                "(like_id, like_user_id, like_deck_id) values " +
                "('" + like.getLikeId() +
                "','" + like.getUserId() +
                "','" + like.getDeckId() + "')";

        return jdbcTemplate.update(sql);
    }

    public int updateLike(Like like) {
        String sql = "update likes set " +
                "like_user_id = '" + like.getUserId() +
                "', like_deck_id = '" + like.getDeckId() +
                "' where like_id = " + like.getLikeId() + "";

        return jdbcTemplate.update(sql);
    }

    public int deleteLike(UUID likeId) {
        String sql = "delete from likes where like_id = '" + likeId + "'";
        return jdbcTemplate.update(sql);
    }
}