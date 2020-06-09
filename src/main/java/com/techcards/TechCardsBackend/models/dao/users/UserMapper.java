package com.techcards.TechCardsBackend.models.dao.users;

import com.techcards.TechCardsBackend.models.dao.decks.Deck;
import com.techcards.TechCardsBackend.models.dao.users.User;
import com.techcards.TechCardsBackend.models.dao.flashcards.Flashcard;
import com.techcards.TechCardsBackend.models.dao.subjects.Subject;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import java.util.UUID;

public class UserMapper implements RowMapper<User> {

    public User mapRow(ResultSet resultSet, int i) throws SQLException {

        User user = new User();
        user.setId(resultSet.getObject("user_id", UUID.class));
        user.setName(resultSet.getString("user_name"));
        user.setAbout(resultSet.getString("user_about"));
        user.setCreatedDecks((Set<Deck>) resultSet.getObject("user_created_decks"));
        user.setLikedDecks((Set<Deck>) resultSet.getObject("user_liked_decks"));

        return user;
    }
}