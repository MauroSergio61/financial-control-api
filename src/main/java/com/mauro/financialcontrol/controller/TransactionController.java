package com.mauro.financialcontrol.controller;

import com.mauro.financialcontrol.dto.TransactionSummary;
import com.mauro.financialcontrol.model.Transaction;
import com.mauro.financialcontrol.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import java.util.List;



@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public Transaction create(@RequestBody Transaction transaction) {
        return transactionService.save(transaction);
    }

    @GetMapping
    public List<Transaction> list() {
        return transactionService.findAll();
    }
    @GetMapping("/summary")
    public Map<String, Object> summary() {
        List<Transaction> transactions = transactionService.findAll();

        BigDecimal totalIncome = transactions.stream()
                .filter(t -> t.getType().toString().equals("INCOME"))
                .map(Transaction::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalExpense = transactions.stream()
                .filter(t -> t.getType().toString().equals("EXPENSE"))
                .map(Transaction::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal balance = totalIncome.subtract(totalExpense);

        Map<String, Object> summary = new HashMap<>();
        summary.put("totalIncome", totalIncome);
        summary.put("totalExpense", totalExpense);
        summary.put("balance", balance);

        return summary;
    }
    @GetMapping("/type/{type}")
    public List<Transaction> findByType(@PathVariable String type) {
        return transactionService.findByType(type);
    }

    @GetMapping("/filter")
    public List<Transaction> filterByDate(
            @RequestParam String start,
            @RequestParam String end
    ) {
        return transactionService.filterByDate(start, end);
    }


}