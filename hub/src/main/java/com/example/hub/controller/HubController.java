package com.example.hub.controller;

import com.example.entity.Card;
import com.example.entity.GeoPosition;
import com.example.entity.UserData;
import com.example.hub.service.CardsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("hub")
@RequiredArgsConstructor
public class HubController {
    private final CardsService cardsService;

    @RequestMapping(method = GET, value = "/cards", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Card> loadCards(@RequestHeader("userId") String userId,
                                @RequestHeader("longitude") BigDecimal longitude,
                                @RequestHeader("latitude") BigDecimal latitude,
                                @RequestParam("currentDate") Long currentDate) {
        return cardsService.loadCards(UserData.builder()
                .currentDate(currentDate)
                .userId(userId)
                .geoPosition(GeoPosition.builder()
                        .latitude(latitude)
                        .longitude(longitude)
                        .build())
                .build());
    }
}
