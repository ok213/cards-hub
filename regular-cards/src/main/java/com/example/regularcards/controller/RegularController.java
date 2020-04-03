package com.example.regularcards.controller;

import com.example.entity.UserData;
import com.example.regularcards.entity.RegularCard;
import com.example.regularcards.service.RegularService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class RegularController {
    private final RegularService regularService;


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<RegularCard> loadRegular(@RequestHeader("userId") String userId,
                                         @RequestParam("currentDate") Long currentDate) {
        return regularService.loadRegular(UserData.builder()
                .currentDate(currentDate)
                .userId(userId)
                .build())
                .log();
    }
}
