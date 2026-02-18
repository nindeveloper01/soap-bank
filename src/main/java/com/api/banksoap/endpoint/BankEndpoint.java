package com.api.banksoap.endpoint;

import com.api.banksoap.entity.Account;
import com.api.banksoap.service.BankService;
import com.api.banksoap.wsdl.CreateAccountRequest;
import com.api.banksoap.wsdl.CreateAccountResponse;
import com.api.banksoap.wsdl.GetAccountRequest;
import com.api.banksoap.wsdl.GetAccountResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class BankEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/bank";

    private final BankService service;

    public BankEndpoint(BankService service) {
        this.service = service;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createAccountRequest")
    @ResponsePayload
    public CreateAccountResponse createAccount(@RequestPayload CreateAccountRequest request) {

        service.createAccount(request);

        CreateAccountResponse response = new CreateAccountResponse();
        response.setMessage("Account created successfully");
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAccountRequest")
    @ResponsePayload
    public GetAccountResponse getAccount(@RequestPayload GetAccountRequest request) {

        Account account = service.getAccount(request);

        GetAccountResponse response = new GetAccountResponse();
        response.setBalance(account.getBalance());
        response.setCurrency(account.getCurrency());

        return response;
    }
}
