package com.example.regularcards.database;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

import java.util.Date;

public interface RegularRepository extends ReactiveMongoRepository<RegularDocument, String> {
    Flux<RegularDocument> findByUserIdAndDueDateBetween(String userId, Date from, Date to);
}
