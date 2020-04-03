package com.example.finescards.service;

import com.example.entity.UserData;
import com.example.finescards.entity.FineCard;
import reactor.core.publisher.Flux;

public interface FinesService {
    Flux<FineCard> loadFines(UserData userData);
}
