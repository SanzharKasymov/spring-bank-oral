package com.example.springbankoral.modules.transaction.mapper;


import com.example.springbankoral.modules.transaction.dto.TransactionRequest;
import com.example.springbankoral.modules.transaction.entity.TransactionEntity;
import com.example.springbankoral.modules.transaction.dto.TransactionResponse;
import com.example.springbankoral.modules.transaction.entity.TransactionStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransactionMapper {

    public TransactionResponse toResponse(TransactionEntity e) {
        return new TransactionResponse(
                e.getId(),
                e.getAmount(),
                e.getCurrencyCode(),
                e.getStatus().name(),
                e.getCreatedAt()
        );
    }

    public TransactionEntity toEntity(TransactionRequest r) {
        return TransactionEntity.builder()
                .fromAccountId(r.fromAccountId())
                .toAccountId(r.toAccountId())
                .amount(r.amount())
                .currencyCode(r.currencyCode())
                .status(TransactionStatus.PENDING)
                .createdAt(LocalDateTime.now())
                .build();
    }
}