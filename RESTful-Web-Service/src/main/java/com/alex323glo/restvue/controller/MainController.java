package com.alex323glo.restvue.controller;

import com.alex323glo.restvue.exception.AppException;
import com.alex323glo.restvue.model.User;
import com.alex323glo.restvue.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * RESTful web service Controller, which must serve AJAX requests
 * (with POST method) to "/login" and "/register" endpoints.
 *
 * Uses UserService implementation to carry out "registration" and "authorization"
 * business logic.
 *
 * @author alex323glo
 * @version 1.0
 *
 * @see UserService
 */
@RestController
public class MainController {

    private static final Logger LOG = LoggerFactory.getLogger(MainController.class);

    private final UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    public User register(@RequestBody User user) throws AppException {

        LOG.info("serving \"/registration\" endpoint...");

        User registeredUser = userService.register(user.getEmail(), user.getPassword());

        LOG.info("successfully served \"/registration\" endpoint");
        return registeredUser;
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) throws AppException {

        LOG.info("serving \"/login\" endpoint...");

        User authorizedUser = userService.login(user.getEmail(), user.getPassword());

        LOG.info("successfully served \"/login\" endpoint");
        return authorizedUser;
    }

}
