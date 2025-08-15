package com.in28minutes.springboot.microservice.example.forex;

import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends JpaRepository<@NonNull ExchangeValue, @NonNull Long> {

    ExchangeValue findByFromAndTo(String from, String to);
}