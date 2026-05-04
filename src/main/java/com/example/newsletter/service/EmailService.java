package com.example.newsletter.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	private final JavaMailSender mailSender;

	@Value("${spring.mail.username}")
	private String fromEmail;

	public EmailService(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void sendSubscriptionEmail(String toEmail) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(toEmail);
		message.setSubject("Subscription Confirmed");
		message.setText(
				"""
				Hi there,

				Thank you for subscribing to our newsletter! 🎉

				You’ll now receive the latest updates, news, and exclusive content straight to your inbox.

				If you ever wish to unsubscribe, you can do so at any time using the link in our emails.

				Welcome aboard!

				Best regards
				""".stripIndent());
		message.setFrom(fromEmail);

		mailSender.send(message);
	}
}
