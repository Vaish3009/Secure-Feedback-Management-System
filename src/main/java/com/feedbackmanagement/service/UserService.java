package com.feedbackmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedbackmanagement.entity.Feedback;
import com.feedbackmanagement.entity.User;
import com.feedbackmanagement.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

	public User registerUser(User user) {
		return userRepository.save(user);
	}
	
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

//	public void editFeedback(Long UserId, Feedback feedback) {
//		User user = userRepository.findById(userId);
//		user.g
//		userRepository.save(feedback);
//		
//	}
}
