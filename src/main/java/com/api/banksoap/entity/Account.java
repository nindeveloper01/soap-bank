package com.api.banksoap.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "accounts")
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Added unique and nullable constraints
    @Column(unique = true, nullable = false)
    private String accountNumber;

    private Double balance;

    private String currency;
}