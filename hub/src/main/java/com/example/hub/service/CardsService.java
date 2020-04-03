package com.example.hub.service;

import com.example.entity.Card;
import com.example.entity.UserData;
import reactor.core.publisher.Flux;

public interface CardsService {
    Flux<Card> loadCards(UserData userData);
}
