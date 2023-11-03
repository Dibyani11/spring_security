package com.Spring_Security_Demoo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Spring_Security_Demoo.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

	User findById(long id);

	Optional<User> findByFirstName(String username);
}
