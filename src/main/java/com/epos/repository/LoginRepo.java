package com.epos.repository;

import com.epos.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepo extends JpaRepository<User, Long> {

    Optional<User> findByUserNameAndUserPassword(String userName, String userPassword);
}
