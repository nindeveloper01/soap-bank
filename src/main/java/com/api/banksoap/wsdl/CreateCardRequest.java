package com.api.banksoap.wsdl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

@XmlRootElement(name = "createCardRequest", namespace = "http://example.com/bank")
@XmlAccessorType(XmlAccessType.FIELD)
@Setter
@Getter
public class CreateCardRequest {
    @XmlElement(namespace = "http://example.com/bank", required = true)
    private String cardNumber;
    @XmlElement(namespace = "http://example.com/bank", required = true)
    private String cardType;
    @XmlElement(namespace = "http://example.com/bank", required = true)
    private String expiryDate;

}