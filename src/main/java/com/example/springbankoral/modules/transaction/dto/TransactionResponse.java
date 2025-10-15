package com.example.springbankoral.modules.transaction.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionResponse(
        Long id,
        BigDecimal amount,
        String currencyCode,
        String status,
        LocalDateTime createdAt
) {}