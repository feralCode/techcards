package com.techcards.TechCardsBackend.models.services;

import com.techcards.TechCardsBackend.models.dao.users.User;
import com.techcards.TechCardsBackend.models.dao.users.User;
import com.techcards.TechCardsBackend.models.dao.users.UserDAO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User getUserById(UUID id) {
        User user = userDAO.getUserById(id);

        return user;
    }

    public List<User> getAllUsers() {
        List<User> allUsers = userDAO.getAllUsers();
        return allUsers;
    }

    public int createUser(User user) {
        return userDAO.createUser(user);
    }

    public int updateUser(User user) {
        return userDAO.updateUser(user);
    }

    public int deleteUser(UUID userId) {
        return userDAO.deleteUser(userId);
    }
}
