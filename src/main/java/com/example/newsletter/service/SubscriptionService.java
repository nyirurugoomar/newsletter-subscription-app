package com.example.newsletter.service;

import com.example.newsletter.model.Subscriber;
import com.example.newsletter.repository.SubscriberRepository;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {

	private final SubscriberRepository repository;
	private final EmailService emailService;

	public SubscriptionService(SubscriberRepository repository, EmailService emailService) {
		this.repository = repository;
		this.emailService = emailService;
	}

	public String subscribe(String email) {
		if (repository.findByEmail(email).isPresent()) {
			return "Email already subscribed!";
		}

		Subscriber subscriber = new Subscriber();
		subscriber.setEmail(email);
		repository.save(subscriber);

		emailService.sendSubscriptionEmail(email);

		return "Subscription successful!";
	}
}
