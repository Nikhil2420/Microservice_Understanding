package com.example.microservice1.microservice1.service.impl;

import org.slf4j.MDC;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TracingService {

    public String generateTraceId() {
        String traceId = UUID.randomUUID().toString();
        // Set traceId in MDC (Mapped Diagnostic Context) to propagate it in logs
        MDC.put("traceId", traceId);
        return traceId;
    }

    public void clearTraceId() {
        MDC.remove("traceId");
    }
}