package com.api.banksoap.endpoint;

import com.api.banksoap.entity.Card;
import com.api.banksoap.repository.CardRepository;
import com.api.banksoap.service.CardService;
import com.api.banksoap.wsdl.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CardEndpoint {
    private static final String NAMESPACE_URI = "http://example.com/bank";
    private final CardRepository cardRepository;
    private final CardService cardService;
    public CardEndpoint(CardRepository cardRepository, CardService cardService) {
        this.cardRepository = cardRepository;
        this.cardService = cardService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCardRequest")
    @ResponsePayload
    public GetCardResponse getCard(@RequestPayload GetCardRequest request) {
        Card card = cardRepository.findByCardNumber(request.getCardNumber())
                .orElseThrow(() -> new RuntimeException("Card not found"));

        GetCardResponse response = new GetCardResponse();
        response.setCardType(card.getCardType());
        response.setExpiryDate(card.getExpiryDate());
        response.setStatus(card.getStatus());
        return response;
    }

    @PayloadRoot(namespace = "http://example.com/bank", localPart = "createCardRequest")
    @ResponsePayload
    public CreateCardResponse createCard(@RequestPayload CreateCardRequest request) {

        cardService.saveCard(
                request
        );

        CreateCardResponse response = new CreateCardResponse();
        response.setMessage("Card created successfully!");
        response.setStatus("SUCCESS");
        return response;
    }

}
