package com.api.banksoap.service;

import com.api.banksoap.entity.Account;
import com.api.banksoap.repository.AccountRepository;
import com.api.banksoap.wsdl.CreateAccountRequest;
import com.api.banksoap.wsdl.GetAccountRequest;
import org.springframework.stereotype.Service;

@Service
public class BankService {

    private final AccountRepository repository;

    public BankService(AccountRepository repository) {
        this.repository = repository;
    }

    public Account createAccount(CreateAccountRequest request) {
        // Check for null/empty input
        if (request.getAccountNumber()== null || request.getAccountNumber().trim().isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be empty");
        }

        // Check if account already exists to avoid duplicates
        if (repository.findByAccountNumber(request.getAccountNumber()).isPresent()) {
            throw new RuntimeException("Account already exists with number: " + request.getAccountNumber());
        }

        Account account = new Account();
        account.setAccountNumber(request.getAccountNumber());
        account.setBalance(request.getBalance());
        account.setCurrency(request.getCurrency());

        return repository.save(account);
    }

    public Account getAccount(GetAccountRequest request) {
        return repository.findByAccountNumber(request.getAccountNumber())
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }
}
