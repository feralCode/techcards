package com.techcards.TechCardsBackend.controllers;

import com.techcards.TechCardsBackend.models.dao.users.User;
import com.techcards.TechCardsBackend.models.services.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("userId") UUID userId) {
        User user = userService.getUserById(userId);
        return user;
    }
}
