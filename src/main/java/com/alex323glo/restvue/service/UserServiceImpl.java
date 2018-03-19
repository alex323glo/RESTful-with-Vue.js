package com.alex323glo.restvue.service;

import com.alex323glo.restvue.exception.AppException;
import com.alex323glo.restvue.exception.AuthorizationException;
import com.alex323glo.restvue.exception.ValidationException;
import com.alex323glo.restvue.model.User;
import com.alex323glo.restvue.repository.UserRepository;
import com.alex323glo.restvue.util.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.alex323glo.restvue.util.Validator.validateEmail;
import static com.alex323glo.restvue.util.Validator.validatePassword;

/**
 * Implementation of User Service interface.
 *
 * Uses UserRepository implementation to serve DAO logic
 * with User entity.
 *
 * @author alex323glo
 * @version 1.0
 *
 * @see UserRepository
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Value("${user.password.min_length}")
    private int maxPasswordLength;

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Registers new User to System.
     *
     * Uses validateUserCredits() method to
     * validate email and password!
     *
     * @throws AppException if doesn't pass validation.
     *
     * @see AppException
     * @see UserServiceImpl#validateUserCredits(String, String)
     */
    @Override
    public User register(String email, String password) throws AppException {
        LOG.info("trying to register new User to System");

        validateUserCredits(email, password);

        User savedUser = userRepository.save(new User(email, password));

        LOG.info("successfully registered new User to System");
        return savedUser;
    }

    /**
     * Authorizes registered User to System.
     *
     * Uses validateUserCredits() method to
     * validate email and password!
     *
     * @throws AppException if doesn't pass validation.
     *
     * @see AppException
     * @see UserServiceImpl#validateUserCredits(String, String)
     */
    @Override
    public User login(String email, String password) throws AppException {
        LOG.info("trying to authorize new User to System");

        validateUserCredits(email, password);

        User existentUser = userRepository.findFirstByEmail(email);

        if (existentUser == null) {
            AuthorizationException exception =
                    new AuthorizationException("param email was not registered to system before");
            LOG.error("authorization failed on email search", exception);
            throw exception;
        }

        if (!password.equals(existentUser.getPassword())) {
            AuthorizationException exception =
                    new AuthorizationException("param password is not equal to registered one");
            LOG.error("authorization failed on password compare", exception);
            throw exception;
        }

        LOG.info("successfully authorized User to System");
        return existentUser;
    }

    @Override
    public List<User> showAllUsers() throws AppException {
        LOG.info("trying to list all registered Users");

        List<User> allUsers = userRepository.findAll();

        LOG.info("successfully listed all " + allUsers.size() + " registered Users");
        return allUsers;
    }

    /**
     * Validates User's email and password.
     *
     * Uses Validator to validate email and password.
     *
     * @throws ValidationException if email or/and password doesn't pass validation.
     *
     * @see ValidationException
     * @see Validator#validateEmail(String)
     * @see Validator#validatePassword(String, int)
     */
    private void validateUserCredits(String email, String password) throws ValidationException {
        if (!validateEmail(email)) {
            ValidationException exception = new ValidationException("email validation failed");
            LOG.error("validation failed", exception);
            throw exception;
        }

        if (!validatePassword(password, Validator.DEFAULT_PASSWORD_LENGTH)) {
            ValidationException exception = new ValidationException("email validation failed");
            LOG.error("validation failed", exception);
            throw exception;
        }

        LOG.info("email and password validation was passed successfully");
    }
}
