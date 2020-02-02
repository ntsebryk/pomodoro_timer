package com.ntsebryk.timemate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	
	@Autowired
	JavaMailSender mailSender;
	
	public void sendMessage(SimpleMailMessage mailMessage) {
		mailSender.send(mailMessage);
	}
}
