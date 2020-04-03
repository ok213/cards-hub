package com.example.regularcards.service;

import com.example.entity.UserData;
import com.example.regularcards.entity.RegularCard;
import reactor.core.publisher.Flux;

public interface RegularService {
    Flux<RegularCard> loadRegular(UserData userData);
}
