package com.example.microservice1.microservice1.service.impl;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class MetricsService {

    private final AtomicInteger userCreationCount = new AtomicInteger(0);

    public void incrementUserCreationCount() {
        userCreationCount.incrementAndGet();
    }

    public int getUserCreationCount() {
        return userCreationCount.get();
    }
}
