package com.alex323glo.restvue.repository;

import com.alex323glo.restvue.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA Repository, which is used to carry out
 * CRUD operations and "search by email" DAO logic.
 *
 * @author alex323glo
 * @version 1.0
 *
 * @see User
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findFirstByEmail(String email);

}
