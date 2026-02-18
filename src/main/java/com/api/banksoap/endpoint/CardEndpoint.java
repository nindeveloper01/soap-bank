package com.api.banksoap.endpoint;

import com.api.banksoap.entity.Card;
import com.api.banksoap.repository.CardRepository;
import com.api.banksoap.wsdl.GetCardRequest;
import com.api.banksoap.wsdl.GetCardResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CardEndpoint {
    private static final String NAMESPACE_URI = "http://example.com/bank";
    private final CardRepository cardRepository;

    public CardEndpoint(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
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
}
