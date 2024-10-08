package com.example.support2.support2.repo;

import com.example.support2.support2.dto.Information;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface InformationRepository extends ReactiveCrudRepository<Information, Integer> {
//    @Query("Select * from information_table")
//    public Flux<Information> getAllInformation();
}
