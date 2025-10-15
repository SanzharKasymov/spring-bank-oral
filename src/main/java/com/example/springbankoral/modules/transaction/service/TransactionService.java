package com.example.springbankoral.modules.transaction.service;

import com.example.springbankoral.modules.transaction.dto.TransactionRequest;
import com.example.springbankoral.modules.transaction.dto.TransactionResponse;
import java.util.List;

public interface TransactionService {
    TransactionResponse create(TransactionRequest request);
    List<TransactionResponse> findAll();
    TransactionResponse findById(Long id);
}