package com.api.banksoap.wsdl;


import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAccessType;
import lombok.Getter;
import lombok.Setter;

@XmlRootElement(name = "createAccountRequest", namespace = "http://example.com/bank")
@XmlAccessorType(XmlAccessType.FIELD)
@Setter
@Getter
public class CreateAccountRequest {

    @XmlElement(namespace = "http://example.com/bank", required = true)
    private String accountNumber;

    @XmlElement(namespace = "http://example.com/bank", required = true)
    private Double balance;

    @XmlElement(namespace = "http://example.com/bank", required = true)
    private String currency;
}
