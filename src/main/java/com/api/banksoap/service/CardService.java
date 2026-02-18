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
        // Prevent duplicate card numbers
        if (repository.findByCardNumber(request.getCardNumber()).isPresent()) {
            throw new RuntimeException("Card already exists!");
        }

        Card card = new Card();
        card.setCardNumber(request.getCardNumber());
        card.setCardType(request.getCardType());
        card.setExpiryDate(request.getExpiryDate());
        card.setStatus("ACTIVE"); // Default status

        repository.save(card);
    }
}