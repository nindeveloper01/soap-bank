package com.api.banksoap.wsdl;


import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

@XmlRootElement(name = "getCardRequest", namespace = "http://example.com/bank")
@XmlAccessorType(XmlAccessType.FIELD)
@Setter
@Getter
public class GetCardRequest {

    @XmlElement(namespace = "http://example.com/bank", required = true)
    private String cardNumber;

}
