package com.example.springbankoral.modules.transaction.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.example.springbankoral.modules.transaction.dto.*;
import com.example.springbankoral.modules.transaction.entity.*;
import com.example.springbankoral.modules.transaction.mapper.TransactionMapper;
import com.example.springbankoral.modules.transaction.repository.TransactionRepository;
import com.example.springbankoral.modules.transaction.service.TransactionService;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;
    private final TransactionMapper mapper;

    @Override
    public TransactionResponse create(TransactionRequest request) {
        TransactionEntity entity = TransactionEntity.builder()
                .fromAccountId(request.fromAccountId())
                .toAccountId(request.toAccountId())
                .amount(request.amount())
                .currencyCode(request.currencyCode())
                .status(TransactionStatus.PENDING)
                .createdAt(LocalDateTime.now())
                .build();

        repository.save(entity);
        return mapper.toResponse(entity);
    }

    @Override
    public List<TransactionResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public TransactionResponse findById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new IllegalArgumentException("Transaction not found"));
    }
}