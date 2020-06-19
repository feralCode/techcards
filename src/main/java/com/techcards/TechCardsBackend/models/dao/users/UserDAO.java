package com.techcards.TechCardsBackend.models.dao.users;

import com.techcards.TechCardsBackend.models.dao.decks.Deck;
import com.techcards.TechCardsBackend.models.dao.decks.DeckDAO;
import com.techcards.TechCardsBackend.models.dao.likes.Like;
import com.techcards.TechCardsBackend.models.dao.likes.LikeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.*;

@Component
public class UserDAO {
    JdbcTemplate jdbcTemplate;
    DeckDAO deckDAO;
    LikeDAO likeDAO;

    @Autowired
    public UserDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public User getUserById(UUID userId) {
        User currentUser = jdbcTemplate.queryForObject("select * from users where user_id = ?", new Object[] {userId}, new UserMapper());
        //TODO: get list of liked and created decks for each user
//        currentUser.setCreatedDecks(deckDAO.getAllDecksByCreatorId(userId));
//
//        List<Like> userLikes = likeDAO.getAllLikesByUserId(userId);
//        List<Deck> deckList = new ArrayList<>();
//
//        for (Like like : userLikes){
//            Deck deck = deckDAO.getDeckById(like.getDeckId());
//            deckList.add(deck);
//        }
//
//        currentUser.setLikedDecks(deckList);

        return currentUser;
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from users");

        for (Map row : rows) {
            User user = new User();
            user.setId((UUID) row.get("user_id"));
            user.setName((String) row.get("user_name"));
            user.setAbout((String) row.get("user_about"));

            users.add(user);
        }
        return users;
    }

    public int createUser(User user) {

        UUID newUserId = UUID.randomUUID();
        user.setId(newUserId);

        String sql = "insert into users " +
                "(user_id, user_name, user_about) values " +
                "('" + user.getId() +
                "','" + user.getName() +
                "','" + user.getAbout() + "');";

        return jdbcTemplate.update(sql);
    }

    public int updateUser(User user) {
        String sql = "update users set " +
                "user_name = '" + user.getName() +
                "', user_about = '" + user.getAbout() +
                "' where user_id = '" + user.getId() + "'";

        return jdbcTemplate.update(sql);
    }

    public int deleteUser(UUID userId) {
        String sql = "delete from users where user_id = '" + userId + "'";
        return jdbcTemplate.update(sql);
    }
}
