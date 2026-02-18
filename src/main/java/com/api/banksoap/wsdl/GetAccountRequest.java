package com.api.banksoap.wsdl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

@XmlRootElement(name = "getAccountRequest", namespace = "http://example.com/bank")
@XmlAccessorType(XmlAccessType.FIELD)
@Setter
@Getter
public class GetAccountRequest {

    @XmlElement(namespace = "http://example.com/bank", required = true)
    private String accountNumber;
}