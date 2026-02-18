package com.api.banksoap.wsdl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

@XmlRootElement(name = "createAccountResponse", namespace = "http://example.com/bank")
@XmlAccessorType(XmlAccessType.FIELD)
@Setter
@Getter
public class CreateAccountResponse {

    @XmlElement(required = true)
    private String message;
}