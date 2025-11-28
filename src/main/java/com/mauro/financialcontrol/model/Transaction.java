package com.mauro.financialcontrol.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private BigDecimal value;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    private LocalDate date;

   // @ManyToOne
    //@JoinColumn(name = "user_id")
    //private User user;

    public Transaction() {
    }

    public Transaction(String description, BigDecimal value, TransactionType type, LocalDate date, User user) {
        this.description = description;
        this.value = value;
        this.type = type;
        this.date = date;
      //  this.user = user;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    // getters and setters
}