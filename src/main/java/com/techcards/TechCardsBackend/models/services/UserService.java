package com.techcards.TechCardsBackend.models.services;

import com.techcards.TechCardsBackend.models.dao.users.User;
import com.techcards.TechCardsBackend.models.dao.users.UserDAO;
import org.springframework.stereotype.Service;

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
}
