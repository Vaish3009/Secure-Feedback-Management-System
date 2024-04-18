package com.feedbackmanagement.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feedbackmanagement.entity.Feedback;
import com.feedbackmanagement.entity.User;
import com.feedbackmanagement.service.FeedbackService;
import com.feedbackmanagement.service.UserService;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;
    @Autowired
    private UserService userService;
    @PostMapping("/submit/{user_id}")
    public String submitFeedback(@RequestBody Feedback feedback, @PathVariable Long user_id) {
        feedbackService.submitFeedback(feedback,user_id);
        return "Thank you for submitting your feedback";
    }
    @GetMapping("/user/{username}")
    public ResponseEntity<List<Feedback>> getFeedbackByUser(@PathVariable String username) {
        User user = userService.findByUsername(username);
        List<Feedback> feedbackList = feedbackService.getFeedbackByUser(user);
        return ResponseEntity.ok(feedbackList);
    }
//    @PutMapping("/user/{id}")
//    public String editFeedback(@PathVariable Long id,@RequestBody Feedback feedback) {
//    	userService.editFeedback(id,feedback);
//    	return "Your response is edited";
//    }
}
