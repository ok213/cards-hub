package com.example.advicecards.service;

import com.example.advicecards.entity.AdviceCard;
import com.example.entity.UserData;
import reactor.core.publisher.Flux;

public interface AdviceService {
    Flux<AdviceCard> defineAdvices(UserData userData);
}
