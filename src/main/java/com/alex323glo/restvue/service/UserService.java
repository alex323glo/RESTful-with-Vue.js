package com.alex323glo.restvue.service;

import com.alex323glo.restvue.exception.AppException;
import com.alex323glo.restvue.model.User;

import java.util.List;

/**
 * User Service, which serves "registration" and "authorization"
 * business logic with User entity.
 *
 * See more in implementations.
 *
 * @author alex323glo
 * @version 1.0
 *
 * @see User
 * @see AppException
 */
public interface UserService {

    User register(String email, String password) throws AppException;

    User login(String email, String password) throws AppException;

    List<User> showAllUsers() throws AppException;

}
