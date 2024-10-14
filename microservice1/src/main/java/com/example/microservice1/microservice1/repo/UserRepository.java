    package com.example.microservice1.microservice1.repo;

    import com.example.microservice1.microservice1.customAnnotation.LogDbConnections;
    import com.example.microservice1.microservice1.dto.User;
    import org.springframework.data.repository.reactive.ReactiveCrudRepository;
    import org.springframework.stereotype.Repository;

    @LogDbConnections
    @Repository
    public interface UserRepository extends ReactiveCrudRepository<User, Integer> {


    }
