    package com.example.microservice1.microservice1.repo;

    import com.example.microservice1.microservice1.dto.User;
    import org.springframework.data.r2dbc.repository.R2dbcRepository;
    import org.springframework.data.repository.reactive.ReactiveCrudRepository;
    import org.springframework.stereotype.Repository;

    @Repository
    public interface UserRepository extends ReactiveCrudRepository<User,Integer> {

    }
