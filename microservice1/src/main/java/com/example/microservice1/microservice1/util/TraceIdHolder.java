package com.example.microservice1.microservice1.util;


public class TraceIdHolder {
    private static final ThreadLocal<String> traceIdHolder = new ThreadLocal<>();

    public static void set(String traceId) {
        traceIdHolder.set(traceId);
    }

    public static String get() {
        return traceIdHolder.get();
    }

    public static void clear() {
        traceIdHolder.remove();
    }
}