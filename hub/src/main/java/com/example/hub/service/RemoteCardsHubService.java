package com.example.hub.service;

import com.example.entity.Card;
import com.example.entity.UserData;
import com.example.hub.client.CardClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RemoteCardsHubService implements CardsService {
    private final List<CardClient> cardClients;

    @Override
    public Flux<Card> loadCards(UserData userData) {
        final List<Flux<Card>> fluxList = cardClients.stream()
                .map(client -> getCards(userData, client))
                .collect(Collectors.toList());
        return Flux.merge(fluxList);
    }

    @SuppressWarnings("unchecked")
    private Flux<Card> getCards(UserData userData, CardClient client) {
        return client.getCards(userData.getUserId(),
                userData.getGeoPosition().getLongitude(), userData.getGeoPosition().getLatitude(),
                userData.getCurrentDate())
                .onErrorResume(err -> Flux.empty())
                .take(Duration.ofSeconds(6));
    }
}
