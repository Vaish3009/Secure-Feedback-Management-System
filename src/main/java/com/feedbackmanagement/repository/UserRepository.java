package com.feedbackmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.feedbackmanagement.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

}

