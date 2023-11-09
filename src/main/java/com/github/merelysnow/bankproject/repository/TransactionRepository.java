package com.github.merelysnow.bankproject.repository;

import com.github.merelysnow.bankproject.transaction.data.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    Transaction findTransactionById(int id);
}
