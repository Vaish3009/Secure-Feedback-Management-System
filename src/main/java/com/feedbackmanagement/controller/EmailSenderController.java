package com.feedbackmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.feedbackmanagement.service.EmailSenderService;



public class EmailSenderController {

	@Autowired
	private EmailSenderService senderService;
	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail(){
		senderService.sendSimpleEmail("vaishnavikasture93@gmail.com", 
				"This is the Email Body...", 
				"This is the Email Subject...");
	}
}
