package com.example.finescards.client.dto;

import com.example.finescards.entity.FineType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
public class FineDTO {
    private String id;
    private BigDecimal amount;
    private FineType fineType;
    private Date dueDate;
}
