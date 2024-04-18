package com.feedbackmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.feedbackmanagement.entity.Feedback;
import com.feedbackmanagement.entity.User;
@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
	List<Feedback> findByAppUser(User user);

	<S extends Feedback> S save(S feedback);
}
