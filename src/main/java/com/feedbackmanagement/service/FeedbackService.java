package com.feedbackmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedbackmanagement.entity.Feedback;
import com.feedbackmanagement.entity.User;
import com.feedbackmanagement.repository.FeedbackRepository;
import com.feedbackmanagement.repository.UserRepository;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;
    @Autowired
    private EmailSenderService emailSenderService;
    @Autowired
    private UserRepository userRepository;
    public List<Feedback> getFeedbackByUser(User user) {
        return feedbackRepository.findByAppUser(user);
    }

//	public Feedback submitFeedback(Feedback feedback) {
//		return feedbackRepository.save(feedback);
//	}
    public Feedback submitFeedback(Feedback feedback,Long userId) {
    	User user = userRepository.findById(userId).get();
    	feedback.setAppUser(user);
        Feedback savedFeedback = feedbackRepository.save(feedback);
        
        // Send email notification after feedback submission
        String toEmail = "vaishnavikasture93@gmail.com"; // Specify the recipient's email address
        String subject = "New Feedback Submitted";
        String body = "A new feedback has been submitted:\n\nTitle: " + savedFeedback.getTitle() + "\nDescription: " + savedFeedback.getDescription();
        emailSenderService.sendSimpleEmail(toEmail, body, subject);
    
        return savedFeedback;
    }
	
	public Feedback editFeedback(Long id,Feedback feedback) {
		return feedbackRepository.save(feedback);
	}
}
