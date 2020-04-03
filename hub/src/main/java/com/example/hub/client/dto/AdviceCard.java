package com.example.hub.client.dto;

import com.example.entity.Card;
import com.example.entity.CardType;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class AdviceCard extends Card {
    private AdviceType adviceType;

    @Builder
    public AdviceCard(String id, String userId, CardType type, BigDecimal amount, String executionUrl, AdviceType adviceType) {
        super(id, userId, type, amount, executionUrl);
        this.adviceType = adviceType;
    }

    public enum AdviceType {
        GIFT,
        TAXI,
        CURRENCY;

        public static AdviceType fromInt(int i) {
            return AdviceType.values()[i];
        }
    }
}
