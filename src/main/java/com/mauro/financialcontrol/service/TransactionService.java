package com.mauro.financialcontrol.service;

import com.mauro.financialcontrol.model.Transaction;
import com.mauro.financialcontrol.model.TransactionType;
import com.mauro.financialcontrol.repository.TransactionRepository;
import com.mauro.financialcontrol.dto.TransactionSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    public TransactionSummary getSummary() {
        List<Transaction> transactions = transactionRepository.findAll();

        BigDecimal totalIncome = transactions.stream()
                .filter(t -> t.getType().toString().equals("INCOME"))
                .map(Transaction::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalExpense = transactions.stream()
                .filter(t -> t.getType().toString().equals("EXPENSE"))
                .map(Transaction::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal balance = totalIncome.subtract(totalExpense);

        return new TransactionSummary(totalIncome, totalExpense, balance);
    }
    public List<Transaction> filterByDate(String start, String end) {
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);

        return transactionRepository.findByDateBetween(startDate, endDate);
    }
    public List<Transaction> findByType(String type) {
        return transactionRepository.findByType(TransactionType.valueOf(type.toUpperCase()));
    }


}
