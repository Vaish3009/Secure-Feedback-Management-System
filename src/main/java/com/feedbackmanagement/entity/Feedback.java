package com.feedbackmanagement.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Feedback implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime submittedAt;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("feedbackList")
    private User appUser;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getSubmittedAt() {
		return submittedAt;
	}
	public void setSubmittedAt(LocalDateTime submittedAt) {
		this.submittedAt = submittedAt;
	}
	public User getAppUser() {
		return appUser;
	}
	public void setAppUser(User appUser) {
		this.appUser = appUser;
	}
	
    
    
}
