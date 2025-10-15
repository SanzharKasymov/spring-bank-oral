package com.example.springbankoral.modules.transaction.dto;

import java.math.BigDecimal;

public record TransactionRequest(
        Long fromAccountId,
        Long toAccountId,
        BigDecimal amount,
        String currencyCode
) {}
