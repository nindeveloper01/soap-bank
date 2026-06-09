# Spring SOAP Banking Service

A simple Spring Boot SOAP Web Service example demonstrating account creation and account retrieval using Spring Web Services (Spring-WS).

## Prerequisites

* Java 21+
* Maven 3.9+
* Git
* SoapUI

---

# Clone the Repository

```bash
git clone https://github.com/your-username/bank-soap-service.git

cd bank-soap-service
```

---

# Build the Project

Using Maven:

```bash
mvn clean package
```

Or using Maven Wrapper:

```bash
./mvnw clean package
```

Windows:

```cmd
mvnw.cmd clean package
```

---

# Run the Application

Using Maven:

```bash
mvn spring-boot:run
```

Or using Maven Wrapper:

```bash
./mvnw spring-boot:run
```

Windows:

```cmd
mvnw.cmd spring-boot:run
```

Application starts on:

```text
http://localhost:8080
```

---

# Verify WSDL

After the application starts, verify that the WSDL is accessible:

```text
http://localhost:8080/ws/bank.wsdl
```

Open the URL in your browser. You should see the generated WSDL document.

---

# WSDL Configuration

Example Spring-WS configuration:

```java
@Bean(name = "bank")
public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema bankSchema) {
    DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
    wsdl11Definition.setPortTypeName("BankPort");
    wsdl11Definition.setLocationUri("/ws");
    wsdl11Definition.setTargetNamespace("http://example.com/bank");
    wsdl11Definition.setSchema(bankSchema);
    return wsdl11Definition;
}
```

---

# Testing with SoapUI

## Step 1: Create a New SOAP Project

Open SoapUI and navigate to:

```text
File
 └── New SOAP Project
```

---

## Step 2: Import WSDL

Enter:

```text
Project Name: BankService

Initial WSDL:
http://localhost:8080/ws/bank.wsdl
```

Click **OK**.

SoapUI will automatically generate SOAP requests from the WSDL.

---

## Available Operations

```text
createAccountRequest
getAccountRequest
```

---

# Create Account

## Request

```xml
<soapenv:Envelope
    xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
    xmlns:ban="http://example.com/bank">

   <soapenv:Header/>

   <soapenv:Body>
      <ban:createAccountRequest>
         <ban:accountNumber>10001</ban:accountNumber>
         <ban:holderName>John Doe</ban:holderName>
         <ban:balance>1000</ban:balance>
         <ban:currency>USD</ban:currency>
      </ban:createAccountRequest>
   </soapenv:Body>

</soapenv:Envelope>
```

## Expected Response

```xml
<SOAP-ENV:Envelope
    xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">

   <SOAP-ENV:Body>
      <ns2:createAccountResponse
          xmlns:ns2="http://example.com/bank">
         <ns2:message>
            Account created successfully
         </ns2:message>
      </ns2:createAccountResponse>
   </SOAP-ENV:Body>

</SOAP-ENV:Envelope>
```

---

# Get Account

## Request

```xml
<soapenv:Envelope
    xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
    xmlns:ban="http://example.com/bank">

   <soapenv:Header/>

   <soapenv:Body>
      <ban:getAccountRequest>
         <ban:accountNumber>10001</ban:accountNumber>
      </ban:getAccountRequest>
   </soapenv:Body>

</soapenv:Envelope>
```

## Expected Response

```xml
<SOAP-ENV:Envelope
    xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">

   <SOAP-ENV:Body>
      <ns2:getAccountResponse
          xmlns:ns2="http://example.com/bank">

         <ns2:balance>1000</ns2:balance>
         <ns2:currency>USD</ns2:currency>

      </ns2:getAccountResponse>
   </SOAP-ENV:Body>

</SOAP-ENV:Envelope>
```

---

# SOAP Endpoint

SOAP requests should be sent to:

```text
http://localhost:8080/ws
```

Do not send requests directly to:

```text
http://localhost:8080/createAccount
```

Spring-WS routes requests based on the payload root element:

```java
@PayloadRoot(
    namespace = "http://example.com/bank",
    localPart = "createAccountRequest"
)
```

and

```java
@PayloadRoot(
    namespace = "http://example.com/bank",
    localPart = "getAccountRequest"
)
```

---

# Project Structure

```text
src
└── main
    ├── java
    │   └── com.example.bank
    │       ├── config
    │       ├── endpoint
    │       ├── service
    │       ├── repository
    │       ├── entity
    │       └── dto
    └── resources
        └── bank.xsd
```

---

# Troubleshooting

## WSDL Not Found

Verify:

```text
http://localhost:8080/ws/bank.wsdl
```

is accessible.

## 404 Error

Check:

```java
@EnableWs
```

is configured and `LocationUri` is set correctly.

## SOAP Request Not Routed

Verify:

* Namespace matches exactly.
* Root element name matches `@PayloadRoot`.
* SOAP request is sent to `/ws`.

---

# Technologies

* Java 21
* Spring Boot
* Spring Web Services (Spring-WS)
* JAXB
* Maven
* SOAP
* WSDL
* XSD
* SoapUI
