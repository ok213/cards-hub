package com.example.regularcards.entity;

import com.example.entity.Card;
import com.example.entity.CardType;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper=false)
public class RegularCard extends Card {
    private String targetAccount;
    private Long dueDate;

    @Builder
    public RegularCard(String id, String userId, CardType type, BigDecimal amount,
                       String executionUrl, String targetAccount, Long dueDate) {
        super(id, userId, type, amount, executionUrl);
        this.targetAccount = targetAccount;
        this.dueDate = dueDate;
    }
}
