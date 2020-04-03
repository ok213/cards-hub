package com.example.advicecards.entity;

import com.example.entity.Card;
import com.example.entity.CardType;
import lombok.*;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper=false)
@RequiredArgsConstructor
public class AdviceCard extends Card {

    private AdviceType adviceType;

    @Builder
    public AdviceCard(String id, String userId, CardType type, BigDecimal amount, String executionUrl, AdviceType adviceType) {
        super(id, userId, type, amount, executionUrl);
        this.adviceType = adviceType;
    }
}
