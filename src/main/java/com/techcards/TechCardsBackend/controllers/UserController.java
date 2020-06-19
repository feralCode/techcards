package com.techcards.TechCardsBackend.controllers;

import com.techcards.TechCardsBackend.models.dao.users.User;
import com.techcards.TechCardsBackend.models.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("userId") UUID userId) {
        User user = userService.getUserById(userId);
        return user;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        List<User> allUsers = userService.getAllUsers();
        return allUsers;
    }

    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
    public String createUser(@RequestBody User user) {
        userService.createUser(user);
        return "redirect:/all";
    }

    @RequestMapping(value="/editUser/{userId}")
    public User editUser(@PathVariable("userId") UUID userId, User user) {
        userService.getUserById(userId);
        return user;
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.PUT)
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/all";
    }

    @RequestMapping(value="/deleteUser/{userId}",method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("userId") UUID userId) {
        userService.deleteUser(userId);
        return "redirect:/all";
    }
}
