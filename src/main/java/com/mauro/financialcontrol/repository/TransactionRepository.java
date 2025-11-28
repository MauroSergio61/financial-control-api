package com.mauro.financialcontrol.repository;

import com.mauro.financialcontrol.model.Transaction;
import com.mauro.financialcontrol.model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByDateBetween(LocalDate start, LocalDate end);

    List<Transaction> findByType(TransactionType type);
}
