package com.example.finescards.service;

import com.example.entity.CardType;
import com.example.entity.UserData;
import com.example.finescards.client.EGovClient;
import com.example.finescards.configuration.FinesProperties;
import com.example.finescards.entity.FineCard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class RemoteFinesService implements FinesService {
    private final static Random rnd = new Random();
    private final FinesProperties properties;
    private final EGovClient eGovClient;

    @Override
    public Flux<FineCard> loadFines(UserData userData) {
        return eGovClient.getFines(userData.getUserId())
                .flatMapIterable(res -> res)
                .map(fine ->
                        FineCard.builder()
                                .userId(userData.getUserId())
                                .dueDate(fine.getDueDate().getTime())
                                .amount(fine.getAmount())
                                .fineType(fine.getFineType())
                                .id(fine.getId())
                                .executionUrl(properties.getExecuteUrl())
                                .type(CardType.FINES)
                                .build());
    }
}
