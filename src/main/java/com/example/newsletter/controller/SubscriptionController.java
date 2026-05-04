package com.example.newsletter.controller;

import com.example.newsletter.dto.SubscriptionRequest;
import com.example.newsletter.service.SubscriptionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subscribe")
public class SubscriptionController {

	private final SubscriptionService service;

	public SubscriptionController(SubscriptionService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<String> subscribe(@RequestBody @Valid SubscriptionRequest request) {
		return ResponseEntity.ok(service.subscribe(request.getEmail()));
	}
}
