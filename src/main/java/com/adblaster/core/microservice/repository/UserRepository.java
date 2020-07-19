package com.adblaster.core.microservice.repository;

import com.adblaster.core.microservice.model.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by stephan on 20.03.16.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findFirstByEmail(String email);
}
