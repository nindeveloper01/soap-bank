package com.api.banksoap.wsdl;


import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

@XmlRootElement(name = "getCardResponse", namespace = "http://example.com/bank")
@XmlAccessorType(XmlAccessType.FIELD)
@Setter
@Getter
public class GetCardResponse {

    @XmlElement(namespace = "http://example.com/bank")
    private String cardType;

    @XmlElement(namespace = "http://example.com/bank")
    private String expiryDate;

    @XmlElement(namespace = "http://example.com/bank")
    private String status;
}