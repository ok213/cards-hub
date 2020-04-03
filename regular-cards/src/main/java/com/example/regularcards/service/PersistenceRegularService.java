package com.example.regularcards.service;

import com.example.entity.CardType;
import com.example.entity.UserData;
import com.example.regularcards.configuration.RegularProperties;
import com.example.regularcards.database.RegularRepository;
import com.example.regularcards.entity.RegularCard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class PersistenceRegularService implements RegularService {
    private final RegularProperties properties;
    private final RegularRepository regularRepository;
    private static final long DAY = 86_400_000;

    @Override
    public Flux<RegularCard> loadRegular(UserData userData) {
        Date from = new Date(userData.getCurrentDate() - DAY);
        Date to = new Date(userData.getCurrentDate() + DAY);
        return regularRepository.findByUserIdAndDueDateBetween(userData.getUserId(), from, to)
                .map(doc ->
                        RegularCard.builder()
                                .userId(userData.getUserId())
                                .dueDate(doc.getDueDate().getTime())
                                .amount(doc.getAmount())
                                .targetAccount(doc.getTargetAccount())
                                .id(doc.getId())
                                .executionUrl(properties.getExecuteUrl())
                                .type(CardType.REGULAR)
                                .build()
                );
    }
}
