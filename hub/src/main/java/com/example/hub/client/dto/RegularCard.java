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
