package com.example.microservice1.microservice1.aspect;

import io.r2dbc.pool.ConnectionPool;
import io.r2dbc.pool.PoolMetrics;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
@DependsOn("connectionPool")
public class DatabaseConnectionLoggingAspect {

    private final ConnectionPool connectionPool;

    @Autowired
    public DatabaseConnectionLoggingAspect(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Around("execution(* org.springframework.data.repository.reactive.ReactiveCrudRepository+.*(..))")
    public Object logDatabaseConnections(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Aspect triggered before proceeding with the method: {}", joinPoint.getSignature().getName());
        logConnectionPoolStats("Before");
        Object result = joinPoint.proceed();
        logConnectionPoolStats("After");
        return result;
    }

    private void logConnectionPoolStats(String timing) {
        log.info("Yes !!");

        PoolMetrics metrics = connectionPool.getMetrics().orElse(null);

        if (metrics != null) {
            int allocatedSize = metrics.allocatedSize(); // Total connections allocated
            int acquiredSize = metrics.acquiredSize();   // Active connections in use
            int idleSize = metrics.idleSize();           // Idle connections available

            System.out.printf("[%s] Total Connections Allocated: %d, Active Connections: %d, Idle Connections: %d%n",
                    timing, allocatedSize, acquiredSize, idleSize);
        } else {
            System.out.println("No connection metrics available.");
        }
    }
}