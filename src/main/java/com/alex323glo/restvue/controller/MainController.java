package com.alex323glo.restvue.controller;

import com.alex323glo.restvue.exception.AppException;
import com.alex323glo.restvue.model.User;
import com.alex323glo.restvue.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/register")
    public User register(
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password
    ) throws AppException {

        LOG.info("serving \"/register\" endpoint...");

        User registeredUser = userService.register(email, password);

        LOG.info("successfully served \"/register\" endpoint");
        return registeredUser;
    }

    @PostMapping("/login")
    public User login(
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password
    ) throws AppException {

        LOG.info("serving \"/login\" endpoint...");

        User authorizedUser = userService.login(email, password);

        LOG.info("successfully served \"/login\" endpoint");
        return authorizedUser;
    }

}
