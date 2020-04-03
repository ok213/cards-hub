package com.example.advicecards.service;

import com.example.advicecards.configuration.AdviceProperties;
import com.example.advicecards.entity.AdviceCard;
import com.example.advicecards.entity.AdviceType;
import com.example.entity.CardType;
import com.example.entity.UserData;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class AIAdviceService implements AdviceService {

    private final static Random rnd = new Random();
    private final AdviceProperties adviseProperties;

    @Override
    public Flux<AdviceCard> defineAdvices(UserData userData) {
        final Stream<AdviceCard> cardStream = IntStream.range(0, 10)
                .mapToObj(ind -> AdviceCard.builder()
                        .userId(userData.getUserId())
                        .amount(BigDecimal.valueOf(rnd.nextLong()))
                        .adviceType(AdviceType.fromInt(rnd.nextInt(AdviceType.values().length - 1)))
                        .id(UUID.randomUUID().toString())
                        .executionUrl(adviseProperties.getExecuteUrl())
                        .type(CardType.ADVISE)
                        .build());
        return Flux.fromStream(cardStream);
    }
}
