package com.api.banksoap.service;

import com.api.banksoap.entity.Card;
import com.api.banksoap.repository.CardRepository;
import com.api.banksoap.wsdl.CreateCardRequest;
import org.springframework.stereotype.Service;

@Service
public class CardService {
    private final CardRepository repository;

    public CardService(CardRepository repository) {
        this.repository = repository;
    }

    public void saveCard(CreateCardRequest request) {
        // Basic validation to prevent nulls in DB
        if (request.getCardNumber() == null || request.getCardNumber().isEmpty()) throw new RuntimeException("Card number is required");

        Card card = new Card();
        card.setCardNumber(request.getCardNumber());
        card.setCardType(request.getCardType());
        card.setExpiryDate(request.getExpiryDate());
        card.setStatus("ACTIVE");

        repository.save(card);
    }
}