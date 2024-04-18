package com.feedbackmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feedbackmanagement.entity.User;
import com.feedbackmanagement.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user = userService.findByUsername(username);
        return ResponseEntity.ok(user);
    }
    
    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        userService.registerUser(user);       
        return "User registration done successfully";
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
    	userService.deleteUser(id);
    	return "User deleted successfully";
    }
}
