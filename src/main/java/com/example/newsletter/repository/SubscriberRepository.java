package com.example.newsletter.repository;

import com.example.newsletter.model.Subscriber;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {

	Optional<Subscriber> findByEmail(String email);
}
