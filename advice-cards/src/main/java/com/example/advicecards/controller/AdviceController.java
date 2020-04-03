package com.example.advicecards.controller;

import com.example.advicecards.entity.AdviceCard;
import com.example.advicecards.service.AdviceService;
import com.example.entity.GeoPosition;
import com.example.entity.UserData;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
public class AdviceController {

    private final AdviceService adviceService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<AdviceCard> loadAdvices(@RequestHeader("userId") String userId,
                                        @RequestHeader("longitude") BigDecimal longitude,
                                        @RequestHeader("latitude") BigDecimal latitude,
                                        @RequestParam("currentDate") Long currentDate) {
        return adviceService.defineAdvices(UserData.builder()
                .currentDate(currentDate)
                .userId(userId)
                .geoPosition(GeoPosition.builder()
                        .latitude(latitude)
                        .longitude(longitude)
                        .build())
                .build());
    }
}
